package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.model.UserVo;


@Service
public class UserService implements IuserService {

	@Resource(name = "userDao")
	private IuserDao userDao;
	
	@Override
	public List<UserVo> userList() {
		// TODO Auto-generated method stub
		return userDao.userList();
	}

	@Override
	public UserVo getUser(String userId) {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
	}

	@Override
	public int insertUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userDao.insertUser(userVo);
	}

	@Override
	public int deleteUser(String userId) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userId);
	}

	@Override
	public int updateUser(UserVo userVo) {
		return userDao.updateUser(userVo);
	}

	
	@Override
	public List<UserVo> userPagingList(PageVo pageVo) {
	
		return userDao.userPagingList(pageVo);
	}

	
	
	
	@Override
	public Map<String, Object> userPagingList2(PageVo pageVo) {
		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userDao.userPagingList(pageVo));
		
		int usersCnt = userDao.usersCnt();
		
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		return resultMap;
	}
	


	

	
	
}
