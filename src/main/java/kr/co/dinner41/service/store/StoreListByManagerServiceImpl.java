package kr.co.dinner41.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.StoreDao;
import kr.co.dinner41.exception.store.StoreException;
import kr.co.dinner41.vo.StoreVO;


@Service("storeListByManagerService")
public class StoreListByManagerServiceImpl implements StoreListByManagerService {
	 public static final int PAGESIZE = 5;
	
	@Autowired
	@Qualifier("storeDao")
	StoreDao storeDao;
	
	@Override
	public List<StoreVO> execute(String storeStateName,String storeName,int page) throws StoreException{
		List<StoreVO> stores= null;
		if(storeStateName.equals("all-") && storeName.equals("all-")) {
			stores = storeDao.selectByStateNameAndName("%", "%", page, PAGESIZE);
		}
		else if(storeStateName.equals("all-") && !storeName.equals("all-")) {
			stores=storeDao.selectByStateNameAndName("%", storeName, page, PAGESIZE);
		}
		else if(!storeStateName.equals("all-") && storeName.equals("all-")) {
			stores=storeDao.selectByStateNameAndName(storeStateName, "%", page, PAGESIZE);
		}
		else {
			stores = storeDao.selectByStateNameAndName(storeStateName, storeName, page, PAGESIZE);
		}
		return stores;
	}
}

