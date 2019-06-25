package kr.or.ddit.user.Dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.junit.Test;

import kr.or.ddit.paging.model.PageVo;
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
		assertEquals(103, userList.size());

	}

	@Test
	public void getUserTest() {
		/*** Given ***/
		String userId = "user97";

		/*** When ***/
		UserVo uservo = userDao.getUser(userId);

		/*** Then ***/
		assertEquals("brown1234", uservo.getPass());

	}

	@Test
	public void usersCntTest() {
		/*** Given ***/

		/*** When ***/
		int usersCnt = userDao.usersCnt();

		/*** Then ***/
		assertEquals(103, usersCnt);
	}

	// userVo가 등록이 되는지 안되는지 Test하는 코드!
	// 등록이 완료되면 1을 반환! assertEquals(1, insertCnt); 요부분-

	@Test
	public void insertUserTest() throws ParseException {
		/*** Given ***/
		// 사용자 정보를 담고 있는 vo객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = null;

		userVo = new UserVo("userTest", "대덕인", "중앙로", "userTest1234", "대전광역시 중구 중앙로76", "영민빌딩 204호", "34940",
				sdf.parse("2019-05-31"));

		/*** When ***/
		// userDao.insertUser()
		int insertCnt = userDao.insertUser(userVo);

		/*** Then ***/
		assertEquals(1, insertCnt);

		// data 삭제
		int deleteUser = userDao.deleteUser(userVo.getUserId());

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
		int updateCnt = userDao.updateUser(userVo);

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

		List<UserVo> userpageList = userDao.userPagingList(pageVo);

		// *** Then ***//*

		assertEquals(10, userpageList.size());
		assertEquals("사용자42", userpageList.get(0).getName());

	}

}
