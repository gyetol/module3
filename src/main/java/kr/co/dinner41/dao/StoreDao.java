package kr.co.dinner41.dao;

import java.util.List;

import kr.co.dinner41.vo.OpenState;
import kr.co.dinner41.vo.StoreVO;

public interface StoreDao {
	void insert(StoreVO store);
	void delete(int id);
	void update(StoreVO store);
	StoreVO selectById(int id);
	List<StoreVO> selectByCategory(String category, int page, int pageSize);
	List<StoreVO> selectByStateId(int stateId, int page, int pageSize);
	StoreVO selectByBusinessNumber(String businessNumber);
	List<StoreVO> selectByName(String name, int page, int pageSize);
	List<StoreVO> selectByLocation(double latitude, double longitude);
	List<StoreVO> selectByOpenState(OpenState openState, int page, int pageSize);
	List<StoreVO> selectAll(int page,int pageSize);
}
