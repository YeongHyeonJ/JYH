package kr.green.spring.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;
	//집
	String uploadPath = "C:\\Users\\dudgu\\OneDrive\\바탕 화면\\GIT\\upload";
	@Override
	public void registerBoard(BoardVO board, List<MultipartFile> files) throws Exception {
		if(board == null 
				|| board.getBd_title() == null
				|| board.getBd_contents() == null
				|| board.getBd_me_id() == null)
			return;
		// Mapper 수정
		boardDao.insertBoard(board);
		if(files == null)
			return;
		for(MultipartFile tmpFile : files) {
			// 첨부파일 업로드와 DB에 저장
			// UploadFileUtils.uploadFile(업로드 경로, 파일명, 파일데이터)
			// 첨부파일이 있고, 첨부파일 이름이 1글자 이상인 경우에만 업로드
			if(tmpFile != null && tmpFile.getOriginalFilename().length() != 0) {
				String path = UploadFileUtils.uploadFile(
						uploadPath, tmpFile.getOriginalFilename(), tmpFile.getBytes());
				FileVO fileVo = 
						new FileVO(tmpFile.getOriginalFilename(), path, board.getBd_num());
				System.out.println(fileVo);
				boardDao.insertFile(fileVo);
			}
		}
		
	}

	@Override
	public List<BoardVO> getBoardList(String type) {
		
		return boardDao.getBoardList(type);
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
	public void updateBoard(BoardVO board) {
		BoardVO dbBoard = boardDao.getBoard(board.getBd_num());
		dbBoard.setBd_title(board.getBd_title());
		dbBoard.setBd_contents(board.getBd_contents());
		dbBoard.setBd_up_date(new Date());
		boardDao.updateBoard(dbBoard);
	}

	@Override
	public List<FileVO> getFileList(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		
		return boardDao.selectFileList(bd_num);
	}
}
