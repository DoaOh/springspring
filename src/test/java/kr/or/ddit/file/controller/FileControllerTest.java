package kr.or.ddit.file.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import com.sun.media.jfxmedia.logging.Logger;

import kr.or.ddit.testenv.ControllerTestEnv;

public class FileControllerTest extends ControllerTestEnv{
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FileControllerTest.class);
	


	@Test
	public void uploadViewtest() throws Exception {
		
		/***Given***/
		
		/***When***/

		 MvcResult mvcResult=mockMvc.perform(get("/file/uploadView")).andReturn();
		 ModelAndView mav =mvcResult.getModelAndView();
		 String viewName=mav.getViewName();
		
		/***Then***/
		 assertEquals("upload/upload", viewName);
	}

	
	
	@Test
	public void uploadtest() throws Exception {
		
		/***Given***/
		
		File file = new File("D:\\springUpload\\PIC12.jpg");
		
	   logger.debug("file.getName(); {}",file.getName());
		FileInputStream fis = new FileInputStream(file);
		MockMultipartFile mockMultipartFile =new MockMultipartFile("img",file.getName(),"",fis);

		
		/***When***/

		 MvcResult mvcResult=mockMvc.perform(fileUpload("/file/upload")
				 //file(file.getName(),IOUtils.toByteArray(fis)))
				 //file("img",IOUtils.toByteArray(fis)))
				 .file(mockMultipartFile))
				 .andReturn();
		 ModelAndView mav =mvcResult.getModelAndView();
		 String viewName=mav.getViewName();
		 String msg =(String) mav.getModelMap().get("msg");
		
		/***Then***/
		 assertEquals("SUCCESS", msg);
		 assertEquals("upload/upload", viewName);
	}

	
	
	
	@Test
	public void uploadtest2() throws Exception {
		
		/***Given***/
		File file = new File("src/test/resources/kr/or/ddit/testenv/PIC12.jpg");
		
		//File file = new File(getClass().getClassLoader().getResource("kr/or/ddit/testenv/sally.png").getFile());
			
		/*File currnetfilder = new File("");
		File file = new File(currnetfilder.getAbsolutePath()+
				File.separator+"src"+File.separator+"test"+File.separator+"resource"+
				File.separator+"kr"+File.separator+"or"+File.separator+"ddit"+
				File.separator+"testenv"+File.separator+"sally.png");
		
		*/
				
		FileInputStream fis = new FileInputStream(file);
		MockMultipartFile mockMultipartFile =new MockMultipartFile("img",file.getName(),"",fis);
		/***When***/

		 MvcResult mvcResult=mockMvc.perform(fileUpload("/file/upload")
				 //file(file.getName(),IOUtils.toByteArray(fis)))
				 //file("img",IOUtils.toByteArray(fis)))
				 .file(mockMultipartFile))
				 .andReturn();
		 ModelAndView mav =mvcResult.getModelAndView();
		 String viewName=mav.getViewName();
		 String msg =(String) mav.getModelMap().get("msg");
		
		/***Then***/
		 assertEquals("SUCCESS", msg);
		 assertEquals("upload/upload", viewName);
	}
	
	
}
