package kr.or.ddit.lprod.Service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.IlprodService;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.LogicTestEnv;


public class LprodServiceTest extends LogicTestEnv {
	private static final Logger logger = LoggerFactory.getLogger(LprodServiceTest.class);

	
	@Resource(name="lprodService")
	private IlprodService lprodService;

	
	@Test
	public void pagingListTest() {
		
		// *** Given ***/

		int page = 1;
		int pageSize = 10;

		PageVo pageVo = new PageVo(page, pageSize);

		// *** When ***/

		Map<String, Object> LprodPagination = lprodService.LprodPagination(pageVo);
		
		List<LprodVo> lprodList = (List<LprodVo>)LprodPagination.get("lprodList");
		int paginationSize = (Integer)LprodPagination.get("paginationSize");
		
		logger.debug("lprodList {}",lprodList);
		assertEquals(2, paginationSize);
		assertEquals("P101", lprodList.get(0).getLprod_gu());

	}
	
	
	
}
