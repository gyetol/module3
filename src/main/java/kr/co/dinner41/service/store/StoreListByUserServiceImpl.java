package kr.co.dinner41.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.StoreDao;
import kr.co.dinner41.exception.store.StoreException;
import kr.co.dinner41.vo.StoreListByUserViewVO;

@Service("storeListByUserService")
public class StoreListByUserServiceImpl implements StoreListByUserService {
	 public static final int PAGESIZE = 5;
	
	@Autowired
	@Qualifier("storeDao")
	StoreDao storeDao;

	@Override
	public List<StoreListByUserViewVO> execute(String category, String keyword, double userLatitude, double userLongitude, int page) throws StoreException {
		List<StoreListByUserViewVO> storeListByUserViews = null;
		
		if(keyword.equals("all-")) { //카테고리를 눌러서 검색
			if(category.equals("전체")) {
				storeListByUserViews = storeDao.selectViewByCategoryName("%", userLatitude, userLongitude, page, PAGESIZE);
			}
			else {
				storeListByUserViews = storeDao.selectViewByCategoryName(category,userLatitude,userLongitude,page,PAGESIZE);
			}
		}
		else {
			storeListByUserViews = storeDao.selectViewByStoreNameOrMenuName(keyword, userLatitude, userLongitude, page, PAGESIZE);
		}
		return storeListByUserViews;
	}

}
