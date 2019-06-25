package kr.or.ddit.user.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.ControllerTestEnv;
import kr.or.ddit.user.model.UserVo;

public class UserControllerTest extends ControllerTestEnv{

	
	@Test
	public void userListTest() throws Exception {
		/***Given***/
		
		/***When***/

		MvcResult mvcResult = mockMvc.perform(get("/userList")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName =mav.getViewName();
	     int a=((List<UserVo>)mav.getModelMap().get("userList")).size();
		/***Then***/
		assertEquals("user/userList", viewName);	
		assertEquals(103, a);	
		
	}

	
	
	
	
	@Test
	public void userpagingListTest() throws Exception {
		/***Given***/
		
		/***When***/

		MvcResult mvcResult = mockMvc.perform(get("/userPagingList")
				.param("page", "2")
				.param("pageSize", "10"))
				.andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName =mav.getViewName();
		List<UserVo> userList =((List<UserVo>)mav.getModelMap().get("userList"));
		int paginationSize=(int) mav.getModelMap().get("paginationSize");
		PageVo pageVo=(PageVo)mav.getModelMap().get("pageVo");
	
		/***Then***/
		assertEquals("user/userPagingList", viewName);	
		assertEquals(10, userList.size());	
		assertEquals(11, paginationSize);	
		assertEquals(2, pageVo.getPage());	
		
	}
	
	@Test
	public void userpagingListWithoutParameterTest() throws Exception {
		/***Given***/
		
		/***When***/

		MvcResult mvcResult = mockMvc.perform(get("/userPagingList"))
				.andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName =mav.getViewName();
		List<UserVo> userList =((List<UserVo>)mav.getModelMap().get("userList"));
		int paginationSize=(int) mav.getModelMap().get("paginationSize");
		PageVo pageVo=(PageVo)mav.getModelMap().get("pageVo");
	
		/***Then***/
		assertEquals("user/userPagingList", viewName);	
		assertEquals(10, userList.size());	
		assertEquals(11, paginationSize);	
		assertEquals(1, pageVo.getPage());	
		
	}

	
	
	
}
