package kr.or.ddit.testenv;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/kr/or/ddit/config/spring/rootContext.xml",
		     "classpath:kr/or/ddit/config/spring/application-datasource-dev.xml",
		     "classpath:kr/or/ddit/config/spring/application-transaction.xml"})
public class LogicTestEnv {
	
	@Resource(name = "dataSource")
	private  DataSource dataSource;
	
	@Before
	public void Setup() {
		ResourceDatabasePopulator rdp =new ResourceDatabasePopulator();
		rdp.setContinueOnError(false);
		rdp.addScript(new ClassPathResource("kr/or/ddit/testenv/dbInit.sql"));
		DatabasePopulatorUtils.execute(rdp, dataSource);
	}
	
	@Ignore
	@Test
	public void dummy() {}

}
