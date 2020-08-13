package kr.co.dinner41.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.dinner41.vo.StoreStateVO;

@Repository("storeStateDao")
public class StoreStateDaoImpl implements StoreStateDao {
	
	@Autowired
	private JdbcTemplate jTemp;
	
	@Override
	public void insert(StoreStateVO storeState) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int id, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StoreStateVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
