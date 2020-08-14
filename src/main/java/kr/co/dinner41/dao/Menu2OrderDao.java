package kr.co.dinner41.dao;

import java.util.List;

import kr.co.dinner41.vo.Menu2OrderVO;

public interface Menu2OrderDao {
	void insert(Menu2OrderVO menu2order);
	void delete(Menu2OrderVO menu2order);
	List<Menu2OrderVO> selectAll();
}
