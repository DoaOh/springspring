package kr.or.ddit.user.Dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;

import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest extends LogicTestEnv {

	@Resource(name = "userDao")
	private IuserDao userDao;

	
	@Test
	public void test() {

		/*** Given ***/

		/*** When ***/
		List<UserVo> userList = userDao.userList();

		/*** Then ***/
		assertNotNull(userDao);
		assertEquals(110, userList.size());

	}
	
	@Test
	public void getUserTest() {
		/*** Given ***/
		String userId = "brown";

		/*** When ***/
		UserVo uservo = userDao.getUser(userId);

		/*** Then ***/
		assertEquals("브라운", uservo.getName());
		
	}




	@Test
	public void usersCntTest() {
		/*** Given ***/

		/*** When ***/
		int usersCnt = userDao.usersCnt();

		/*** Then ***/
		assertEquals(105, usersCnt);
	}

	// userVo가 등록이 되는지 안되는지 Test하는 코드!
	// 등록이 완료되면 1을 반환! assertEquals(1, insertCnt); 요부분-
	
	
	
	
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
		int insertCnt = userDao.insertUser(userVo);

		/*** Then ***/
		assertEquals(1, insertCnt);

		// data 삭제
		int deleteUser =userDao.deleteUser(userVo.getUserId());

		assertEquals(1, deleteUser);
	}



}
