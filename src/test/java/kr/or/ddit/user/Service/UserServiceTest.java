package kr.or.ddit.user.Service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;


public class UserServiceTest extends LogicTestEnv {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

	
	@Resource(name="userService")
	private  IuserService userService;

	
	/**
	 * Method : test
	 * 작성자 : PC02
	 * 변경이력 :
	 * Method 설명 :사용자 전체 리스트 조회 테스트
	 */
	@Test
	public void userListTest() {
		
		/***Given***/
		

		/***When***/
		List<UserVo> userList = userService.userList();

		/***Then***/
		//logger.debug("userpageList {}",userList);
		assertNotNull(userService);
		assertTrue(userList.size()>=100);
		assertEquals(103, userList.size());
		
	}

	
	
	

	@Test
	public void getUserTest() {

		
		/*** Given ***/
		String userId = "user97";

		/*** When ***/
		UserVo uservo = userService.getUser(userId);

		/*** Then ***/
		assertEquals("brown1234", uservo.getPass());
		
	}



	
	@Test
	public void insertUserTest() throws ParseException {
		/*** Given ***/
		// 사용자 정보를 담고 있는 vo객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo=null;

		 userVo = new UserVo("userTest", "대덕인", "중앙로", "userTest1234", "대전광역시 중구 중앙로76", "영민빌딩 204호", "34940",
				sdf.parse("2019-05-31"));

		/*** When ***/
		// userDao.insertUser()
		int insertCnt = userService.insertUser(userVo);

		/*** Then ***/
		assertEquals(1, insertCnt);

		// data 삭제
		int deleteUser =userService.deleteUser(userVo.getUserId());

		assertEquals(1, deleteUser);
	}


	
	
	@Test
	public void updateUserTest() throws ParseException {
		/*** Given ***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = null;

		userVo = new UserVo("dkskqk00", "대덕인", "중앙로", "userTest1234", "대전광역시 중구 중앙로76", "영민빌딩 204호", "34940",
				sdf.parse("2019-05-31"));

		/*** When ***/
		int updateCnt = userService.updateUser(userVo);

		/*** Then ***/
		assertEquals(1, updateCnt);

	}

	@Test
	public void pagingListTest() {

		// *** Given ***/

		int page = 5;
		int pageSize = 10;

		PageVo pageVo = new PageVo(page, pageSize);

		//List<UserVo> resultMap = userDao.userPagingList(pageVo);

		
		// *** When ***/

		List<UserVo> userpageList = userService.userPagingList(pageVo);

		// *** Then ***//*
		//logger.debug("userList :{}",userpageList);
		assertEquals(10, userpageList.size());
		assertEquals("사용자42", userpageList.get(0).getName());


	}
	
	
	
	
	@Test
	public void pagingListTest2() {
		
		// *** Given ***/

		int page = 5;
		int pageSize = 10;

		PageVo pageVo = new PageVo(page, pageSize);

		// *** When ***/

		Map<String, Object> userpageList2 = userService.userPagingList2(pageVo);
		
		List<UserVo> userList = (List<UserVo>)userpageList2.get("userList");
		int paginationSize = (Integer)userpageList2.get("paginationSize");
		

		// *** Then ***//*

		//logger.debug("userList :{}",userList);
		//assertEquals("사용자42", userList);
		
		assertEquals("사용자42", userList.get(0).getName());
		assertEquals("user42", userList.get(0).getUserId());
		assertEquals(11, paginationSize);

	}
	
	
	
}
