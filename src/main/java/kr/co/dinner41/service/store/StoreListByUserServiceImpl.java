package kr.co.dinner41.service.store;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.StoreDao;
import kr.co.dinner41.exception.store.StoreException;

@Service("storeListByUserService")
public class StoreListByUserServiceImpl implements StoreListByUserService {
	@Autowired
	@Qualifier("storeDao")
	StoreDao storeDao;

	@Override
	public void execute(HttpSession session) throws StoreException {
		
	}

}
