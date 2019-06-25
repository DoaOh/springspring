package kr.or.ddit.login.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEnv;
import kr.or.ddit.user.model.UserVo;

public class logincontrollerTest  extends ControllerTestEnv{


	
	@Test
	public void loginViewNotLoginTest() throws Exception {
		
		/***Given***/
		 MvcResult mvcResult= mockMvc.perform(get("/login")).andReturn();
		 ModelAndView mav = mvcResult.getModelAndView();
		 String viewName =mav.getViewName();
		/***When***/

		/***Then***/
			assertEquals("login/login", viewName);	

	}

	
	
	
	@Test
	public void loginViewLoginTest() throws Exception {
		
		/***Given***/
		 MvcResult mvcResult= mockMvc.perform(get("/login").sessionAttr("USER_INFO",new UserVo())).andReturn();
		 ModelAndView mav = mvcResult.getModelAndView();
		 String viewName =mav.getViewName();
			
		/***When***/

		/***Then***/
		assertEquals("main", viewName);	

	}

	
	@Test
	public void loginProcessTest() throws Exception{
		
		/***Given***/
		String userId="dkskqk00";
		String password="dkskqk00";
		
		MvcResult mvcResult= mockMvc.perform(post("/login").param("userId", userId).param("password", password)).andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		HttpSession session= mvcResult.getRequest().getSession();
		UserVo userVo=(UserVo) session.getAttribute("USER_INFO");
		String viewName =mav.getViewName();
			
		/***When***/

		
		/***Then***/
		assertEquals("main", viewName);	
		assertEquals("dkskqk00", userVo.getName());	
		assertEquals("dkskqk00", userVo.getPass());	
	}
	
	
	
	
	@Test
	public void loginProcessFailTest() throws Exception{
		
		/***Given***/
		
		String userId="dkskqk00";
		String password="dkskqk77";  //틀린비밀번호
		 
		 MvcResult mvcResult= mockMvc.perform(post("/login").param("userId", userId).param("password", password)).andReturn();
		
		 ModelAndView mav = mvcResult.getModelAndView();
		 String viewName =mav.getViewName();
			
		/***When***/

		/***Then***/
		assertEquals("login/login", viewName);	
		
	}
	
	
	
}
