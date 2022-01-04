package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
		//클래스 MemberVO를 사용한 변수명 >> 인터페이스memberDao로 연결된 MemberVO의 getMember요소중 Me_id를 가져온다.
		MemberVO user = memberDao.getMember(member.getMe_id());
		System.out.println(user);
		return null;
	}
}
