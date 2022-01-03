package kr.green.spring;

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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		
		//화면 파일명 확장자는 여기서 선택 X
		//확장자는 servlet-context에서 설정
		//views폴더에는 jsp만 가능
		//html을 화면으로 쓰려면 src/main/resources 폴더에 넣어야함
		
		mv.setViewName("home");
		mv.addObject("serverTime","데이터");
				
		return mv;
	}
	
}
