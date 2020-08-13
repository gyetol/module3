package kr.co.dinner41.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.dinner41.vo.OpenState;
import kr.co.dinner41.vo.StoreVO;

@Repository("storeDao")
public class StoreDaoImpl implements StoreDao {
	@Autowired
	private JdbcTemplate jTemp;

	@Override
	public void insert(StoreVO store) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(StoreVO store) {
		// TODO Auto-generated method stub

	}

	@Override
	public StoreVO selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreVO> selectByCategory(String category, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreVO> selectByStateId(int stateId, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreVO selectByBusinessNumber(String businessNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreVO> selectByName(String name, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreVO> selectByLocation(double latitude, double longitude) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreVO> selectByOpenState(OpenState openState, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreVO> selectAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
