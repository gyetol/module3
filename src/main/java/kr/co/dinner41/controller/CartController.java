package kr.co.dinner41.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dinner41.service.cart.CartInsertService;
import kr.co.dinner41.service.cart.CartListService;
import kr.co.dinner41.vo.CartVO;

@Controller
public class CartController {

	@Autowired
	@Qualifier("cartInsert")
	CartInsertService insertService;

	@Autowired
	@Qualifier("cartList")
	CartListService listService;

	// 장바구니에 등록
	@RequestMapping(value = "/gm/cart", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {

		// 수정 필요
		// request.getSession(false)로 바꾸어야함
		// 그래야 세션 객체가 존재하지 않을 경우 null을 반환
		HttpSession session = request.getSession(true);
		
		int storeId = Integer.parseInt(request.getParameter("storeId"));
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		insertService.execute(session, storeId, menuId);
		
		// 이 리턴값으로 인해 해당 페이지로 이동하는 것은 아님
		// 근데 제대로 된 jsp페이지를 써주어야 오류가 안나긴함
		// 좀 더 공부 필요
		return "user/storeDetail_menu";
	}

	@RequestMapping(value = "/gm/cart", method = RequestMethod.GET)
	public String list(HttpSession session, Model model) {
		List<CartVO> carts = (List<CartVO>)session.getAttribute("carts");
		if (carts.isEmpty()) {
			// 장바구니가 비어있다고 처리
		}
		
		// 현재 리스트의 CartVO에는 storeId, menuId만 저장되어있다
		// 이 리스트의 CartVO를 채워서 다시 리턴한다
		carts = listService.execute(carts);
		model.addAttribute("carts", carts);
		return "user/cartView";
	}

	// 수정 필요
	// 여기 있으면 안됨
	@RequestMapping(value = "/menuView", method = RequestMethod.GET)
	public String menuView() {
		return "user/menuView";
	}
}
