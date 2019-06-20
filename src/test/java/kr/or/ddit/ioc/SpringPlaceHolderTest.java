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
public class SpringPlaceHolderTest {
	
	@Resource(name="dbInfo")
	private DbInfo dbInfo;
	

	@Test
	public void test() {
		assertEquals("oracle.jdbc.driver.OracleDriver",dbInfo.getDriver() );
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe",dbInfo.getUrl() );
		assertEquals("pc02",dbInfo.getUsername() );
		assertEquals("java",dbInfo.getPassword() );
			
	}

}
