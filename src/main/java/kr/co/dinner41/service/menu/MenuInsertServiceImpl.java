package kr.co.dinner41.service.menu;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.dinner41.command.MenuInsertCommand;
import kr.co.dinner41.dao.MenuDaoImpl;
import kr.co.dinner41.dao.OfferTypeDaoImpl;
import kr.co.dinner41.dao.StoreDaoImpl;
import kr.co.dinner41.exception.menu.MenuException;
import kr.co.dinner41.exception.menu.OfferTypeSelectException;
import kr.co.dinner41.vo.MenuVO;
import kr.co.dinner41.vo.OfferTypeVO;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;

@Service("menuInsertService")
public class MenuInsertServiceImpl implements MenuInsertService {

	@Autowired
	@Qualifier("menuDao")
	private MenuDaoImpl menuDao;
	
	@Autowired
	@Qualifier("offerTypeDao")
	private OfferTypeDaoImpl offerTypeDao;	

	@Autowired
	private StoreDaoImpl storeDao;

	@Override
	public void execute(MenuInsertCommand command, UserVO user) {
		
		OfferTypeVO offerTypeVO = null;
		StoreVO storeVO = null;

		try {
			offerTypeVO = offerTypeDao.selectById(command.getType());
			storeVO = storeDao.selectByUserId(user.getId());
			System.out.println("offerType : "+offerTypeVO.getName());
			System.out.println("store : "+storeVO.getName());
		}
		catch (OfferTypeSelectException e) {
			e.printStackTrace();
		}
		
		MenuVO menu = new MenuVO();
		menu.setStore(storeVO);
		menu.setOfferType(offerTypeVO);
		menu.setTag(command.getTag());
		menu.setPhoto(command.getPhoto());
		menu.setPrice(command.getPrice());
		menu.setName(command.getName());
		menu.setAmount(command.getAmount());
		menu.setDescription(command.getIntroduction());
		menu.setNotice(command.getNotice());
		
		//System.out.println("check0");
		
		try {
			menuDao.insert(menu, storeVO);
		}
		catch (MenuException e) {
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}

}
