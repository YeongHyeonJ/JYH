package kr.green.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.green.pagination.Criteria;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;

public interface BoardDAO {

	List<BoardVO> getBoardList(@Param("cri")Criteria cri);
	
	List<FileVO> selectFileList(@Param("bd_num")Integer bd_num);

	BoardVO getBoard(@Param("bd_num")Integer bd_num);

	void insertBoard(@Param("board")BoardVO board);

	void insertFile(@Param("file")FileVO fileVo);

	void deleteBoard(@Param("bd_num")Integer bd_num);

	void updateBoard(@Param("board")BoardVO dbBoard);

	void deleteFile(@Param("fi_num")int fi_num);

	int selectCountBoard(@Param("cri")Criteria cri);

	void updateViews(@Param("bd_num")Integer bd_num);

	

}
