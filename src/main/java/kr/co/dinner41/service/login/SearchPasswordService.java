package kr.co.dinner41.service.login;

import javax.servlet.http.HttpServletRequest;

import kr.co.dinner41.exception.login.SearchPasswordException;

public interface SearchPasswordService {
	void exectue(HttpServletRequest request)throws SearchPasswordException;
}
