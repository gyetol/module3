package kr.co.dinner41.service.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.MenuDaoImpl;
import kr.co.dinner41.dao.StoreDaoImpl;
import kr.co.dinner41.exception.menu.MenuException;
import kr.co.dinner41.exception.store.StoreException;
import kr.co.dinner41.vo.MenuVO;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;

@Service("menuListByStoreService")
public class MenuListByStoreServiceImpl implements MenuListByStoreService {

	@Autowired
	private StoreDaoImpl storeDao;

	@Autowired
	private MenuDaoImpl menuDao;
	public static final int PAGE_SIZE = 10;

	@Override
	public List<MenuVO> execute(int storeId, int page) throws StoreException, MenuException {
		List<MenuVO> menus = null;
		menus = menuDao.selectByStoreId(storeId, page, PAGE_SIZE);

		return menus;
	}

}
