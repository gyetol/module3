package kr.co.dinner41.service.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.MenuDao;
import kr.co.dinner41.vo.CartVO;

@Service("cartList")
public class CartListServiceImpl implements CartListService {

	@Autowired
	private MenuDao mDao; 
	
	@Override
	public List<CartVO> execute(List<CartVO> carts) {
		
		for (CartVO cart : carts) {
			// MenuDao를 활용해서 cart안을 가득채우면 끝!!
			cart.setPrice(5000);
		}

		return carts;
	}
}
