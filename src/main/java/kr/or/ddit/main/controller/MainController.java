package kr.or.ddit.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.main.model.MainVo;
import kr.or.ddit.user.model.UserVo;

/*
servlet 
	- extends HttpServlet
	- servlet-mapping (web.xml, @WebServlet)
	- service -> doXXX
	
spring
   -	pojo (Plain Old Java Object), @Controller
   - @RequestMapping(class, method)
   - @RequestMapping에 설정한 url method 호출
*/

@Controller
@SessionAttributes("rangers")
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	// 메소드에 적용된@ModelAttribute
	// @RequestMapping 이 실행될때
	// @ModelAttribute적용된 메소드가 리턴하는 값을 model 객체에 자동적으로 넣어준다
	// localhost/main -->RequestMapping("main") mainview ㅡModel에는 rangers 속성이 들어가 있다

	@ModelAttribute("rangers")
	// @ModelAttribute(name = "rangers")
	public List<String> rangers() {
		logger.debug("rangers {} ", "rangers()");
		List<String> ragers = new ArrayList<String>();
		ragers.add("brown");
		ragers.add("cony");
		ragers.add("sally");
		ragers.add("james");
		ragers.add("moon");
		return ragers;

	}

	@RequestMapping("/main")
	public String mainView2(Model model, @ModelAttribute("userVo") UserVo userVo) {

		logger.debug("userVo:{}", userVo);
		// UserVo userVo= new UserVo();
		// userVo.setName("브라운");
		// model.addAttribute("userVo",userVo)

		logger.debug("	model.asMap().get(\"rangers\");  {}", model.asMap().get("rangers"));

		logger.debug("mainView");
		// prefix : /WEB-INF/views/
		// surffix : .jsp

		// prefix + viewName + surffix
		// /WEB-INF/views/main.jsp

		// 아래 문장은 다음과 동일하다
		// request.setAttribute("mainUserId", "brown");
		model.addAttribute("mainUserId", "brown");

		// viewName
		return "main";
	}

	/**
	 * Method : mainView 작성자 : PC02 변경이력 :
	 * 
	 * @param model
	 * @return Method 설명 : 메인페이지 요청 model and view
	 */
	@RequestMapping("/mainMav")
	public ModelAndView mainView(@ModelAttribute("rangers") List<String> rangers) {
		logger.debug("mainMav {}", rangers);
		// viewName을 기반으로ModelandView 객체를 생성
		ModelAndView mav = new ModelAndView("main");
		// 위문장은 아래 두문장과 동일하다
		// ModelAndView mav = new ModelAndView();
		// mav.setViewName("main");

		// model.addAttribute("mainUserId", "brown");
		mav.addObject("mainUserId", "brown");

		return mav;

	}

	// localhost/main/pathvariable/brown
	// localhost/main/pathvariable/sally
	/**
	 * Method : pathvarialbe 작성자 : PC02 변경이력 :
	 * 
	 * @param userId
	 * @return Method 설명 : 사용자 아이디 가져오기
	 */
	@RequestMapping("/main/pathvariable/{userId}")
	public String pathvarialbe(@PathVariable("userId") String userId) {
		logger.debug("userId : {}", userId);

		return "main";
	}

	/**
	 * Method : hrader 작성자 : PC02 변경이력 :
	 * 
	 * @param accept
	 * @return Method 설명 : 헤더정보 가져오기
	 */
	@RequestMapping("/main/header")
	public String hrader(@RequestHeader(name = "Accept"/* ,required = false */) String accept) {
		logger.debug("accept{}", accept);

		return "main";
	}

	@RequestMapping("/main/view")
	public String view() {

		return "view";
	}

	
	@RequestMapping("/main/process")
	public String process(HttpServletRequest request, String[] userId , String[] name , @RequestParam("userId")List<String> userIdlist, MainVo mainVo) {

		String userIdArr[] = request.getParameterValues("userId");
		String userIdparameter = request.getParameter("userId");

		logger.debug("  userIdparameter:{}", userIdparameter);

		
		logger.debug("ARR");
		for (String u : userIdArr) {
			logger.debug("userIdArr  :{}", u);
		}
		logger.debug("parameter");
		for (String u : userId) {
			logger.debug(" userId :{}", u);

		}
		
		logger.debug("List");
		for (String u : userIdlist) {
			logger.debug(" userId :{}", u);

		}
		

	logger.debug(" userId :{}", mainVo);


		
		return "main";
	}

}
