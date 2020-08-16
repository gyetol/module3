package kr.co.dinner41.service.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import kr.co.dinner41.exception.user.UserException;
import kr.co.dinner41.vo.UserVO;

@Service("userViewService")
public class UserViewServiceImpl implements UserViewService {

	@Override
	public UserVO execute(HttpSession session) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
