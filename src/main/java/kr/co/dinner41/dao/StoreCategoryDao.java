package kr.co.dinner41.dao;

import java.util.List;

import kr.co.dinner41.vo.StoreCategoryVO;

public interface StoreCategoryDao {
	void insert(StoreCategoryVO storeCategory);
	void delete(String id);
	void update(String id,String name);
	List<StoreCategoryVO> selectAll();
}
