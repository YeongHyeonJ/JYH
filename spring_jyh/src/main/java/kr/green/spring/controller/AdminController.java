package kr.green.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.AdminService;
import kr.green.spring.vo.MemberVO;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/admin/member/list")
	public ModelAndView adminMemberList(ModelAndView mv,HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(user == null || !user.getMe_authority().equals("슈퍼 관리자")) {
			mv.setViewName("redirect:/");
		}else {
			List<MemberVO> userList = adminService.getMemberList();
			mv.addObject("list", userList);
			mv.setViewName("/admin/member/list");
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/admin/update/authority")
	public boolean adminUpdateAuthority(@RequestBody MemberVO member) {
		System.out.println(member);
		return adminService.updateAuthority(member);
	}
	
}
