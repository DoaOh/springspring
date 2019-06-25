package kr.or.ddit.user.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;

@Controller
public class UserController {
	
	@Resource(name="userService")
	private IuserService userService;
	
	@RequestMapping("/userList")
	public String userList(Model model) {
		model.addAttribute("userList",userService.userList());
		return "user/userList";
	}
	
	
	
	@RequestMapping("/userPagingList")
//	public String userpagingList(@RequestParam(name = "page" , defaultValue = "1") int page, 
//		                     	@RequestParam(name = "pageSize" , defaultValue = "10")int pageSize
//		                     	,Model model) {
//		
//		PageVo pageVo= new PageVo(page,pageSize);
	
	public String userpagingList(PageVo pageVo , Model model) {
		
		Map<String,Object> resultMap =userService.userPagingList2(pageVo);
		
		List<UserVo>userList =(List<UserVo>) resultMap.get("userList");
		int paginationSize=(int) resultMap.get("paginationSize");
		
		model.addAttribute("userList",userList);
		model.addAttribute("paginationSize",paginationSize);
		model.addAttribute("pageVo",pageVo);
		
		return "user/userPagingList";
	}

/*	
	
	@RequestMapping("/userProfile")
	public String userProfile(Model model) {
		return "";
	}
	
	
	@RequestMapping("/userForm")
	public String userForm(Model model) {
		return "";
	
	}
	
	@RequestMapping("/userModify")
	public String userModify(Model model) {
		return "";
		
	}
	
*/

}
