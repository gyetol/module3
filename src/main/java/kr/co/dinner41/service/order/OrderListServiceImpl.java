package kr.co.dinner41.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.OrderDao;
import kr.co.dinner41.vo.OrderViewVO;

@Service("orderList")
public class OrderListServiceImpl implements OrderListService {

	@Autowired
	@Qualifier("orderDao")
	private OrderDao oDao;

	@Override
	public List<OrderViewVO> execute(int userId) {
		
		List<OrderViewVO> list = null;
		list = oDao.selectAllOrderView(userId);
		return list;
	}
}
