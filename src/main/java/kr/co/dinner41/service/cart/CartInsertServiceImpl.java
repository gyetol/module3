package kr.co.dinner41.service.cart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import kr.co.dinner41.vo.CartVO;

@Service("cartInsert")
public class CartInsertServiceImpl implements CartInsertService {

	@Override
	public void execute(HttpSession session, int storeId, int menuId) {
		
		// 로그인하면 세션에 List<CartVO>객체를 넣고, 로그아웃하면 세션에서 List<CartVO>객체를 삭제해야함
		// 따라서 로그인되어있는 동안에는 세션에 List<CartVO>객체가 반드시 존재해야함
		// 리스트 내부가 비어있을수는 있어도 리스트 자체가 없어져서는 안됨
		@SuppressWarnings("unchecked")
		List<CartVO> carts = (List<CartVO>)session.getAttribute("carts");
		
		// 수정 필요
		// 원래는 이곳이 아니라 로그인이 끝나는 순간해야되는 것임
		if (carts == null) {
			carts = new ArrayList<CartVO>();
		}
		
		carts.add(new CartVO(storeId, menuId, null, null, 0, 0));
		session.removeAttribute("carts");
		session.setAttribute("carts", carts);
	}
}
