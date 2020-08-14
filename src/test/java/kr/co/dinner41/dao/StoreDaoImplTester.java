package kr.co.dinner41.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dinner41.vo.StoreVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
	})
public class StoreDaoImplTester {
	@Autowired
	private ApplicationContext ctx;
	

	@Ignore
	@Test
	public void selectTest() {
		StoreDao storeDao = ctx.getBean("storeDao",StoreDao.class);
		StoreVO store =null;
		
		try {
			store=storeDao.selectById(1);
			if(store==null) {
				System.out.println("매장 못 찾음");
			}
			System.out.println(store.getName());
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
