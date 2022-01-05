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
	public MemberVO signup(MemberVO user) {
		if(user == null || user.getMe_id() == null) {
			return null;
		}
		MemberVO dbUser = memberDao.setMember(user.getMe_id(), user.getMe_pw()
				, user.getMe_name(), user.getMe_gender()
				, user.getMe_address(), user.getMe_phone());
		System.out.println(dbUser);
		return null;
	}

}
