package kr.co.dinner41.service.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.MenuDaoImpl;
import kr.co.dinner41.vo.MenuVO;
import kr.co.dinner41.vo.UserVO;

@Service("menuListByStoreService")
public class MenuListByStoreServiceImpl implements MenuListByStoreService {
	
	@Autowired
	private MenuDaoImpl menuDao;
	public static final int PAGE_SIZE = 10;
	
//	@Override
//	public List<MenuVO> exectue(UserVO user, int page) {
//		List<MenuVO> list = null;
//		try {
//			list = menuDao.selectAll(page, PAGE_SIZE, condition, word);
//		}
//		
//	}

	@Override
	public List<MenuVO> execute(UserVO user, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> getPages() {
		// TODO Auto-generated method stub
		return null;
	}

}
