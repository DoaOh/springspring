package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.IboardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationBeanScanConfig.class})

public class ApplicationIocBeanScanconfigTest {

	
	//bean 태그를 이용하여 스프링빈을 등록하는 방식을 사용하지 않고 
	//@controller @service @repository어노테이션을 적용한 클래스를 
	//base package 하위 모든 클래스를 스캔하여 스프일빈으로 등록 
	
	//boardDao boardService  스프링빈이 정상적으로 생성되었는지
	
	
	@Resource(name = "boardDao")
	private IboardDao boardDao;
	

	@Resource(name = "boardService")
	private IboardService boardService;
	
	
	@Test
	public void test() {
		
		String msg = boardDao.sayHello();
		
		assertNotNull(boardDao);
		assertEquals("boardDao sayHello", msg);
		
		assertNotNull(boardService);
		assertEquals(boardDao, boardService.getBoardDao());
	}

}
