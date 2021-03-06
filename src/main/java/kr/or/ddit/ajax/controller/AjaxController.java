package kr.or.ddit.ajax.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;

@RequestMapping("/ajax")
@Controller
public class AjaxController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Resource(name = "userService")
	private IuserService userService;

	
	@RequestMapping("/view")
	public String view() {
		return"tiles.ajaxview";
	}
	
	
	@RequestMapping("/requestData")
	public String requestData( Model model) {
		logger.debug("dddd@@@");
		List<String> rangers =  new ArrayList<String>();
		rangers.add("cony");
		rangers.add("sally");
		
		model.addAttribute("pageVo",new PageVo(5,10));
		model.addAttribute("rangers",rangers);
		return"jsonView";
	}
	
	
	
	
	
	@RequestMapping("/requestDataResponseBody")
	@ResponseBody //  응답내용을 ResponseBody에 작성해라
	public PageVo requestDataResponseBody() {
		return new PageVo(5,10);
	}
	
	
	

	@RequestMapping("/user")
	public String userData(String userId , Model model) {
		
		logger.debug("dddd");
		UserVo userVo= userService.getUser(userId);
		
		model.addAttribute("userVo",userVo);
		
		return"jsonView";
	}
	
	
	
	
	
	@RequestMapping("/userHtml")
	public String userHtml(String userId , Model model) {
		
		logger.debug("dddd");
		UserVo userVo= userService.getUser(userId);
		model.addAttribute("userVo",userVo);
		
		return"user/userHtml";
	}
	
	
	
//	@RequestMapping(path = "/requestBody",method= {RequestMethod.GET},
//			consumes = {"application/json"})
	@RequestMapping(path = "/requestBody",consumes = {"application/json"}//content-Type 제한
	,produces = {"application/json","application/xml"})   //메소드가 생성가능한타입
	@ResponseBody
	public UserVo requestBody(@RequestBody UserVo userVo) {
		
		logger.debug("@@@@  UserVo{}",userVo);
		userVo.setUserId(userVo.getUserId()+"_MODIFY");	
		userVo.setPass(userVo.getPass()+"_MODIFY");	
		
		return userVo;
	}
	
	
	
}
