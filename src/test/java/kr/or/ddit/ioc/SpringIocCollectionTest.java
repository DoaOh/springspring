package kr.or.ddit.ioc;

import static org.junit.Assert.*;



import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.collection.IocCollection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application_ioc_collection.xml")
public class SpringIocCollectionTest {

	
	@Resource(name="collectionBean")
	private IocCollection coll;
	
	
	
	@Test
	public void test() {
			
		
	assertEquals("brown", coll.getList().get(0));
	assertEquals("brown", coll.getMap().get("name"));
	assertEquals(3, coll.getSet().size());
	assertTrue(coll.getSet().contains("cony"));
	assertEquals("brown", coll.getProprerties().getProperty("userId"));
		
	}

}
