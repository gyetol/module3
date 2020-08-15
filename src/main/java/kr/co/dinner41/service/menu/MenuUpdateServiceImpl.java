package kr.co.dinner41.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dinner41.command.MenuUpdateCommand;
import kr.co.dinner41.dao.MenuDaoImpl;
import kr.co.dinner41.dao.OfferTypeDaoImpl;
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
	
	@Override
	public void execute(MenuUpdateCommand command, StoreVO store, UserVO user) {
		
		OfferTypeVO offerTypeVO = null;
		
		try {
			offerTypeVO = offerTypeDao.selectById(command.getType());
		}
		catch (OfferTypeSelectException e) {
			e.printStackTrace();
		}
		
		MenuVO menu = new MenuVO();
		menu.setOfferType(offerTypeVO);
		menu.setName(command.getName());
		menu.setPrice(command.getPrice());
		menu.setPhoto(command.getPhoto());
		menu.setAmount(command.getAmount());
		menu.setDescription(command.getIntroduction());
		menu.setNotice(command.getNotice());
		
		try {
			menuDao.update(menu, store);
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
