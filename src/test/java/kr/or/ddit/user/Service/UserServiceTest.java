package kr.or.ddit.user.Service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;

import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;


public class UserServiceTest extends LogicTestEnv {

	
	@Resource(name="userService")
	private  IuserService userService;

	
	/**
	 * Method : test
	 * 작성자 : PC02
	 * 변경이력 :
	 * Method 설명 :사용자 전체 리스트 조회 테스트
	 */
	@Test
	public void test() {
		
		/***Given***/
		

		/***When***/
		List<UserVo> userList = userService.userList();

		/***Then***/
		assertNotNull(userService);
		assertTrue(userList.size()>=100);
		assertEquals(111, userList.size());
		
	}

	
	
	

	@Test
	public void getUserTest() {
		/*** Given ***/
		String userId = "brown";

		/*** When ***/
		UserVo uservo = userService.getUser(userId);

		/*** Then ***/
		assertEquals("브라운", uservo.getName());
		
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


	
	
}
