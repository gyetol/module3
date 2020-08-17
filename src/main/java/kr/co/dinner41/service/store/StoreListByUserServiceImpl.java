package kr.co.dinner41.service.store;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.ReviewDao;
import kr.co.dinner41.dao.StoreDao;
import kr.co.dinner41.exception.ReviewException;
import kr.co.dinner41.exception.store.StoreException;
import kr.co.dinner41.vo.StoreListByUserViewVO;

@Service("storeListByUserService")
public class StoreListByUserServiceImpl implements StoreListByUserService {
	 public static final int PAGESIZE = 5;
	
	@Autowired
	@Qualifier("storeDao")
	StoreDao storeDao;
	
	@Autowired
	@Qualifier("reviewDao")
	ReviewDao reviewDao;

	@Override
	public List<StoreListByUserViewVO> execute(String category, String keyword, double userLatitude, double userLongitude, int page) throws StoreException, ReviewException {
		List<StoreListByUserViewVO> storeListByUserViews = null;
		HashMap<StoreListByUserViewVO,Double> map = null;
		List<Double> averageScores =null;
		
		
			if(category.equals("all-")) {
				if(keyword.equals("all-")) {
					storeListByUserViews = storeDao.selectViewByStoreNameOrMenuName("%", userLatitude, userLongitude, page, PAGESIZE);
				}
				else {
					storeListByUserViews = storeDao.selectViewByStoreNameOrMenuName(keyword, userLatitude, userLongitude, page, PAGESIZE);
				}
				
			}
			else {
				if(keyword.equals("all-")) {
					storeListByUserViews = storeDao.selectViewByCategoryName(category,userLatitude,userLongitude,page,PAGESIZE);
				}
				else {
					//카테고리와 키워드를 둘다 이용하여 검색
				}
				
			}
		
		return storeListByUserViews;
	}
	

}
