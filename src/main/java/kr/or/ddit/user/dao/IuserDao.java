package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface IuserDao {
	
	
	
	List<UserVo> userList();

	int insertUser(UserVo userVo);

	int deleteUser(String userId);

	int usersCnt();

	UserVo getUser(String userId);

	
}
