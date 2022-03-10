package kr.green.green.service;

import java.util.List;

import kr.green.green.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO user);

	MemberVO login(MemberVO member);

	String idCheck(String me_id);

	MemberVO updateMember(MemberVO inputUser, MemberVO user);

	String memberFindId(MemberVO member);

	String memberFindPw(MemberVO member);

	List<MemberVO> getUserList(MemberVO user);

	boolean changeAuthority(MemberVO member, MemberVO user);

}
