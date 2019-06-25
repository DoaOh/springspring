package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserService {
	
	List<UserVo> userList(); 
	
	UserVo getUser(String userId);
	
	int insertUser(UserVo userVo);

	int deleteUser(String userId);
	
    int updateUser(UserVo userVo);

    List<UserVo> userPagingList(PageVo pageVo);

	Map<String, Object> userPagingList2(PageVo pageVo);
}
