package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
		//클래스 MemberVO를 사용한 변수명 >> 인터페이스memberDao로 연결된 MemberVO의 getMember요소중 Me_id를 가져온다.
		MemberVO user = memberDao.getMember(member.getMe_id());
		System.out.println(user);
		if(user == null)
			return null;
		//matches(로그인창에서의 입력 비번, 암호화된 비번) >> 같으면 true 다르면 false
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw()))
			return user;
		return null;
	}

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

	@Override
	public boolean idDuplicated(String id) {
		MemberVO user = memberDao.getMember(id);
		if(user == null)
			return false;
		return true;
	}
}
