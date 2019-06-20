package kr.or.ddit.board.dao;

import org.springframework.stereotype.Repository;

//spring bean이름 인스턴스 생성규칙 클래스면에서 컷글자를 소문자로
//bean 이름을 임의로 주고싶은 경우 
//@Repository("")
@Repository
public class BoardDao implements IboardDao {

	@Override
	public String sayHello() {
		return "boardDao sayHello";
	}


	
	

	
}
