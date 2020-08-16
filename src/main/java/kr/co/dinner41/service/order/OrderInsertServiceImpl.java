package kr.co.dinner41.service.order;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.dinner41.dao.Menu2OrderDao;
import kr.co.dinner41.dao.OrderDao;
import kr.co.dinner41.vo.Menu2OrderVO;
import kr.co.dinner41.vo.MenuVO;
import kr.co.dinner41.vo.OrderVO;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;


@Service("orderInsert")
public class OrderInsertServiceImpl implements OrderInsertService {

	@Autowired
	@Qualifier("orderDao")
	private OrderDao oDao;

	@Autowired
	@Qualifier("menu2orderDao")
	private Menu2OrderDao m2oDao;

	@Override
	public void execute(String[] arrForOrder, String[] arrForOrder2, int userId, int getTime, int payTotal) {
		OrderVO order = new OrderVO();
		UserVO user = new UserVO();
		user.setId(userId);
		order.setUser(user);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String orderDate = sdf.format(cal.getTime());
		order.setOrderDate(Timestamp.valueOf(orderDate));
		
		cal.add(Calendar.MINUTE, getTime);
		
		String reserveDate = sdf.format(cal.getTime());
		order.setReserveDate(Timestamp.valueOf(reserveDate));
		order.setPrice(payTotal);
	
		// 주문 내역을 데이터베이스에 저장
		oDao.insert(order);

		System.out.println("id : " + order.getId());
		
		Menu2OrderVO menu2order = new Menu2OrderVO();
		// 주문 목록 내역을 데이터베이스에 저장
		m2oDao.insert(menu2order);
	}
}
