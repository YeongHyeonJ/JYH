package kr.green.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv) {
		
		//화면 파일명 확장자는 여기서 선택 X
		//확장자는 servlet-context에서 설정
		//views폴더에는 jsp만 가능
		//html을 화면으로 쓰려면 src/main/resources 폴더에 넣어야함
		
		mv.setViewName("home2");
		mv.addObject("serverTime","데이터");
				
		return mv;
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView testGet(ModelAndView mv, Integer num, String name) {
		mv.setViewName("home2");
		mv.addObject("serverTime","데이터");
		System.out.println("/test : num = " + num + ", name = " + name);
		return mv;
	}
	@RequestMapping(value = "/test/form", method = RequestMethod.GET)
	public ModelAndView testFormGet(ModelAndView mv, Integer num, String name) {
		mv.setViewName("home2");
		mv.addObject("serverTime","데이터");
		System.out.println("/test/form:get : num = " + num + ", name = " + name);
		return mv;
	}
	@RequestMapping(value = "/test/form", method = RequestMethod.POST)
	public ModelAndView testFormPost(ModelAndView mv, Integer num, String name) {
		mv.setViewName("home2");
		mv.addObject("serverTime","데이터");
		System.out.println("/test/form:post : num = " + num + ", name = " + name);
		return mv;
	}
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public ModelAndView test2Get(ModelAndView mv) {
		mv.setViewName("test2");
		//mv.addObject("serverTime","데이터");
				
		return mv;
	}
	@RequestMapping(value = "/test2/form", method = RequestMethod.GET)
	public ModelAndView test2Get(ModelAndView mv, Integer num1, Integer num2) {
		mv.setViewName("test2");
		Integer addNum = null;
		if(num1 != null && num2 != null) {
			addNum = num1 + num2;
		}
		System.out.println(num1 + " + " + num2 + " = " + addNum);
		mv.addObject("result",addNum);
		mv.addObject("num1",num1);
		mv.addObject("num2",num2);
				
		return mv;
	}
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public ModelAndView test3Get(ModelAndView mv, MemberVO member) {
		System.out.println("/test3 :" + member);
		
		mv.setViewName("test3");
						
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		System.out.println("/login:get :");
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		System.out.println("/login:post :" + member);
		mv.setViewName("login");
		return mv;
	}
}
