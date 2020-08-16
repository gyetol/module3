package kr.co.dinner41.service.user;

import javax.servlet.http.HttpSession;

import kr.co.dinner41.exception.user.UserException;

public interface UserDeleteService {
	void execute(String password,HttpSession session)throws UserException;
}
