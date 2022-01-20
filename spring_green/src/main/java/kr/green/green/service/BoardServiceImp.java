package kr.green.green.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.green.dao.BoardDAO;
import kr.green.green.pagination.Criteria;
import kr.green.green.utils.UploadFileUtils;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;
	//집 저장경로
	//String uploadPath = "C:\\Users\\dudgu\\OneDrive\\바탕 화면\\GIT\\upload";
	//학원 저장경로
	String uploadPath = "D:\\JAVA_JYH\\upload";
	
	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		return boardDao.getBoardList(cri);
	}
	//게시글 파일정보 가져오는 셀렉트
	@Override
	public List<FileVO> getFileList(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		
		return boardDao.selectFileList(bd_num);
	}
	//게시글 정보 가져오는 셀렉트
	@Override
	public BoardVO getBoard(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		return boardDao.getBoard(bd_num);
	}
	//게시글 정보 가져오는 셀렉트
	@Override
	public BoardVO getBoard(Integer bd_num, MemberVO user) {
		if(bd_num == null || bd_num <= 0)
			return null;
		BoardVO board = boardDao.getBoard(bd_num);
		if(board == null || !board.getBd_me_id().equals(user.getMe_id()))
			return null;
		return board;
	}
	//게시글 작성 관련 인설트
	@Override
	public void registerBoard(BoardVO board, List<MultipartFile> files) throws Exception {
		if(board == null 
				|| board.getBd_title() == null
				|| board.getBd_contents() == null
				|| board.getBd_me_id() == null)
			return;
		boardDao.insertBoard(board);
		uploadFile(files, board.getBd_num());
	}
	
	//게시글 삭제관련 업데이트
	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		BoardVO board = boardDao.getBoard(bd_num);
		if(bd_num == null || bd_num <= 0 || board == null || !board.getBd_me_id().equals(user.getMe_id()))
			return;
		
		boardDao.deleteBoard(bd_num);
		List<FileVO> fileList = boardDao.selectFileList(bd_num);
		deleteFile(fileList);
		
	}
	//게시글 수정관련 업데이트
	@Override
	public void updateBoard(BoardVO board, List<MultipartFile> files, Integer[] fileNums) {
		BoardVO dbBoard = boardDao.getBoard(board.getBd_num());
		dbBoard.setBd_title(board.getBd_title());
		dbBoard.setBd_contents(board.getBd_contents());
		dbBoard.setBd_up_date(new Date());
		boardDao.updateBoard(dbBoard);
		
		List<FileVO> fileList = boardDao.selectFileList(board.getBd_num());
		
		if(fileList != null && fileList.size() != 0 
				&& fileNums != null && fileNums.length != 0) {
			List<FileVO> delList = new ArrayList<FileVO>();
			for(FileVO tmpFileVo : fileList) {
				for(Integer tmp: fileNums) {
					if(tmpFileVo.getFi_num() == tmp) {
						delList.add(tmpFileVo);
					}
				}
			}
			fileList.removeAll(delList);
		}
		deleteFile(fileList);
		uploadFile(files, board.getBd_num());
	}
	
	
	//게시글 파일첨부 업로드 관련 업데이트
		private void uploadFile(List<MultipartFile> files, int bd_num) {
			if(files == null)
				return;
			for(MultipartFile tmpFile : files) {
				if(tmpFile != null && tmpFile.getOriginalFilename().length() !=0) {
					try {
						String path = UploadFileUtils.uploadFile(
							uploadPath, tmpFile.getOriginalFilename(), tmpFile.getBytes());
						FileVO fileVo = 
							new FileVO(tmpFile.getOriginalFilename(), path, bd_num);
						boardDao.insertFile(fileVo);
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		private void deleteFile(List<FileVO> fileList) {
			if(fileList != null && fileList.size() != 0) {
				for(FileVO tmpFileVo : fileList) {
					File f = 
						new File(uploadPath+tmpFileVo.getFi_name().replace("/", File.separator));
					if(f.exists()) {
						f.delete();
					}
					boardDao.deleteFile(tmpFileVo.getFi_num());
				}
			}
		}
		@Override
		public int getTotalCount(Criteria cri) {
			return boardDao.selectCountBoard(cri);
		}
		@Override
		public void updateViews(Integer bd_num) {
			boardDao.updateViews(bd_num);			
		}
}
