package kr.co.dinner41.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.dinner41.service.order.OrderDeleteService;
import kr.co.dinner41.service.order.OrderInsertService;
import kr.co.dinner41.service.order.OrderListService;
import kr.co.dinner41.service.order.OrderUpdateService;
import kr.co.dinner41.service.order.OrderViewService;
import kr.co.dinner41.vo.UserVO;

@Controller
public class OrderController {

	@Autowired
	@Qualifier("orderInsert")
	OrderInsertService insertService;

	@Autowired
	@Qualifier("orderDelete")
	OrderDeleteService deleteService;

	@Autowired
	@Qualifier("orderUpdate")
	OrderUpdateService updateService;
	
	@Autowired
	@Qualifier("orderList")
	OrderListService listService;

	@Autowired
	@Qualifier("orderView")
	OrderViewService viewService;
	
	@RequestMapping(value = "/gm/order", method = RequestMethod.GET)
	public String insert() {
		return "user/orderInsert";
	}

	@ResponseBody
	@RequestMapping(value = "/gm/order", method = RequestMethod.POST)
	public HashMap<String, Object> insert(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();
		HttpSession session = request.getSession(false);
		String [] arrForOrder = (String[])session.getAttribute("arrForOrder");
		String [] arrForOrder2 = (String[])session.getAttribute("arrForOrder2");
		UserVO user = (UserVO)session.getAttribute("loginUser");
		int userId = user.getId();
		
		String getTime = request.getParameter("getTime");
		String payTotal = request.getParameter("payTotal");
		payTotal = payTotal.replaceAll("[^0-9]", "");
		
		insertService.execute(arrForOrder, arrForOrder2, userId, Integer.parseInt(getTime), Integer.parseInt(payTotal));
		
		JSONArray jArray = new JSONArray();
		map.put("msg", "결제가 완료되었습니다.");
		return map;
	}
}
