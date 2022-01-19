package kr.green.spring.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

// MtSQL에서 정보를 읽어오기 위한 변수선언,,, 주의할점은 MySQL에서 정한 속성명이 같아야 한다.
// getter setter를 줘야 정보를 가져오고 줄수있기 때문에 기본적으로 설정해준다.
// toString으로 어떠한 값을 볼수 있는지 알 수 있다.
@Data
public class MemberVO {
	private String me_id;
	private String me_pw;
	private String me_name;
	private String me_gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date me_birth;
	private String me_address;
	private String me_phone;
	private String me_authority;
			
}
