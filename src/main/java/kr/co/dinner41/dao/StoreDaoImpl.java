package kr.co.dinner41.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.dinner41.exception.store.StoreException;
import kr.co.dinner41.exception.store.StoreInsertFailedException;
import kr.co.dinner41.vo.OpenState;
import kr.co.dinner41.vo.StoreVO;

@Repository("storeDao")
public class StoreDaoImpl implements StoreDao {
	@Autowired
	private JdbcTemplate jTemp;

	@Override
	public void insert(StoreVO store) throws StoreException {
		String sql = "insert into stores values (default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int result=0;
		try {
			int userId= store.getUser().getId();//1
			String storeCategoryId=store.getCategory().getId();//2
			int storeStateId=store.getState().getId();//3
			String storeBusinessNumber=store.getBusinessNumber();//4
			String storeName= store.getName();//5
			String storeAddress=store.getAddress();//6
			String storeSubAddress=store.getSubAddress();//7
			double storeLatitude=store.getLatitude();//8
			double storeLongitude=store.getLongitude();//9
			String storePhone=store.getPhone();//10
			String storeOperateTime=store.getOperateTime();//11
			String storePhoto=store.getPhoto();//12
			String storeIntroduction=store.getIntroduction();//13
			OpenState storeOpenState = store.getOpenState();//14
			String storePayNumber= store.getPayNumber();//15
			
			result= jTemp.update(sql,userId,storeCategoryId,storeStateId,storeBusinessNumber,storeName,storeAddress,storeSubAddress,
								storeLatitude,storeLongitude,storePhone,storeOperateTime,storePhoto,storeIntroduction,storeOpenState,storePayNumber);
		}
		catch(Exception e) {
			throw new StoreInsertFailedException(e.getMessage());
		}
		if(result==0) {
			throw new StoreInsertFailedException("매장 등록을 시도하였으나 영향받은 행이 없습니다.");
		}
	}
	@Override
	public void delete(int id) throws StoreException {
		String sql = "update stores set store_state_id=? where store ";
		int result=0;
		try {
			result=jTemp.update(sql,id);
		}
	}

	@Override
	public void update(StoreVO store) throws StoreException {

	}

	@Override
	public StoreVO selectById(int id) throws StoreException {
		return null;
	}

	@Override
	public List<StoreVO> selectByCategory(String category, int page, int pageSize) throws StoreException {
		return null;
	}

	@Override
	public List<StoreVO> selectByStateId(int stateId, int page, int pageSize) throws StoreException {
		return null;
	}

	@Override
	public StoreVO selectByBusinessNumber(String businessNumber) throws StoreException {
		return null;
	}

	@Override
	public List<StoreVO> selectByName(String name, int page, int pageSize) throws StoreException {
		return null;
	}

	@Override
	public List<StoreVO> selectByLocation(double latitude, double longitude) throws StoreException {
		return null;
	}

	@Override
	public List<StoreVO> selectByOpenState(OpenState openState, int page, int pageSize) throws StoreException {
		return null;
	}

	@Override
	public List<StoreVO> selectAll(int page, int pageSize) throws StoreException {
		return null;
	}

}
