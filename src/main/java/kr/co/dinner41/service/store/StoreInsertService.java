package kr.co.dinner41.service.store;

import kr.co.dinner41.exception.store.StoreException;
import kr.co.dinner41.vo.StoreVO;

public interface StoreInsertService {
	void execute(StoreVO store) throws StoreException;
}