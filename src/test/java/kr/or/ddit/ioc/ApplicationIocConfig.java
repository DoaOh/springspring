package kr.or.ddit.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.BoardService;

@Configuration
public class ApplicationIocConfig {
	
	//<bean id="boardDao" class="kr.or.ddit.board.dao.BoardDao"/>
	@Bean
	public IboardDao boardDao() {
		return new BoardDao();
	}

	

	
	/*
	 * <bean id="boardService" class="kr.or.ddit.board.service.BoardService">
	 * <property name="name" value="brown"></property>
	 *  <property name="boardDao"  ref="boardDao"/> </bean>
	 */
	 
	
	
	// 장점 에러가 있는지 바로 알수있다
	//스프링빈의 이름은 메소그 이름이 기본으로 적용된다
	@Bean
	public BoardService boardService() {
		BoardService boardService =new BoardService();
		boardService.setName("brown");
		boardService.setBoardDao(boardDao());
		return boardService;
	}

	
	
	
	
	
}
