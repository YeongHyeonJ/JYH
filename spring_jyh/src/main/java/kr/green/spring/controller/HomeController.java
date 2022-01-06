package kr.green.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv) {
		
		mv.setViewName("/main/home");
		mv.addObject("serverTime","데이터");
				
		return mv;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		System.out.println("/login:get :");
		mv.setViewName("/member/login");
		return mv;
	}
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		System.out.println("/login:post :" + member);
		MemberVO user = memberService.login(member);
		System.out.println(user);
		mv.setViewName("/member/login");
		return mv;
	}
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv, MemberVO user) {
		System.out.println("/signup:get :");
		mv.setViewName("/member/signup");
		mv.addObject("user",user);
		return mv;
	}
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {
		System.out.println("/signup:post :" + user);
		if(memberService.signup(user)) {
			mv.setViewName("redirect:/");
		}else{
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
}
