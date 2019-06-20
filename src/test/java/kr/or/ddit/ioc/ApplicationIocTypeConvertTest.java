package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import kr.or.ddit.user.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-type-convert.xml")
public class ApplicationIocTypeConvertTest {

	@Resource(name = "UserVo")
	private UserVo uservo;
	
	@Test
	public void userVotest() {
		
		/***Given***/
		/***When***/
		Date birth =uservo.getBirth();
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String birth_str=sdf.format(birth);

		/***Then***/
		assertNotNull(uservo);
		assertEquals("2019-08-08", birth_str);
		
		
	}

}
