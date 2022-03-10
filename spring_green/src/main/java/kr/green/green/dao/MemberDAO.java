package kr.green.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.green.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(@Param("me_id")String me_id);

	void insertMember(@Param("user")MemberVO user);

	void updateMember(@Param("user")MemberVO inputUser);

	String selectFind(@Param("user")MemberVO member);

	List<MemberVO> selectMemberList();

}
