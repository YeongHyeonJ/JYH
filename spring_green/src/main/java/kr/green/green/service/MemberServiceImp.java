package kr.green.green.service;

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

}
