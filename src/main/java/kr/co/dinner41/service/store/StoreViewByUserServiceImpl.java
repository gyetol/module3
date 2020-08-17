package kr.co.dinner41.service.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.StoreDao;
import kr.co.dinner41.exception.store.StoreException;
import kr.co.dinner41.vo.StoreVO;

@Service("storeViewByUserService")
public class StoreViewByUserServiceImpl implements StoreViewByUserService {
	@Autowired
	@Qualifier("storeDao")
	StoreDao storeDao;
	
	@Override
	public StoreVO execute(int storeId) throws StoreException {
		// TODO Auto-generated method stub
		return null;
	}

}
