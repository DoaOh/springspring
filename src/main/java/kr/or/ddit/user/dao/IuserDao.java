package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface IuserDao {
	
	
	
	/**
	 * Method : userList
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 
	 */
	List<UserVo> userList();

	int insertUser(UserVo userVo);

	int deleteUser(String userId);

	int usersCnt();

	UserVo getUser(String userId);

	
}
