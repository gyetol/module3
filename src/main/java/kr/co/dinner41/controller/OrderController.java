package kr.co.dinner41.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dinner41.service.order.OrderDeleteService;
import kr.co.dinner41.service.order.OrderInsertService;
import kr.co.dinner41.service.order.OrderListService;
import kr.co.dinner41.service.order.OrderUpdateService;
import kr.co.dinner41.service.order.OrderViewService;

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

}
