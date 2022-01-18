package kr.green.spring.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;
	//집
	//String uploadPath = "C:\\Users\\dudgu\\OneDrive\\바탕 화면\\GIT\\upload";
	//학원
	String uploadPath = "D:\\JAVA_JYH\\upload";
	@Override
	public void registerBoard(BoardVO board, List<MultipartFile> files) throws Exception {
		if(board == null 
				|| board.getBd_title() == null
				|| board.getBd_contents() == null
				|| board.getBd_me_id() == null)
			return;
		// Mapper 수정
		boardDao.insertBoard(board);
		uploadFile(files, board.getBd_num());
		
	}

	@Override
	public List<BoardVO> getBoardList(String type, Criteria cri) {
		
		return boardDao.getBoardList(type, cri);
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		return boardDao.getBoard(bd_num);
	}

	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		if(bd_num == null || bd_num <= 0)
			return;
		
		BoardVO board = boardDao.getBoard(bd_num);
		
		if(board == null )
			return;
		
		if(!board.getBd_me_id().equals(user.getMe_id()))
			return;
		
		boardDao.deleteBoard(bd_num);
		
//		board.setBd_del("Y");
//		board.setBd_del_date(new Date());
//		boardDao.updateBoard(board);
		
		List<FileVO> fileList = boardDao.selectFileList(bd_num);
		deleteFile(fileList);
	}

	@Override
	public BoardVO getBoard(Integer bd_num, MemberVO user) {
		if(bd_num == null || bd_num <= 0)
			return null;
		BoardVO board = boardDao.getBoard(bd_num);
		if(board == null || !board.getBd_me_id().equals(user.getMe_id()))
			return null;
		return board;
	}

	@Override
	public void updateBoard(BoardVO board, List<MultipartFile> files, Integer[] fileNums) {
		BoardVO dbBoard = boardDao.getBoard(board.getBd_num());
		dbBoard.setBd_title(board.getBd_title());
		dbBoard.setBd_contents(board.getBd_contents());
		dbBoard.setBd_up_date(new Date());
		boardDao.updateBoard(dbBoard);
		
		//게시글 번호와 일치하는 첨부파일 전부 가져오기
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

	@Override
	public List<FileVO> getFileList(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		
		return boardDao.selectFileList(bd_num);
	}
	
	private void uploadFile(List<MultipartFile>files, Integer bd_num) {
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
	public int getTotalCount(String type) {
		// TODO Auto-generated method stub
		return boardDao.selectCountBoard(type);
	}

}
