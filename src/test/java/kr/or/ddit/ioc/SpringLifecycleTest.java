package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.collection.IocCollection;
import kr.or.ddit.ioc.placeholder.DbInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-placeholder.xml")
public class SpringLifecycleTest {
	
	@Resource(name="dbInfo")
	private DbInfo dbInfo;
	

	/** 
	 * Method   : placeHolderTest
	 * 작성자 : pc02
	 * 변경이력 :  
	 * Method 설명 : spring placeholder test
	 */
	@Test
	public void test() {
		assertEquals("oracle.jdbc.driver.OracleDriver",dbInfo.getDriver() );
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe",dbInfo.getUrl() );
		assertEquals("pc02",dbInfo.getUsername() );
		assertEquals("java",dbInfo.getPassword() );
			
	}

}
