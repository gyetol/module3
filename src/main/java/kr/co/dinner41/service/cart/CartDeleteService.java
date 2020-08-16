package kr.co.dinner41.service.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface CartDeleteService {
	public void execute(HttpSession session, String[] menuIds);
}
