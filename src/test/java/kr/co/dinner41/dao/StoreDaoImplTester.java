package kr.co.dinner41.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dinner41.vo.OpenState;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserTypeVO;
import kr.co.dinner41.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
	})
public class StoreDaoImplTester {
	@Autowired
	private ApplicationContext ctx;
	
//	@Test
//	public void insertTest() {
//		StoreDao storeDao =ctx.getBean("storeDao",StoreDao.class);
//		UserDao userDao =ctx.getBean("userDao",UserDao.class);
//		UserTypeDao userTypeDao = ctx.getBean("userTypeDao",UserTypeDao.class);
//		StoreCategoryDao storeCategoryDao =ctx.getBean("storeCategoryDao",StoreCategoryDao.class);
//		StoreStateDao storeStateDao = ctx.getBean("storeStateDao",StoreStateDao.class);
//		
//		
//	}
	
	

	@Ignore
	@Test
	public void selectByIdTest() {
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
	
	@Ignore
	@Test
	public void selectByCategoryTest() {
		StoreDao storeDao =ctx.getBean("storeDao",StoreDao.class);
		List<StoreVO> stores = null;
		try {
			stores = storeDao.selectByCategoryName("밀키트",1, 2);
			if(stores==null) {
				System.out.println("매장들을 불러오지 못함");
			}
			for(StoreVO store:stores) {
				System.out.println(store.getName());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void selectByStateNameTest() {
		StoreDao storeDao =ctx.getBean("storeDao",StoreDao.class);
		List<StoreVO> stores = null;
		try {
			stores = storeDao.selectByStateName("승인",1, 10);
			if(stores==null) {
				System.out.println("매장들을 불러오지 못함");
			}
			for(StoreVO store:stores) {
				System.out.println(store.getName());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void selectByBusinessTest() {
		StoreDao storeDao = ctx.getBean("storeDao",StoreDao.class);
		StoreVO store =null;
		
		try {
			store=storeDao.selectByBusinessNumber("12345678");
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
	
	
	
	@Ignore
	@Test
	public void selectByNameTest() {
		StoreDao storeDao =ctx.getBean("storeDao",StoreDao.class);
		List<StoreVO> stores = null;
		try {
			stores = storeDao.selectByName("안녕베트남", 1, 1);
			if(stores==null) {
				System.out.println("매장들을 불러오지 못함");
			}
			for(StoreVO store:stores) {
				System.out.println(store.getName());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void selectByOpenStateTest() {
		StoreDao storeDao =ctx.getBean("storeDao",StoreDao.class);
		List<StoreVO> stores = null;
		try {
			stores = storeDao.selectByOpenState(OpenState.OPEN, 1, 10);
			if(stores==null) {
				System.out.println("매장들을 불러오지 못함");
			}
			for(StoreVO store:stores) {
				System.out.println(store.getName());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	@Ignore
	@Test
	public void selectAllTest() {
		StoreDao storeDao =ctx.getBean("storeDao",StoreDao.class);
		List<StoreVO> stores = null;
		try {
			stores = storeDao.selectAll(1, 10);
			if(stores==null) {
				System.out.println("매장들을 불러오지 못함");
			}
			for(StoreVO store:stores) {
				System.out.println(store.getName());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
