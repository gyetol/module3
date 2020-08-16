package kr.co.dinner41.service.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.UserDao;
import kr.co.dinner41.exception.login.SearchPasswordException;

@Service("searchPasswordService")
public class SearchPasswordServiceImpl implements SearchPasswordService {
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	@Override
	public void exectue(HttpServletRequest request) throws SearchPasswordException {

	}

}
