package kr.or.ddit.prod.service;

import java.util.Map;

import kr.or.ddit.paging.model.PageVo;

public interface IprodService {
	
	Map<String, Object> LprodPagination(PageVo pageVo);

}
