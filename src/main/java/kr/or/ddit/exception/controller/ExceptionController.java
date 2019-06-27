package kr.or.ddit.exception.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.exception.NoFileException;


@Controller
public class ExceptionController {
	
	@RequestMapping("/exception")
	public String exception() {
		throw new ArithmeticException();
	}

	@RequestMapping("/ioEception")
	public String ioEexception() throws IOException {
		ClassPathResource cpr =	new ClassPathResource("kr/or/ddit/ocnfig/mybatis/mybatis-config-not_exist.xml");
		cpr.getInputStream();
		
		return "main";
	}
	
	
	
	@RequestMapping("/noFileException")
	public String noFileException() throws NoFileException {
		try {
			ClassPathResource cpr =	new ClassPathResource("kr/or/ddit/ocnfig/mybatis/mybatis-config-not_exist.xml");
			cpr.getInputStream();
		} catch (Exception e) {
			throw new NoFileException();
		}
		
		return "main";
	}
	
	
	
}
