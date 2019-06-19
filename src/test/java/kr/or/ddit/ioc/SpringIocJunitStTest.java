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

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.IboardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-st2.xml")
public class SpringIocJunitStTest {
	
	//di방법
	@Resource(name="bService")
	private IboardService boardService;
	
	@Resource(name="bDao") //new BoardDao대신
	private IboardDao boardDao;

	/**
	 * Method : test
	 * 작성자 : PC02
	 * 변경이력 :
	 * Method 설명 : 스프링컨테이너 생성 테스트 
	 */
	
	@Test
	public void SpringIocJunitTest() {
		
		/***When***/
		//IboardDao boardDao = new BoardDao();

		/***Then***/
		assertNotNull(boardService);
		assertEquals(boardDao, boardService.getBoardDao());
	}

}
