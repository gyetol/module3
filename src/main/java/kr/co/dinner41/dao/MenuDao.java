package kr.co.dinner41.dao;

import java.util.ArrayList;

import kr.co.dinner41.vo.MenuVO;

public interface MenuDao {
	void insert(MenuVO menu, StoreVO store);
	void delete(int menuId);
	void update(MenuVO menu, StoreVO store);
	ArrayList<MenuVO> selectAll(int page, int pageSize, String condition, String word, String offerType);
	MenuVO selectById(int menuId);
	void getCount(int menuId);

}
