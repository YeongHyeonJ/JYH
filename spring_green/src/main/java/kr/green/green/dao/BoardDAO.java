package kr.green.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.green.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> getBoardList(@Param("type")String type);

	BoardVO getBoard(@Param("bd_num")Integer bd_num);

}
