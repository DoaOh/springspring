package kr.or.ddit.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

	
	@Repository
	public class UserDao implements IuserDao {

		@Resource(name="sqlSession")
		private SqlSessionTemplate sqlSession;

	
		@Override
		public List<UserVo> userList() {
			
			return sqlSession.selectList("user.userList");
		}

		
		@Override
		public int insertUser(UserVo userVo) {
			return sqlSession.insert("user.insertUser",userVo);
		}

		
		@Override
		public int deleteUser(String userId) {
			return sqlSession.delete("user.deleteUser",userId);
			
		}

		
		@Override
		public UserVo getUser(String userId) {
			return sqlSession.selectOne("user.getUser",userId);
		}
	
		
		@Override
		public int usersCnt() {
			return sqlSession.selectOne("user.usersCnt");
		}



		@Override
		public int updateUser(UserVo userVo) {
			return sqlSession.update("user.updateUser",userVo);
		}



		
		@Override
		public List<UserVo> userPagingList(PageVo pageVo) {
			return sqlSession.selectList("user.userPagingList", pageVo);
		}

		

}
