package kr.co.dinner41.dao;

import java.util.List;

import kr.co.dinner41.exception.UserException;
import kr.co.dinner41.vo.UserVO;

public interface UserDao {
	void insert(UserVO user) throws UserException;
	void delete(String email,String password)throws UserException;
	void update(UserVO user)throws UserException;
	UserVO selectById(int id)throws UserException;
	UserVO selectByEmail(String email)throws UserException;
	UserVO selectByEmailAndPassword(String email,String password)throws UserException;
	List<UserVO> selectAll()throws UserException;
}
