package kr.green.green.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.green.pagination.Criteria;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.LikesVO;
import kr.green.green.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer bd_num);
	
	BoardVO getBoard(Integer bd_num, MemberVO user);

	void registerBoard(BoardVO board, List<MultipartFile> files2) throws Exception;

	void deleteBoard(Integer bd_num, MemberVO user);

	List<FileVO> getFileList(Integer bd_num);

	void updateBoard(BoardVO board, List<MultipartFile> files2, Integer[] fileNums);

	int getTotalCount(Criteria cri);

	void updateViews(Integer bd_num);

	String likes(LikesVO likes, MemberVO user);

	String views(LikesVO likes, MemberVO user);

	

}
