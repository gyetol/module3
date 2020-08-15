package kr.co.dinner41.service.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import kr.co.dinner41.command.UserUpdateCommand;
import kr.co.dinner41.exception.UserException;

@Service("userUpdateService")
public class UserUpdateServiceImpl implements UserUpdateService {

	@Override
	public void execute(UserUpdateCommand command, HttpSession session) throws UserException {
		// TODO Auto-generated method stub

	}

}
