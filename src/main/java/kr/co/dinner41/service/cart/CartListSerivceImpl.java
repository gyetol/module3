package kr.co.dinner41.service.cart;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.dinner41.vo.CartVO;

@Service("cartList")
public class CartListSerivceImpl implements CartListService {

	@Override
	public List<CartVO> execute(List<CartVO> carts) {
		// 여기서 CartVO를 꽉 채워라
		return carts;
	}
}
