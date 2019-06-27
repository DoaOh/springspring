package kr.or.ddit.prod.Service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.IprodService;
import kr.or.ddit.testenv.LogicTestEnv;


public class ProdServiceTest extends LogicTestEnv {
	private static final Logger logger = LoggerFactory.getLogger(ProdServiceTest.class);

	
	@Resource(name="prodService")
	private IprodService prodService;

	
	@Test
	public void pagingListTest() {
		
		// *** Given ***/

		int page = 1;
		int pageSize = 10;

		PageVo pageVo = new PageVo(page, pageSize);

		// *** When ***/

		Map<String, Object> prodPagination = prodService.LprodPagination(pageVo);
		
		List<ProdVo> prodList = (List<ProdVo>)prodPagination.get("prodList");
		int paginationSize = (Integer)prodPagination.get("paginationSize");
		
		logger.debug("prodList {}",prodList);
		assertEquals(2, paginationSize);
		assertEquals("P101000001", prodList.get(0).getProd_id());

	}
	
	
	
}
