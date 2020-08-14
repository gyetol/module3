package kr.co.dinner41.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.dinner41.exception.UserDeleteFailedException;
import kr.co.dinner41.exception.UserException;
import kr.co.dinner41.exception.UserInsertFailedException;
import kr.co.dinner41.exception.UserSelectFailedException;
import kr.co.dinner41.exception.UserUpdateFailedException;
import kr.co.dinner41.mapper.UserMapper;
import kr.co.dinner41.vo.UserTypeVO;
import kr.co.dinner41.vo.UserVO;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jTemp;

	@Override
	public void insert(UserVO user) throws UserException{
		String sql="INSERT INTO users VALUES(default,?,?,PASSWORD(?),?,?,?,?,?,?,default,default)";
		int result=0;
		UserTypeVO type=user.getType();
		String email=user.getEmail();
		String password=user.getPassword();
		String name=user.getName();
		String address=user.getAddresss();
		String subAddresss=user.getSubAddress();
		double latitude=user.getLatitude();
		double longitude=user.getLongitude();
		String phone=user.getPhone();
		try {
			result=jTemp.update(sql,type.getId(),email,password,name,address,subAddresss,latitude,longitude,phone);
		}
		catch(DataAccessException e) {
			e.printStackTrace();
			throw new UserInsertFailedException();
		}
		if(result==0) {
			throw new UserInsertFailedException();
		}
	}

	@Override
	public void delete(String email, String password) throws UserException {
		String sql="DELETE FROM users WHERE user_id=?";
		UserVO target=selectByEmailAndPassword(email, password);
		int result=0;
		if(target==null) {
			throw new UserDeleteFailedException("비밀번호가 일치하지 않습니다.");
		}
		try {
			result=jTemp.update(sql,target.getId());
		}
		catch(DataAccessException e) {
			e.printStackTrace();
			throw new UserDeleteFailedException();
		}
		if(result==0) {
			throw new UserDeleteFailedException();
		}
	}

	@Override
	public void update(UserVO user) throws UserException {
		if(user==null) {
			throw new UserUpdateFailedException("(UserDaoImpl)update:전달인자가 null이다");
		}
		String sql="UPDATE users SET user_name=? , user_address=? ,"
				+ " user_sub_address=? , user_latitude=? , user_longitude=? , user_phone=? "
				+ "WHERE user_id=? ";
		int userId=user.getId();
		String userName=user.getName();
		String userAddress=user.getAddresss();
		String userSubAddress=user.getSubAddress();
		double userLatitude=user.getLatitude();
		double userLongitude=user.getLongitude();
		String userPhone=user.getPhone();
		int result=0;
		try {
			result=jTemp.update(sql,userName,userAddress,userSubAddress,userLatitude,userLongitude,userPhone,userId);
		}catch(DataAccessException e) {
			e.printStackTrace();
			throw e;
			//throw new UserUpdateFailedException();
		}
		if(result==0) {
			System.out.println("영향받은 행이 없습니다.");
			//throw new UserUpdateFailedException();
		}
	}
	
	@Override
	public UserVO selectById(int id) throws UserException {
		String sql="SELECT * FROM users WHERE user_id=?";
		List<UserVO> users=null;
		try {
			users=jTemp.query(sql, new UserMapper(),id);
		}catch(DataAccessException e) {
			e.printStackTrace();
			throw new UserSelectFailedException();
		}
		return (users.size()==0?null:users.get(0));
	}

	@Override
	public UserVO selectByEmail(String email) throws UserException {
		String sql="SELECT * FROM users WHERE user_email=?";
		List<UserVO> users=null;
		try {
			users=jTemp.query(sql, new UserMapper(),email);
		}catch(DataAccessException e) {
			e.printStackTrace();
			throw new UserSelectFailedException();
		}
		return (users.size()==0?null:users.get(0));
	}

	@Override
	public UserVO selectByEmailAndPassword(String email, String password) throws UserException {
		String sql="SELECT * FROM users WHERE user_email=? AND user_password=PASSWORD(?)";
		List<UserVO> users=null;
		try {
			users=jTemp.query(sql,new UserMapper(),email,password); 
		}
		catch(DataAccessException e) {
			e.printStackTrace();
			throw new UserSelectFailedException();
		}
		return (users.size()==0?null:users.get(0));
	}

	@Override
	public List<UserVO> selectAll() throws UserException {
		String sql="SELECT * FROM users ";
		List<UserVO> users=null;
		try {
			users=jTemp.query(sql, new UserMapper());
		}
		catch(DataAccessException e) {
			e.printStackTrace();
			throw new UserSelectFailedException();
		}
		return (users.size()==0?null:users);
	}

}
