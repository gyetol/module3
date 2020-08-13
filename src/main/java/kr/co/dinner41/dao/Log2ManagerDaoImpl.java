package kr.co.dinner41.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.dinner41.vo.Log2ManagerVO;

@Repository("log2managerDao")
public class Log2ManagerDaoImpl implements Log2ManagerDao {
	@Autowired
	private JdbcTemplate jTemp;

	@Override
	public void insert(Log2ManagerVO log2manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int logId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int logId, int managerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Log2ManagerVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
