package kr.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.green.dao.MemberDAO;
import kr.green.green.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	
	@Autowired
	MemberDAO memberDao;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(MemberVO user) {
		if(user == null)
			return false;
		if(user.getMe_id()== null)
			return false;
		if(user.getMe_pw()== null)
			return false;
		// mySQL 저장된 자료를 가져왔는데 signup에서 입력한 id가 있을때
		// 아이디 중복 검사
		if(memberDao.getMember(user.getMe_id()) != null)
			return false;
		// 암호화된 비밀번호
		String encPw = passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPw);
		memberDao.insertMember(user);
		return true;
	}

	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
		//클래스 MemberVO를 사용한 변수명 >> 인터페이스memberDao로 연결된 MemberVO의 getMember요소중 Me_id를 가져온다.
		MemberVO user = memberDao.getMember(member.getMe_id());
		//System.out.println(user);
		if(user == null)
			return null;
		//matches(로그인창에서의 입력 비번, 암호화된 비번) >> 같으면 true 다르면 false
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw()))
			return user;
		return null;
	}

	@Override
	public String idCheck(String me_id) {
		MemberVO user = memberDao.getMember(me_id);
		if(user == null)
			return "true";
		return "false";
	}

	@Override
	public MemberVO updateMember(MemberVO inputUser, MemberVO user) {
		if(inputUser == null || user == null 
				|| inputUser.getMe_id() == null 
				|| inputUser.getMe_id().length() == 0)
			return null;
		inputUser.setMe_id(user.getMe_id());
		inputUser.setMe_authority(user.getMe_authority());
		
		if(inputUser.getMe_pw() == null || inputUser.getMe_pw().length() == 0) {
			inputUser.setMe_pw(user.getMe_pw());
		}else {
			String encPw = passwordEncoder.encode(inputUser.getMe_pw());
			inputUser.setMe_pw(encPw);
		}
		
		if(inputUser.getMe_address() == null 
				|| inputUser.getMe_address().length() == 0) {
			inputUser.setMe_address(user.getMe_address());
		}
		memberDao.updateMember(inputUser);
		return inputUser;
	}

	@Override
	public String memberFindId(MemberVO member) {
		if(member == null || member.getMe_email() == null
				|| member.getMe_name() == null)
			return null;
		//System.out.println(member);
		
		return memberDao.selectFind(member);
	}

	@Override
	public String memberFindPw(MemberVO member) {
		if(member == null || member.getMe_email() == null
				|| member.getMe_id() == null)
			return "fail";
		
		
		
		return "ok";
	}

	@Override
	public List<MemberVO> getUserList(MemberVO user) {
		if(user == null)
			return null;
		if(!user.getMe_authority().equals("슈퍼 관리자"))
			return null;
		
		return memberDao.selectMemberList();
	}

	@Override
	public boolean changeAuthority(MemberVO member, MemberVO user) {
		if(member == null || user == null)
			return false;
		if(user.getMe_authority().equals("슈퍼 관리자"))
			return false;
		MemberVO dbUser = memberDao.getMember(member.getMe_id());
		if(dbUser == null || dbUser.getMe_authority().equals("슈퍼 관리자"))
			return false;
		dbUser.setMe_authority(member.getMe_authority());
		memberDao.updateMember(dbUser);
		return true;
	}

}
