package kr.co.dinner41.dao;

import java.util.List;

import kr.co.dinner41.exception.store.StoreException;
import kr.co.dinner41.vo.OpenState;
import kr.co.dinner41.vo.StoreVO;

public interface StoreDao {
	void insert(StoreVO store) throws StoreException;
	void deleteByStore(int id) throws StoreException;
	void deleteByManager(int id) throws StoreException;
	void update(StoreVO store) throws StoreException;
	StoreVO selectById(int id) throws StoreException;
	List<StoreVO> selectByCategory(String category, int page, int pageSize) throws StoreException;
	List<StoreVO> selectByStateId(int stateId, int page, int pageSize) throws StoreException;
	StoreVO selectByBusinessNumber(String businessNumber) throws StoreException;
	List<StoreVO> selectByName(String name, int page, int pageSize) throws StoreException;
	List<StoreVO> selectByLocation(double latitude, double longitude) throws StoreException;
	List<StoreVO> selectByOpenState(OpenState openState, int page, int pageSize) throws StoreException;
	List<StoreVO> selectAll(int page,int pageSize) throws StoreException;
}