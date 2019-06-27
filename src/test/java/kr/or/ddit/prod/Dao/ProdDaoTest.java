package kr.or.ddit.prod.Dao;

import static org.junit.Assert.*;

import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.prod.dao.IprodDao;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.testenv.LogicTestEnv;

public class ProdDaoTest extends LogicTestEnv {

	@Resource(name="prodDao")
	private IprodDao prodDao;

	@Test
	public void pagingListTest() {

		// *** Given ***/

		int page = 1;
		int pageSize = 10;

		PageVo pageVo = new PageVo(page, pageSize);

		// *** When ***/

		List<ProdVo> lprodPagingList = prodDao.prodPagingList(pageVo);

		// *** Then ***//*

		assertEquals(10, lprodPagingList.size());
		assertEquals("P101000001", lprodPagingList.get(0).getProd_id());

	}

}
