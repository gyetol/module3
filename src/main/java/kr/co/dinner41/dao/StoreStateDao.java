package kr.co.dinner41.dao;

import java.util.List;

import kr.co.dinner41.vo.StoreStateVO;

public interface StoreStateDao {
	void insert(StoreStateVO storeState);
	void delete(int id);
	void update(int id,String name);
	List<StoreStateVO> selectAll();
}
