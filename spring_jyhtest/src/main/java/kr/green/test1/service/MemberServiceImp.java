package kr.green.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test1.dao.MemberDAO;
import kr.green.test1.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Override
	public MemberVO login(MemberVO user) {
		if(user == null || user.getMe_id() == null) {
			return null;
		}
		MemberVO dbUser = memberDao.getMember(user.getMe_id());
		System.out.println(dbUser);
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
		memberDao.insertMember(user);
		return true;
	}

}
