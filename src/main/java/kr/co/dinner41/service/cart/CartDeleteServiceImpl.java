package kr.co.dinner41.service.cart;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import kr.co.dinner41.vo.CartVO;

@Service("cartDelete")
public class CartDeleteServiceImpl implements CartDeleteService {

	@Override
	public void execute(HttpSession session, String[] menuIds) {

		@SuppressWarnings("unchecked")
		List<CartVO> carts = (List<CartVO>)session.getAttribute("carts");

		System.out.println(menuIds.length);
		System.out.println(carts.size());

		for (int i = 0; i < menuIds.length; i++) {
			int menuId = Integer.parseInt(menuIds[i]);
			for (int j = 0; j < carts.size(); j++) {
				if (carts.get(j).getMenuId() == menuId) {
					carts.remove(j);
					break;
				}
			}
		}
		session.removeAttribute("carts");
		session.setAttribute("carts", carts);
	}
}
