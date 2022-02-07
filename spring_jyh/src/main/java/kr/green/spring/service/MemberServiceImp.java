package kr.green.spring.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

	@Autowired
	private JavaMailSender mailSender;
	
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

	@Override
	public MemberVO updateMember(MemberVO input, MemberVO user) {
		if(input == null || user == null)
			return null;
		if(input.getMe_name() == null || input.getMe_birth() == null || input.getMe_gender() == null)
			return null;
		input.setMe_id(user.getMe_id());
		if(input.getMe_pw() == null || input.getMe_pw().length() == 0) {
			input.setMe_pw(user.getMe_pw());
		}else {
			String encPw = passwordEncoder.encode(input.getMe_pw());
			input.setMe_pw(encPw);
		}
		if(input.getMe_address() == null || input.getMe_address().length() == 0) {
			input.setMe_address(user.getMe_address());
		}
		memberDao.updateMember(input);
		return input;
	}

	@Override
	public String findId(MemberVO member) {
		if(member == null || member.getMe_email() == null || member.getMe_name() == null)
			return "";
		MemberVO user = memberDao.findMember(member);
		if(user == null)
			return "";
		return user.getMe_id();
	}

	@Override
	public String findPw(MemberVO member) {
		//예외처리
		if(member == null)
			return "false";
		MemberVO user = memberDao.getMember(member.getMe_id());
		if(user == null || !user.getMe_email().equals(member.getMe_email()))
			return "false";
		//임시 비밀번호를 생성 (6)은 자리수
		String newPw = createRandomPw(6);
		//생성된 비밀번호를 암호화해서 DB에 저장
		String encPw = passwordEncoder.encode(newPw);
		user.setMe_pw(encPw);
		memberDao.updateMember(user);
		//암호화 안된 비밀번호를 이메일로 전송
		String setfrom = "dudgus7700@gmail.com";         
	    String tomail  = member.getMe_email();     // 받는 사람 이메일
	    String title   = "임시 비밀번호입니다.";      // 제목
	    String content = "임시 비밀번호는 " + newPw + " 입니다.";    // 내용

	    try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(tomail);     // 받는사람 이메일
	        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	        messageHelper.setText(content);  // 메일 내용

	        mailSender.send(message);
	    } catch(Exception e){
	        return "error";
	    }
		return "true";
	}
	
	
	private String createRandomPw(int maxSize) {
		String newPw = "";
		// maxSize = 자리수
		// 영어와 숫자로 이루어지기에 a~z,A~Z,0~9 = 62가지
		// 랜덤 수를 생성 = 0~61
		for(int i = 0; i<maxSize; i++) {
			int max = 61, min = 0;
			int r = (int)(Math.random() * (max - min + 1 ) + min);
			// int r = (int)(Math.random() * 62);
			if(0 <= r && r <= 9) {
				// 랜덤 수 0~9 = 0~9 
				newPw += (char)('0' + r);
			}else if(r <= 35) {
				// 랜덤 수 10~35 = a~z
				newPw += (char)('a' + (r - 10));
			}else if(r <= 61) {
				// 랜덤 수 36~61 = A~Z
				newPw += (char)('A' + (r - 36));
			}
		}
		return newPw;
	}
}
