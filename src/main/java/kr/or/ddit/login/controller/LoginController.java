package kr.or.ddit.login.controller;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;

@Controller
public class LoginController {

	@Resource(name = "userService")
	private IuserService userService;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String loginView(HttpSession session) {

		if (session.getAttribute("USER_INFO") != null) {
			return "main"; // WEB_INF/views/main.jsp
		} else {

			return "login/login";
		}
	}

	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String loginProcess(String userId, String password, String rememberme, HttpServletResponse response,
			HttpSession session) {

		String encryptPassword = KISA_SHA256.encrypt(password);
		UserVo userVo = userService.getUser(userId);
		//String password2 =userVo.getPass();
				
		if (userVo != null && encryptPassword.equals(userVo.getPass())) {
			rememberMeCookie(userId, rememberme, response);

			session.setAttribute("USER_INFO", userVo);

			return "main";

		} else {

			return "login/login";

		}

	}

	
	
	/**
	 * Method : rememberMeCookie
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param userId
	 * @param rememberme
	 * @param response
	 * Method 설명 : rememberMe cookie를 응답으로 생성
	 */
	private void rememberMeCookie(String userId, String rememberme, HttpServletResponse response) {
		int cookieMaxAge = 0;

		if (rememberme != null) {
			cookieMaxAge = 60 * 60 * 24 * 30;
		}

		Cookie userIdCookie = new Cookie("userId", userId);
		userIdCookie.setMaxAge(cookieMaxAge);

		Cookie remembeMeCookie = new Cookie("rememberme", "true");
		remembeMeCookie.setMaxAge(cookieMaxAge);

		response.addCookie(userIdCookie);
		response.addCookie(remembeMeCookie);
	}

}
