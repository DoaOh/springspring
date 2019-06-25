package kr.or.ddit.lprod.Dao;

import static org.junit.Assert.*;

import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import kr.or.ddit.lprod.dao.IlprodDao;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.LogicTestEnv;

public class LprodDaoTest extends LogicTestEnv {

	@Resource(name="lprodDao")
	private IlprodDao lprodDao;

	@Test
	public void pagingListTest() {

		// *** Given ***/

		int page = 1;
		int pageSize = 10;

		PageVo pageVo = new PageVo(page, pageSize);

		// *** When ***/

		List<LprodVo> lprodPagingList = lprodDao.lprodPagingList(pageVo);

		// *** Then ***//*

		assertEquals(10, lprodPagingList.size());
		assertEquals("P101", lprodPagingList.get(0).getLprod_gu());

	}

}
