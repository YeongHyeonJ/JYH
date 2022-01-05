package kr.green.test1.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.test1.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(@Param("me_id")String me_id);

	MemberVO setMember(@Param("me_id")String me_id, @Param("me_pw")String me_pw
			, @Param("me_name")String me_name, @Param("me_gender")String me_gender
			, @Param("me_address")String me_address, @Param("me_phone")String me_phone);


}
