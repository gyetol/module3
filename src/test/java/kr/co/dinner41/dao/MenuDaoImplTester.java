package kr.co.dinner41.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dinner41.exception.UserDeleteFailedException;
import kr.co.dinner41.exception.menu.MenuException;
import kr.co.dinner41.exception.menu.OfferTypeSelectException;
import kr.co.dinner41.vo.MenuVO;
import kr.co.dinner41.vo.OfferTypeVO;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class MenuDaoImplTester {
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void insertTest() throws OfferTypeSelectException {
		MenuDaoImpl menuDao=ctx.getBean("menuDao",MenuDaoImpl.class);
		OfferTypeDaoImpl offerTypeDao=ctx.getBean("offerTypeDao",OfferTypeDaoImpl.class);
		OfferTypeVO offerTypeVo=offerTypeDao.selectById("PAC");
		StoreDaoImpl storeDao = ctx.getBean("storeDao",StoreDaoImpl.class);
		StoreVO store = storeDao.selectById(1);
		
		MenuVO menu = new MenuVO(store,0,offerTypeVo,"도시락","불고기 도시락",4500,5,"불고기 도시락입니다.","당일 섭취가 원칙입니다.","photo.jpg",null);
		
	
			try {
				menuDao.insert(menu, store);
			} catch (MenuException e) {
				e.printStackTrace();
			}
		
System.out.println("메뉴 추가 성공");
	}

	@Ignore
	@Test
	public void deleteTest() {
		UserDao dao=ctx.getBean("userDao",UserDao.class);
		try {
			dao.delete("test@naver.com","test");
			System.out.println("회원 삭제하기에 성공했습니다.");
		}
		catch(UserDeleteFailedException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	@Ignore
	public void updateNameTest() {
		UserDao userDao=ctx.getBean("userDao",UserDao.class);
		UserVO user=new UserVO(12,null,null,null,"테스트 업데이트","testAddress1_2","testAddress2_2",40,150,"010-1111-1111",null,null);
		try {
			userDao.update(user);
			System.out.println("회원 수정하기에 성공했습니다.");
		}
		catch(Exception e) {
		//catch(UserUpdateFailedException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Test
	@Ignore
	public void selectTest() {
		UserDao userDao=ctx.getBean("userDao",UserDao.class);
		List<UserVO> users=null;
		try {
			users=userDao.selectAll();
			if(users==null) {
				System.out.println("회원의 목록을 불러오지 못함");
			}
			for(UserVO user:users) {
				System.out.println(user.getName());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}