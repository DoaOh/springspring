package kr.or.ddit.ioc;

import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.typeConvert.model.FormattingVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-type-formatting.xml")

public class ApplicationTypeFormattingTest {

	@Resource(name = "formattingVo")
	private FormattingVo formattingVo;
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationTypeFormattingTest.class);
	
	@Test
	public void test() {
		
		/***Given***/
		
		Date reg =formattingVo.getReg_dt();
		Date mod =formattingVo.getMod_dt();
		int number=formattingVo.getNumber();

		/***When***/
		SimpleDateFormat sdf= new SimpleDateFormat("MM-yyyy-dd");
		String reg_sdf=sdf.format(reg);
		String mod_sdf=sdf.format(mod);
		String number2=sdf.format(number);
	
		
		logger.debug(reg_sdf);
		logger.debug(mod_sdf);
		
		/***Then***/
		
		assertNotNull(formattingVo);
		assertEquals("09-2019-22", reg_sdf);
		assertEquals("09-2019-22", mod_sdf);
		assertEquals(6000, number);
		
	}

}
