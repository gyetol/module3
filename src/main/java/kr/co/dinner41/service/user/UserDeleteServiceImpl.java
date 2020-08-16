package kr.co.dinner41.service.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import kr.co.dinner41.exception.user.UserException;

@Service("userDeleteService")
public class UserDeleteServiceImpl implements UserDeleteService {

	@Override
	public void execute(String password, HttpSession session) throws UserException {
		// TODO Auto-generated method stub

	}

}
