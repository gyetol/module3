package kr.co.dinner41.service.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.StoreDao;
import kr.co.dinner41.exception.store.StoreException;
import kr.co.dinner41.vo.StoreVO;

@Service("storeUpdateService")
public class StoreUpdateServiceImpl implements StoreUpdateService {
	@Autowired
	@Qualifier("storeDao")
	StoreDao storeDao;
	
	@Override
	public void execute(StoreVO store) throws StoreException {
		storeDao.update(store);

	}

}
