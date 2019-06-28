package kr.or.ddit.user.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
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

		MvcResult mvcResult = mockMvc.perform(get("/user/list")).andReturn();
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

		MvcResult mvcResult = mockMvc.perform(get("/user/pagingList")
				.param("page", "2")
				.param("pageSize", "10"))
				.andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName =mav.getViewName();
		List<UserVo> userList =((List<UserVo>)mav.getModelMap().get("userList"));
		int paginationSize=(int) mav.getModelMap().get("paginationSize");
		PageVo pageVo=(PageVo)mav.getModelMap().get("pageVo");
	
		/***Then***/
		assertEquals("tiles.userPagingList", viewName);	
		assertEquals(10, userList.size());	
		assertEquals(11, paginationSize);	
		assertEquals(2, pageVo.getPage());	
		
	}
	
	@Test
	public void userpagingListWithoutParameterTest() throws Exception {
		/***Given***/
		
		/***When***/

		MvcResult mvcResult = mockMvc.perform(get("/user/pagingList"))
				.andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName =mav.getViewName();
		List<UserVo> userList =((List<UserVo>)mav.getModelMap().get("userList"));
		int paginationSize=(int) mav.getModelMap().get("paginationSize");
		PageVo pageVo=(PageVo)mav.getModelMap().get("pageVo");
	
		/***Then***/
		assertEquals("tiles.userPagingList", viewName);	
		assertEquals(10, userList.size());	
		assertEquals(11, paginationSize);	
		assertEquals(1, pageVo.getPage());
		
		// PageVo에 있는 equals, hashcode메소드를 구현해서 객체간 값비교
		assertEquals(new PageVo(1,10), pageVo);	
		
	}

	@Test
	public void userTest() throws Exception {
		/***Given***/
		
		/***When***/

		MvcResult mvcResult = mockMvc.perform(get("/user/user")
				.param("userId", "dkskqk00"))
				.andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName =mav.getViewName();
		
		UserVo userVo=(UserVo)mav.getModelMap().get("userVo");
	
		/***Then***/
		assertEquals("user/user", viewName);	
		assertEquals("dkskqk00", userVo.getName());	
		
		
	}
	
	
	
	
	@Test
	public void userFormTest() throws Exception {
		/***Given***/
		
		/***When***/

		MvcResult mvcResult = mockMvc.perform(get("/user/form"))
				.andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName =mav.getViewName();
		/***Then***/
		assertEquals("user/userForm", viewName);	

	
		
	}
	
	
	
	
	
	@Test
	public void userFormpostTest() throws Exception {
		/***Given***/
		File file = new File("src/test/resources/kr/or/ddit/testenv/PIC12.jpg");
		FileInputStream fis = new FileInputStream(file);
		MockMultipartFile mockMultipartFile =new MockMultipartFile("profile",file.getName(),"",fis);

		/***When***/
		
		mockMvc.perform(fileUpload("/user/form").file(mockMultipartFile)
				.param("userId", "pumpum2")
				.param("name", "김호박")
				.param("pass", "pumpum")
				.param("alias", "호박")
				.param("birth", "2018-08-08")
				.param("zipcd", "30582")
				.param("addr1", "경기도 수원시 호박로 ")
				.param("addr2", "호박마을 3단지 "))
				.andExpect(view().name("redirect:/user/pagingList"));
	
		
	}
	
	
	
	
	
	@Test
	public void userFormpostFailTest() throws Exception {
		/***Given***/
		File file = new File("src/test/resources/kr/or/ddit/testenv/PIC12.jpg");
		FileInputStream fis = new FileInputStream(file);
		MockMultipartFile mockMultipartFile =new MockMultipartFile("user/profile",file.getName(),"",fis);

		/***When***/
		
		mockMvc.perform(fileUpload("/user/form").file(mockMultipartFile)
				.param("userId", "dkskqk00")
				.param("name", "김호박")
				.param("pass", "pumpum")
				.param("alias", "호박")
				.param("birth", "2018-08-08")
				.param("zipcd", "30582")
				.param("addr1", "경기도 수원시 호박로 ")
				.param("addr2", "호박마을 3단지 "))
				.andExpect(view().name("user/userForm"));
	
		
	}
	
	
	
	
	
	@Test
	public void userModifyTest() throws Exception {
		/***Given***/
		
		/***When***/

		MvcResult mvcResult = mockMvc.perform(get("/user/modify")
				 .param("userId", "brown"))
				.andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName =mav.getViewName();
		/***Then***/
		assertEquals("user/userModify", viewName);	
	}

	
	
	
	
	@Test
	public void userModifyFormTest() throws Exception {
		/***Given***/
		File file = new File("src/test/resources/kr/or/ddit/testenv/PIC12.jpg");
		FileInputStream fis = new FileInputStream(file);
		MockMultipartFile mockMultipartFile =new MockMultipartFile("profile",file.getName(),"",fis);

		/***When***/
		
		mockMvc.perform(fileUpload("/user/modify").file(mockMultipartFile)
				.param("userId", "user99")
				.param("name", "김호박")
				.param("pass", "pumpum")
				.param("alias", "호박")
				.param("birth", "2018-08-08")
				.param("zipcd", "30582")
				.param("addr1", "경기도 수원시 호박로 ")
				.param("addr2", "호박마을 3단지 "))
				.andExpect(view().name("redirect:/user/user?userId=user99"));
	
		
	}
	
	
	
	
	
	@Test
	public void profileTest() throws Exception {
		
		/***When***/

		 mockMvc.perform(get("/profile")
				 .param("userId", "brown"))
				.andExpect(status().isOk());
	
	}
	
	
	
	
}
