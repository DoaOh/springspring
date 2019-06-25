package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.IboardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-test.xml")
public class SpringIocJunitTest {
	
	//di방법
	//field기준 boardService boardService2== spring boardService bean (scope=sigletone)
	//        boardServiceConstructor ==spring boardServiceConstructor bean (scope=sigletone)
	//boardService , boardService2  서로 같아야함
	//boardService,  boardServiceConstructor 같은 클래스에서 만들어진 객체이지만 sigletone개념에 따라 다른객 체
	//boardService2,  boardServiceConstructor 같은 클래스에서 만들어진 객체이지만 sigletone개념에 따라 다른객 체
	
	
	//boardDao== spring boardDao bean (scope=sigletone)
	//field기준boardDaoPrototype == spring boardDao bean (scope=prototype)
	//        boardDaoPrototype2 ==spring boardDao boardDaoPrototype bean (scope=prototype)
    //boardDao,  boardDaoPrototype 서로 id가 다르므로 다른객체
	//boardDaoPrototype,  boardDaoPrototype 같은 클래스에서 만들어진 객체이지만 prototype개념에 따라 다른객체
	
	@Resource(name="boardDao")
	private IboardDao boardDao;
	
	@Resource(name="boardDaoPrototype")
	private IboardDao boardDaoPrototype;
	
	@Resource(name="boardDaoPrototype")
	private IboardDao boardDaoPrototype2;
	
	
	
	@Resource(name="boardService")
	private IboardService boardService;
	
	@Resource(name="boardService")
	private IboardService boardService2;

	@Resource(name = "boardServiceConstructor")
	private IboardService boardServiceConstructor;
	
	
	/**
	 * Method : test
	 * 작성자 : PC02
	 * Method 설명 : 스프링컨테이너 생성 테스트 
	 */
	@Test
	public void springIocJunitTest() {
		/***When***/
		String msg = boardService.sayHello();
		/***Then***/
		assertNotNull(boardService);
		assertEquals("boardDao sayHello", msg);
	}

	
	
	/**
	 * Method : Test
	 * 작성자 : PC02
	 * Method 설명 : 비교
	 */
	@Test
	public void comparisonTest() {
		
		/***Then***/
		assertNotNull(boardService);
		assertNotNull(boardService2);
		assertNotNull(boardServiceConstructor);
		
		assertEquals(boardService2, boardService);
		assertNotEquals(boardService2, boardServiceConstructor);
		assertNotEquals(boardService, boardServiceConstructor);
	}

	
	
	
	/**
	 * Method : Test
	 * 작성자 : PC02
	 * Method 설명 : 비교
	 */
	@Test
	public void comparisonTest2() {
		/***Given***/
		//boardDao boardDaoPrototype springbean 아이디가 다르므로 다른객체
		//boardDaoPrototype boardDaoPrototype2 두 객체는 같은 스프링빈 이지만 scope가 prototype 이므로 다른 객체 여야만 한다
		
		/***Then***/
		assertNotNull(boardDao);
		assertNotNull(boardDaoPrototype);
		assertNotNull(boardDaoPrototype2);
		assertNotEquals(boardDao, boardDaoPrototype);
		assertNotEquals(boardDao, boardDaoPrototype);
		assertNotEquals(boardDaoPrototype, boardDaoPrototype2);
		
	}

	
	
	
}
