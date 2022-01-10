package kr.green.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;

	@Override
	public void registerBoard(BoardVO board) {
		if(board == null 
				|| board.getBd_title() == null
				|| board.getBd_contents() == null
				|| board.getBd_me_id() == null)
			return;
		boardDao.insertBoard(board);
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
}
