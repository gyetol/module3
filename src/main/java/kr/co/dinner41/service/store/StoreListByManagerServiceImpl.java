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
	@Autowired
	@Qualifier("storeDao")
	StoreDao storeDao;
	
	 public static final int PAGESIZE = 10;
	

	@Override
	public List<StoreVO> execute(String storeStateName,String StoreName,int page) throws StoreException{
		return null;
	}

}

