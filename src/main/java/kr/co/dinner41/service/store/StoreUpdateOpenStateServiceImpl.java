//package kr.co.dinner41.service.store;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import kr.co.dinner41.dao.StoreDao;
//import kr.co.dinner41.exception.store.StoreException;
//import kr.co.dinner41.vo.OpenState;
//
//@Service("storeUpdateOpenStateService")
//public class StoreUpdateOpenStateServiceImpl implements StoreUpdateOpenStateService {
//	@Autowired
//	@Qualifier("StoreDao")
//	StoreDao storeDao;
//	
//	@Override
//	public void execute(int storeId,OpenState openState) throws StoreException {
//		storeDao.switchOpenState(storeId,openState);
//	}
//
//}
