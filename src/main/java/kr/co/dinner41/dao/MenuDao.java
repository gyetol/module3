package kr.co.dinner41.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.co.dinner41.exception.menu.MenuException;
import kr.co.dinner41.exception.store.StoreException;
import kr.co.dinner41.vo.MenuVO;
import kr.co.dinner41.vo.OpenState;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;

public interface MenuDao {
	
	void insert(MenuVO menu, StoreVO store) throws MenuException;
	void delete(int menuId, int storeId) throws MenuException;
	void update(MenuVO menu, StoreVO store) throws MenuException;
	List<MenuVO> selectAll(int page, int pageSize, String condition, String word) throws MenuException;
	List<MenuVO> selectByStoreId(int storeId, int page, int pageSize) throws MenuException;
	MenuVO selectByMenuId(int menuId) throws MenuException;
	MenuVO selectByMenuIdStoreId(int menuId, int storeId) throws MenuException;
	int getTotalRecord() throws MenuException;
	int getLastInsertId(int storeId) throws SQLException;
	List<MenuVO> userSelectByStoreId(int storeId, int page, int pageSize) throws MenuException;
	
	
}

