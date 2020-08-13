package kr.co.dinner41.dao;

import java.util.List;

import jdk.jshell.spi.ExecutionControl.UserException;
import kr.co.dinner41.vo.UserVO;

public class UserDaoImpl implements UserDao {

	@Override
	public void insert(UserVO user) throws UserException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String email, String password) throws UserException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(UserVO user) throws UserException {
		// TODO Auto-generated method stub

	}

	@Override
	public UserVO selectByEmail(String email) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO selectByEmailAndPassword(String email, String password) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> selectAll() throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
