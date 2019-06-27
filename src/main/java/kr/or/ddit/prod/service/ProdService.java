package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.prod.dao.IprodDao;



@Service
public class ProdService implements IprodService {

	@Resource(name = "prodDao")
	private IprodDao prodDao;
	

	@Override
	public Map<String, Object> LprodPagination(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("prodList", prodDao.prodPagingList(pageVo));
		
		int prodCnt = prodDao.prodCnt();
		int paginationSize = (int)Math.ceil((double)prodCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
		
	}
	

}
