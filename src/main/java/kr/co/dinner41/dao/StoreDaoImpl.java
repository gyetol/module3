package kr.co.dinner41.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.dinner41.exception.store.StoreDeleteFailedException;
import kr.co.dinner41.exception.store.StoreException;
import kr.co.dinner41.exception.store.StoreInsertFailedException;
import kr.co.dinner41.exception.store.StoreSelectFailedException;
import kr.co.dinner41.exception.store.StoreUpdateFailedException;
import kr.co.dinner41.mapper.StoreMapper;
import kr.co.dinner41.vo.OpenState;
import kr.co.dinner41.vo.StoreVO;

@Repository("storeDao")
public class StoreDaoImpl implements StoreDao {
	@Autowired
	private JdbcTemplate jTemp;
	
	private int searchDistance=1; //1km검색

	@Override
	public void insert(StoreVO store) throws StoreException {
		String sql = "insert into stores values (default,?,?,?,?,?,?,?,?,?,?,?,?,?,default,?)";
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
			//OpenState storeOpenState = store.getOpenState();//
			String storePayNumber= store.getPayNumber();//14
			
			result= jTemp.update(sql,userId,storeCategoryId,storeStateId,storeBusinessNumber,storeName,storeAddress,storeSubAddress,
								storeLatitude,storeLongitude,storePhone,storeOperateTime,storePhoto,storeIntroduction,storePayNumber);
		}
		catch(Exception e) {
			throw new StoreInsertFailedException(e.getMessage());
		}
		if(result==0) {
			throw new StoreInsertFailedException("매장 등록을 시도하였으나 영향받은 행이 없습니다.");
		}
	}
	@Override
	public void deleteByStore(int id) throws StoreException {
		String sql = "update stores set store_state_id=4 where store_id=?";
		int result=0;
		try {
			result=jTemp.update(sql,id);
		}
		catch(Exception e) {
			throw new StoreDeleteFailedException(e.getMessage());
		}
		if(result==0){
			throw new StoreDeleteFailedException("매장 삭제를 시도하였으나 영향받은 행이 없습니다.");
		}
	}
	
	@Override
	public void deleteByManager(int id) throws StoreException{
		String sql = "update stores set store_state_id=5 where store_id=?";
		int result=0;
		try {
			result=jTemp.update(sql,id);
		}
		catch(Exception e) {
			throw new StoreDeleteFailedException(e.getMessage());
		}
		if(result==0){
			throw new StoreDeleteFailedException("매장 삭제를 시도하였으나 영향받은 행이 없습니다.");
		}
	}

	@Override
	public void update(StoreVO store) throws StoreException {
		String sql= "update stores set user_id=?, store_category_id=?, store_state_id=?, store_business_number=?,store_name=?, "
				+	"store_address=?, store_sub_address=?,store_latitude=?,store_longitude=?,store_phone=?,store_operate_time=?, "
				+	"store_photo=?, store_introduction=?, store_open_state=?, store_paynumber=?" 
				+	"where store_id=?";
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
			int storeId=store.getId(); //16
			
			result= jTemp.update(sql,userId,storeCategoryId,storeStateId,storeBusinessNumber,storeName,storeAddress,storeSubAddress,
					storeLatitude,storeLongitude,storePhone,storeOperateTime,storePhoto,storeIntroduction,storeOpenState,storePayNumber,storeId);
		}
		catch(Exception e) {
			throw new StoreUpdateFailedException(e.getMessage());
		}
		if(result==0) {
			throw new StoreUpdateFailedException("매장 수정을 시도하였으나 영향받은 행이 없습니다.");
		}
	}

	@Override
	public StoreVO selectById(int id) throws StoreException {
		String sql = "select * from store_view where store_id=?";
		List<StoreVO> stores =null;
		try {
			stores=jTemp.query(sql,new StoreMapper(),id);
		}
		catch(Exception e) {
			throw new StoreSelectFailedException(e.getMessage());
		}
		return (stores.size()>0?stores.get(0):null);
	}
	
	@Override
	public StoreVO selectByUserId(int userId) throws StoreException{
		String sql = "select * from store_view where user_id=?";
		List<StoreVO> stores =null;
		try {
			stores=jTemp.query(sql,new StoreMapper(),userId);
		}
		catch(Exception e) {
			throw new StoreSelectFailedException(e.getMessage());
		}
		return (stores.size()>0?stores.get(0):null);
	}

	@Override
	public List<StoreVO> selectByCategoryName(String categoryName, double userLatitude, double userLongitude,int page, int pageSize) throws StoreException {
		int startPos = (page-1)*pageSize;
		
		StringBuffer sb = new StringBuffer();
		sb.append("select *,(6371*acos(cos(radians("+userLatitude+"))*cos(radians(store_latitude))*cos(radians(store_longitude)-");
		sb.append("radians("+userLongitude+"))+sin(radians("+userLatitude+"))*sin(radians(store_latitude))))");
		sb.append(" AS distance from (select * from store_view where store_category_name like '"+categoryName+"') AS viewByCategory "); 
		sb.append(" HAVING distance <=1 order by distance limit "+startPos+","+pageSize);
		
		String sql = sb.toString();
		List<StoreVO> stores = null;
		try {
			stores=jTemp.query(sql, new StoreMapper());
		}
		catch(Exception e) {
			throw new StoreSelectFailedException(e.getMessage());
		}
		return (stores.size()>0? stores: null);
	}
	
	@Override
	public List<StoreVO> selectByCategoryNameOnMap(String categoryName, double userLatitude, double userLongitude) throws StoreException {
		StringBuffer sb = new StringBuffer();
		sb.append("select *,(6371*acos(cos(radians("+userLatitude+"))*cos(radians(store_latitude))*cos(radians(store_longitude)-");
		sb.append("radians("+userLongitude+"))+sin(radians("+userLatitude+"))*sin(radians(store_latitude))))");
		sb.append(" AS distance from (select * from store_view where store_category_name like '"+categoryName+"') AS viewByCategory "); 
		sb.append(" HAVING distance <=1 order by distance limit 0,300");
		
		String sql = sb.toString();
		List<StoreVO> stores = null;
		try {
			stores=jTemp.query(sql, new StoreMapper());
		}
		catch(Exception e) {
			throw new StoreSelectFailedException(e.getMessage());
		}
		return (stores.size()>0? stores: null);
	}

	@Override
	public List<StoreVO> selectByStateName(String stateName, int page, int pageSize) throws StoreException {
		int startPos = (page-1)*pageSize;
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from store_view ");
		sb.append("where store_state_name='"+stateName+"' ");
		sb.append("order by store_id ASC limit "+startPos+","+pageSize);
		
		String sql = sb.toString();
		List<StoreVO> stores = null;
		try {
			stores=jTemp.query(sql, new StoreMapper());
		}
		catch(Exception e) {
			throw new StoreSelectFailedException(e.getMessage());
		}
		return (stores.size()>0? stores: null);
	}
	
	@Override
	public List<StoreVO> selectByStateNameAndName(String stateName,String name,int page,int pageSize) throws StoreException{
		int startPos = (page-1)*pageSize;
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from store_view ");
		sb.append("where store_state_name='"+stateName+"' and store_name like '%"+name+"%' ");
		sb.append("order by store_id ASC limit "+startPos+","+pageSize);
		
		String sql = sb.toString();
		List<StoreVO> stores = null;
		try {
			stores=jTemp.query(sql, new StoreMapper());
		}
		catch(Exception e) {
			throw new StoreSelectFailedException(e.getMessage());
		}
		return (stores.size()>0? stores: null);
	}

	@Override
	public StoreVO selectByBusinessNumber(String businessNumber) throws StoreException {
		String sql = "select * from store_view where store_business_number=?";
		List<StoreVO> stores =null;
		try {
			stores=jTemp.query(sql, new StoreMapper(),businessNumber);
		}
		catch(Exception e) {
			throw new StoreSelectFailedException(e.getMessage());
		}
		return (stores.size()>0?stores.get(0):null);
	}

	@Override
	public List<StoreVO> selectByName(String name,double userLatitude, double userLongitude, int page, int pageSize) throws StoreException {
		int startPos = (page-1)*pageSize;
		
		StringBuffer sb = new StringBuffer();
		sb.append("select *,(6371*acos(cos(radians("+userLatitude+"))*cos(radians(store_latitude))*cos(radians(store_longitude)-");
		sb.append("radians("+userLongitude+"))+sin(radians("+userLatitude+"))*sin(radians(store_latitude))))");
		sb.append(" AS distance from (select * from store_view where store_name like '%"+name+"%') AS viewByCategory "); 
		sb.append(" HAVING distance <=1 order by distance limit "+startPos+","+pageSize);
		
		String sql = sb.toString();
		List<StoreVO> stores = null;
		try {
			stores=jTemp.query(sql, new StoreMapper());
		}
		catch(Exception e) {
			throw new StoreSelectFailedException(e.getMessage());
		}
		return (stores.size()>0? stores: null);
	}

	@Override
	public List<StoreVO> selectByLocation(double userLatitude, double userLongitude) throws StoreException {
		StringBuffer sb = new StringBuffer();
		sb.append("select *,(6371*acos(cos(radians("+userLatitude+"))*cos(radians(store_latitude))*cos(radians(store_longitude)-");
		sb.append("radians("+userLongitude+"))+sin(radians("+userLatitude+"))*sin(radians(store_latitude))))");
		sb.append("AS distance from store_view HAVING distance <=1 order by distance limit 0,300");
		
		String sql = sb.toString();
		List<StoreVO> stores = null;
		try {
			stores=jTemp.query(sql, new StoreMapper());
		}
		catch(Exception e) {
			throw new StoreSelectFailedException(e.getMessage());
		}
		return (stores.size()>0? stores: null);
	}

	@Override
	public List<StoreVO> selectByOpenState(OpenState openState, int page, int pageSize) throws StoreException {
		int startPos = (page-1)*pageSize;
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from store_view ");
		sb.append("where store_open_state='"+openState+"' ");
		sb.append("order by store_id ASC limit "+startPos+","+pageSize);
		
		String sql = sb.toString();
		List<StoreVO> stores = null;
		try {
			stores=jTemp.query(sql, new StoreMapper());
		}
		catch(Exception e) {
			throw new StoreSelectFailedException(e.getMessage());
		}
		return (stores.size()>0? stores: null);
	}

	@Override
	public List<StoreVO> selectAll(int page, int pageSize) throws StoreException {
		int startPos = (page-1)*pageSize;
		StringBuffer sb = new StringBuffer();
		sb.append("select * from store_view ");
		sb.append("order by store_id desc limit "+startPos+","+pageSize);
		
		String sql = sb.toString();
		List<StoreVO> stores =null;
		try {
			stores=jTemp.query(sql, new StoreMapper());
		}
		catch(Exception e) {
			throw new StoreSelectFailedException(e.getMessage());
		}
		return (stores.size()>0? stores:null);
	}

}
