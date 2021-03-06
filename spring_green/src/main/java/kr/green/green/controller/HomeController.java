package kr.green.green.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;


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
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		
		mv.setViewName("/member/signup");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {
		//System.out.println("/signup:post :" + user);
		if(memberService.signup(user)) {
			mv.setViewName("redirect:/");
		}else{
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		//System.out.println("/login:get :");
		mv.setViewName("/member/login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		//System.out.println("/login:post :" + member);
		MemberVO user = memberService.login(member);
		if(user == null) {
			mv.setViewName("redirect:/login");
		}else {
			mv.addObject("user", user);
			mv.setViewName("redirect:/");
		}
		
		return mv;
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv, HttpServletRequest request) {
		//System.out.println("/logout:get :");
		//세션에 있는 user 정보를 삭제
		request.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "/idcheck")
	public String idcheck(String me_id) {
		
		return memberService.idCheck(me_id);
	}
	@RequestMapping(value = "/mypage")
	public ModelAndView mypage(ModelAndView mv, 
			MemberVO inputUser,
			HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		System.out.println(user);
		System.out.println(inputUser);
		MemberVO newUser = memberService.updateMember(inputUser, user);
		if(newUser != null) {
			request.getSession().setAttribute("user",newUser);
		}
		mv.setViewName("/member/mypage");
		
		return mv;
	}
	
	@RequestMapping(value = "/find")
	public ModelAndView find(ModelAndView mv) {
		
		mv.setViewName("/member/find");
		mv.addObject("serverTime","데이터");
		
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "/member/find/id")
	public String memberFindId(@RequestBody MemberVO member) {
		return memberService.memberFindId(member);
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/find/pw")
	public String memberFindPw(@RequestBody MemberVO member) {
		return memberService.memberFindPw(member);
	}
	
}
