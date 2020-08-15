package kr.co.dinner41.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	// 향후 삭제
	@RequestMapping(value = "/menuView", method = RequestMethod.GET)
	public String menuView() {
		return "user/menuView";
	}

	@ResponseBody
	@RequestMapping(value = "/gm/cart", method = RequestMethod.POST)
	public HashMap<String, Object> insert(HttpServletRequest request, HttpServletResponse response) {

		HashMap<String, Object> map = new HashMap<>();
		HttpSession session = request.getSession(false);
		if (session == null) {
			map.put("result", false);
			map.put("msg", "로그인하지 않으면 장바구니를 사용할 수 없습니다.");
			return map;
		}
		
		@SuppressWarnings("unchecked")
		List<CartVO> carts = (List<CartVO>)session.getAttribute("carts");
		int storeId = Integer.parseInt(request.getParameter("storeId"));
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		
		// 장바구니가 비어있는 경우
		// 메뉴를 장바구니에 바로 담음
		if (carts.isEmpty()) {
			session.setAttribute("carts", new ArrayList<CartVO>());
			insertService.execute(session, storeId, menuId);
		}
		// 장바구니가 비어있지 않은 경우
		// 같은 매장의 메뉴를 넣을 경우 장바구니에 메뉴 추가
		// 다른 매장의 메뉴를 넣을 경우 장바구니를 비우고 새로 메뉴 추가
		else {
			if (carts.get(0).getStoreId() == storeId) {
				insertService.execute(session, storeId, menuId);
			}
			else {
				session.removeAttribute("carts");
				session.setAttribute("carts", new ArrayList<CartVO>());
				insertService.execute(session, storeId, menuId);
				map.put("msg1", "이전 매장의 장바구니 기록은 사라집니다.");
			}
		}
		map.put("result", true);
		map.put("msg2", "장바구니 등록 완료!!");
		return map;
	}
	
	@RequestMapping(value = "/gm/cart", method = RequestMethod.DELETE)
	public String delete(HttpSession sesson, CartVO cart) {
		return "";
	}
	
	@RequestMapping(value = "/gm/cart", method = RequestMethod.GET)
	public String list(HttpSession session, Model model) {

		/*
		// 사용자가 로그인하지 않고 URL을 통해 오는 경우
		if (session == null) {
			return "/sessionCheck";
		}
	
		// 로그인했지만 점주회원, 관리자가 해당 기능을 URL을 통해 사용하려고 하는 경우
		UserVO user = (UserVO)session.getAttribute("loginUser");
		UserTypeVO type = user.getType();
		if (type.getName().equals("AD") || type.getName().equals("SM")) {
			return "/sessionCheck";
		}
		*/
		
		@SuppressWarnings("unchecked")
		List<CartVO> carts = (List<CartVO>)session.getAttribute("carts");
		if (!carts.isEmpty()) {
			// 현재 카트에는 storeId, menuId만 있으므로
			// DB를 거쳐서 CartVO의 나머지 부분을 채워서 리턴
			carts = listService.execute(carts);
		}
		model.addAttribute("carts", carts);
		return "user/cartView";
	}
}