package kr.co.dinner41.dao;

import java.util.ArrayList;

import kr.co.dinner41.exception.menu.MenuException;
import kr.co.dinner41.vo.MenuVO;
import kr.co.dinner41.vo.StoreVO;

public interface MenuDao {
	
	public void insert(MenuVO menu, StoreVO store) throws MenuException;
	public void delete(int menuId) throws MenuException;
	public void update(MenuVO menu, StoreVO store) throws MenuException;
	public ArrayList<MenuVO> selectAll(int page, int pageSize, String condition, String word) throws MenuException;
	public MenuVO selectById(int menuId) throws MenuException;
	public void getCount(int menuId);
	
}

