package kr.or.ddit.prod.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.IlprodService;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.IprodService;

@Controller
public class ProdController {
	
	@Resource(name="prodService")
	private IprodService prodService;
	
	
	@RequestMapping("/prodpagination")
	public String userpagingList(PageVo pageVo , Model model) {
		
		Map<String,Object> resultMap =prodService.LprodPagination(pageVo);
		
		List<ProdVo>prodList =(List<ProdVo>)resultMap.get("prodList");
		int paginationSize=(int) resultMap.get("paginationSize");
		
		model.addAttribute("prodList",prodList);
		model.addAttribute("paginationSize",paginationSize);
		model.addAttribute("pageVo",pageVo);
		
		return "prod/prodPagination";
	}
	
	

}
