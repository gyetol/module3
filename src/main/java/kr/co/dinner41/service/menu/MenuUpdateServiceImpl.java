package kr.co.dinner41.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dinner41.command.MenuUpdateCommand;
import kr.co.dinner41.dao.MenuDaoImpl;
import kr.co.dinner41.dao.OfferTypeDaoImpl;
import kr.co.dinner41.dao.StoreDaoImpl;
import kr.co.dinner41.exception.menu.MenuException;
import kr.co.dinner41.exception.menu.OfferTypeSelectException;
import kr.co.dinner41.vo.MenuVO;
import kr.co.dinner41.vo.OfferTypeVO;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;

@Service("menuUpdateService")
public class MenuUpdateServiceImpl implements MenuUpdateService {

	@Autowired
	private MenuDaoImpl menuDao;
	
	@Autowired
	private OfferTypeDaoImpl offerTypeDao;
	
	@Autowired
	private StoreDaoImpl storeDao;
	
	@Override
	public void execute(MenuUpdateCommand command, int storeId, int menuId, UserVO user) throws MenuException {
		
		OfferTypeVO offerTypeVO = null;
		StoreVO storeVO = null;
		MenuVO menuVO = null;
		
		try {
	
			System.out.println("aaaaa :" + command.getType());
			offerTypeVO = offerTypeDao.selectById(command.getType());
			storeVO = storeDao.selectByUserId(user.getId());
			//menuVO = menuDao.selectByMenuIdStoreId(menuId, storeId);
			
		}
		catch (OfferTypeSelectException e) {
			e.printStackTrace();
		}
		
		MenuVO menu = new MenuVO();
		
		
		menu.setStore(storeVO);
		menu.setId(menuId);
		menu.setOfferType(offerTypeVO);
		menu.setName(command.getName());
		menu.setPrice(command.getPrice());
		menu.setPhoto(command.getPhoto());
		menu.setAmount(command.getAmount());
		menu.setTag(command.getTag());
		menu.setDescription(command.getDescription());
		menu.setNotice(command.getNotice());
		
		
		System.out.println("menuUpdateServiceImpl의 menu 출력 :"+menu);
		System.out.println("storeVO :" + storeVO);
		System.out.println("menuId : " + menuId);
		System.out.println("offerType VO : " + offerTypeVO);
		System.out.println("getName :" + command.getName());
		System.out.println("--------------------------------");
		
		try {
			menuDao.update(menu, storeVO);
		}
		catch(MenuException e)
		{
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}

}
