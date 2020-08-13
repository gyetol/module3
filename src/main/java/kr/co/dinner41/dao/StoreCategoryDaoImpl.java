package kr.co.dinner41.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.dinner41.vo.StoreCategoryVO;

@Repository("storeCategoryDao")
public class StoreCategoryDaoImpl implements StoreCategoryDao {

	@Autowired
	private JdbcTemplate jTemp;
	
	@Override
	public void insert(StoreCategoryVO storeCategory) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String id, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StoreCategoryVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
