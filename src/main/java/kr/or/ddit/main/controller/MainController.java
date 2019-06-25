package kr.or.ddit.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 servlet 
  extends http servlet
  servlet mapping (web.xml, @WebServlet)
  service  -> dixxx
 
 spring 
  pojo plain old java object @controller
  @RequestMapping
  @requestMapping에 설정한 url method 호출 
 */

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	
	
	@RequestMapping("/main")
            	        /* HttpServletRequest request */
	public String mainView(Model model) {
		logger.debug("mianview");
		//prefic /WEB_INF/views/
		//prefic .jsp
		
		//prefic+viewName+prefic
		//   /WEB_INF/views/main.jsp
		
		
		//아래 문자은 다음과 동일하다
		//request.setAttribute("mainUserId", "brown")
		
		model.addAttribute("mainUserId", "brown");
		/* request.setAttribute("mainUserId", "brown"); */
		
		//viewName
		return "main";
		
	}
	
	
}
