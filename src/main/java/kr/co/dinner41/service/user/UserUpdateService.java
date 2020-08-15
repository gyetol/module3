package kr.co.dinner41.service.user;

import javax.servlet.http.HttpSession;

import kr.co.dinner41.command.UserUpdateCommand;
import kr.co.dinner41.exception.UserException;

public interface UserUpdateService {
	void execute(UserUpdateCommand command,HttpSession session)throws UserException;
}
