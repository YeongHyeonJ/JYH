package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {
// MemberVO 클래스에서 필요한 정보인 id를 가져오기 위해 getMember를 사용
	MemberVO getMember(@Param("me_id")String me_id);

	void insertMember(@Param("user")MemberVO user);

	void updateMember(@Param("user")MemberVO input);

	MemberVO findMember(@Param("user")MemberVO member);

	List<MemberVO> selectMemberList();

	void updateAutoLogin(@Param("user")MemberVO user);

	MemberVO selectMemberBySessionId(@Param("me_session_id")String me_session_id);

}
