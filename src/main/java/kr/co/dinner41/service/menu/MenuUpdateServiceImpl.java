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
	public void execute(MenuUpdateCommand command, UserVO user) {
		
		OfferTypeVO offerTypeVO = null;
		StoreVO storeVO = null;
		
		try {
			offerTypeVO = offerTypeDao.selectById(command.getType());
			System.out.println(command.getType());
			storeVO = storeDao.selectByUserId(user.getId());
			System.out.println("offerTypeVO : " + offerTypeVO);
			System.out.println("storeVO : " + storeVO);
		}
		catch (OfferTypeSelectException e) {
			e.printStackTrace();
		}
		
		MenuVO menu = new MenuVO();
		menu.setStore(storeVO);
		menu.setOfferType(offerTypeVO);
		menu.setName(command.getName());
		menu.setPrice(command.getPrice());
		menu.setPhoto(command.getPhoto());
		menu.setAmount(command.getAmount());
		menu.setDescription(command.getIntroduction());
		menu.setNotice(command.getNotice());
		
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
