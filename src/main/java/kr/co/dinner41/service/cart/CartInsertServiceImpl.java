package kr.co.dinner41.service.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.MenuDao;
import kr.co.dinner41.vo.CartVO;

@Service("cartInsert")
public class CartInsertServiceImpl implements CartInsertService {

	@Override
	public void execute(HttpSession session, int storeId, int menuId) {
		
		@SuppressWarnings("unchecked")
		List<CartVO> carts = (List<CartVO>)session.getAttribute("carts");
		carts.add(new CartVO(storeId, menuId, null, null, 0, 0));
		session.removeAttribute("carts");
		session.setAttribute("carts", carts);
	}
}
