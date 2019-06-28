package kr.or.ddit.user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.model.UserVoValidator;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.util.PartUtil;
@RequestMapping("/user")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "userService")
	private IuserService userService;

	
	
	@RequestMapping("/list")
	public String userList(Model model) {
		model.addAttribute("userList", userService.userList());
		return "user/userList";
	}
	
	
	
	@RequestMapping("/userListExcel")
	
	public String userListExcel(Model model) {
		List<String> header = new ArrayList<String>();
		header.add("userId");
		header.add("name");
		header.add("alias");
		header.add("addr1");
		header.add("addr2");
		header.add("zipcd");
		header.add("birth");
		
		model.addAttribute("header",header);
		model.addAttribute("data",userService.userList());
		model.addAttribute("filename","userList");
		
		return "userExcelView";
	}
	
	
	
	

	@RequestMapping("/pagingList")
//	public String userpagingList(@RequestParam(name = "page" , defaultValue = "1") int page, 
//		                     	@RequestParam(name = "pageSize" , defaultValue = "10")int pageSize
//		                     	,Model model) {
//		
//		PageVo pageVo= new PageVo(page,pageSize);

	public String userpagingList(PageVo pageVo, Model model) {

		Map<String, Object> resultMap = userService.userPagingList2(pageVo);

		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int paginationSize = (int) resultMap.get("paginationSize");

		model.addAttribute("userList", userList);
		model.addAttribute("paginationSize", paginationSize);
		model.addAttribute("pageVo", pageVo);

//		return "user/userPagingList";
		return "tiles.userPagingList";
	}

	@RequestMapping("/user")
	public String user(String userId, Model model) {

		// UserVo userVo = userService.getUser(userId);
		// model.addAttribute("userVo", userVo);

		model.addAttribute("userVo", userService.getUser(userId));

		return "user/user";
	}

	
	
	
	/**
	 * Method : userAjax
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param userId
	 * @param model
	 * @return
	 * Method 설명 : 사용자 정보 ajax 요청
	 */
	
	/* 
	@RequestMapping("/userJson") 
	  public View userJson(String userId, Model model){
	  
	  model.addAttribute("userVo", userService.getUser(userId));
	  
	  //return "jsonView"; 
	  return new MappingJackson2JsonView();
	  
	  }
	  */
	
	  @RequestMapping("/userJson") 
	  public String userJson(String userId, Model model){
	  
	  model.addAttribute("userVo", userService.getUser(userId));
	  
	  //return "jsonView"; 
	  return "jsonView";
	  
	  }
	
	
	/**
	 * Method : userForm 작성자 : PC02 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 등록
	 */
	@RequestMapping(path = "/form", method = RequestMethod.GET)
	public String userForm() {
		return "user/userForm";

	}

	
	
	
	// 사용자등록
	/**
	 * Method : userForm
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param userVo
	 * @param model
	 * @param userId
	 * @param file
	 * @return
	 * Method 설명 : 사용자 등록
	 */
	//@RequestMapping(path = "/form", method = RequestMethod.POST)
	public String userForm(UserVo userVo, Model model,BindingResult result, String userId,  MultipartFile profile) {

		new UserVoValidator().validate(userVo,result);
		
		if(result.hasErrors()) {
			return "user/userForm";
		}
		
		String viewName="";
		UserVo dbUser = userService.getUser(userId);
		
		if (dbUser == null) {
			if (profile.getSize() > 0) {
				String fileName = profile.getOriginalFilename();
				String ext = PartUtil.getExt(fileName);
				String uploadPath = PartUtil.getUploadPath();
				
				String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
				userVo.setPath(filePath);
				userVo.setFilename(fileName);
				
				logger.debug("fileName : {} ",fileName);
				logger.debug("filePath : {} ",filePath);
				

				try {
					profile.transferTo(new File(filePath));
					model.addAttribute("msg", "SUCCESS");
				} catch (IllegalStateException | IOException e) {
					model.addAttribute("msg", "Fail");
					e.printStackTrace();
				}
			}

			int insertCnt = userService.insertUser(userVo);

			if (insertCnt == 1) {
				viewName = "redirect:/user/pagingList";
			}

			} else {
				model.addAttribute("msg", "이미 존재하는 사용자 입니다.");
				viewName = userForm();
			}

		return viewName;

	}
	
	
	// 사용자등록
	/**
	 * Method : userForm
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param userVo
	 * @param model
	 * @param userId
	 * @param file
	 * @return
	 * Method 설명 : 사용자 등록
	 * @throws IOException 
	 */
	/*
	@RequestMapping(path = "/userForm", method = RequestMethod.POST)
	public String userForm(UserVo userVo, Model model, String userId, @RequestPart("profile") MultipartFile file) {

		String viewName="";
		UserVo dbUser = userService.getUser(userId);
		
		if (dbUser == null) {
			if (file.getSize() > 0) {
				String fileName = file.getOriginalFilename();
				String ext = PartUtil.getExt(fileName);
				String uploadPath = PartUtil.getUploadPath();
				
				String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
				userVo.setPath(filePath);
				userVo.setFilename(fileName);
				
				logger.debug("fileName : {} ",fileName);
				logger.debug("filePath : {} ",filePath);
				

				try {
					file.transferTo(new File(filePath));
					model.addAttribute("msg", "SUCCESS");
				} catch (IllegalStateException | IOException e) {
					model.addAttribute("msg", "Fail");
					e.printStackTrace();
				}
			}

			int insertCnt = userService.insertUser(userVo);

			if (insertCnt == 1) {
				viewName = "redirect:/userPagingList";
			}

			} else {
				model.addAttribute("msg", "이미 존재하는 사용자 입니다.");
				viewName = userForm();
			}

		return viewName;

	}
	
	*/
	
	
	
	 /**
	 * Method : profile
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param model
	 * @param userId
	 * @param response
	 * @param request
	 * @throws IOException
	 * Method 설명 : 사용자 사진 응답 생성
	 */
	@RequestMapping( path="/profile" , method = RequestMethod.GET) 
	 public String profile(Model model, String userId) throws IOException { 
	
		   //사용자 정보조회 
			UserVo userVo = userService.getUser(userId);
			model.addAttribute("userVo",userVo);
		 
			return "profileView";
	 }
	
	
	 @RequestMapping( path="/modify" , method = RequestMethod.GET) 
	 public String userModify(Model model, String userId) { 
		 model.addAttribute("userVo", userService.getUser(userId));
		 return  "user/userModify";
		 
	 }
	
	 
	
	  @RequestMapping(path="/modify" , method = RequestMethod.POST) 
	  public String userModify(UserVo userVo, Model model, String userId, MultipartFile profile 
			  ,HttpSession session, RedirectAttributes redirectAttributes) throws IllegalStateException, IOException {
	  
			String viewName="";
		
				
				if (profile.getSize() > 0) {
					String fileName = profile.getOriginalFilename();
					String ext = PartUtil.getExt(fileName);
					
					String uploadPath = PartUtil.getUploadPath();
					
					String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
					
					userVo.setPath(filePath);
					userVo.setFilename(fileName);
					
                    profile.transferTo(new File(filePath));
						
				}
		
				int updateCnt = userService.updateUser(userVo);

				if (updateCnt == 1) {
					
			 /*	 1번
			  redirectAttributes.addFlashAttribute("msg", "성공");
			  redirectAttributes.addAttribute("userId",userVo.getUserId()); //파라메터가 자동으로붙는다 
			  viewName = "redirect:/user/user";
			 */
					
			  /* 2번
			  viewName = "redirect:/user/user?userId="+userId;
			  model.addAttribute("msg", "성공"); 
			  
			  */
					
					 redirectAttributes.addFlashAttribute("msg", "성공");
					 viewName = "redirect:/user/user?userId="+userId;
					
					
					 
				}else {
					model.addAttribute("msg", "실패");
					viewName = userForm();
				}

			return viewName;
		  
		  
			
	
	  
	  }
	 
	  

		// 사용자등록
		/**
		 * Method : userForm
		 * 작성자 : PC02
		 * 변경이력 :
		 * @param userVo
		 * @param model
		 * @param userId
		 * @param file
		 * @return
		 * Method 설명 : 사용자 등록
		 */
		@RequestMapping(path = "/form", method = RequestMethod.POST)
		public String userFormJsr(@Valid UserVo userVo,BindingResult result, Model model, String userId,  MultipartFile profile) {

			logger.debug("@^@ form @Valid ");
			
			if(result.hasErrors()) {
				return "user/userForm";
			}
			
			String viewName="";
			UserVo dbUser = userService.getUser(userId);
			
			if (dbUser == null) {
				if (profile.getSize() > 0) {
					String fileName = profile.getOriginalFilename();
					String ext = PartUtil.getExt(fileName);
					String uploadPath = PartUtil.getUploadPath();
					
					String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
					userVo.setPath(filePath);
					userVo.setFilename(fileName);
					
					logger.debug("fileName : {} ",fileName);
					logger.debug("filePath : {} ",filePath);
					

					try {
						profile.transferTo(new File(filePath));
						model.addAttribute("msg", "SUCCESS");
					} catch (IllegalStateException | IOException e) {
						//model.addAttribute("msg", "Fail");
						e.printStackTrace();
					}
				}

				int insertCnt = userService.insertUser(userVo);

				if (insertCnt == 1) {
					viewName = "redirect:/user/pagingList";
				}

				} else {
					model.addAttribute("msg", "이미 존재하는 사용자 입니다.");
					viewName = userForm();
				}

			
			logger.debug("getAddr1: {} ",userVo.getAddr1());
			logger.debug("getAddr1: {} ",userVo.getName());
			logger.debug("getAddr1: {} ",userVo.getAddr2());
			logger.debug("getAddr1: {} ",userVo.getAlias());
			logger.debug("getAddr1: {} ",userVo.getBirth());
			logger.debug("getAddr1: {} ",userVo.getName());
			logger.debug("getAddr1: {} ",userVo.getUserId());
			
			return viewName;

		}
		
	  
	
	

}
