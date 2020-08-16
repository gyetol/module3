package kr.co.dinner41.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import kr.co.dinner41.exception.order.OrderException;
import kr.co.dinner41.mapper.OrderMapper;
import kr.co.dinner41.vo.OrderVO;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private JdbcTemplate jTemp;
	
	@Override
	public void insert(OrderVO order) throws OrderException {
		KeyHolder holder = new GeneratedKeyHolder();
		String sql = "INSERT INTO orders VALUES(DEFAULT, ?, ?, ?, DEFAULT, ?)";
		String[] columns = {"id"};

		jTemp.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql, columns);
				pstmt.setInt(1, order.getUser().getId());
				pstmt.setTimestamp(2, order.getOrderDate());
				pstmt.setTimestamp(3, order.getReserveDate());
				pstmt.setInt(4, order.getPrice());
				return pstmt;
			}
		}, holder);
		Number number = holder.getKey();
		int value = number.intValue();
		order.setId(value);
	}

	@Override
	public void delete(int orderId) {
		// 향후 구현
	}

	@Override
	public void update(int orderId, Timestamp pickupDate) throws OrderException {
		String sql = "UPDATE orders SET order_pickup_date=CURRENT_TIMESTAMP WHERE order_id=?";
		jTemp.update(sql, orderId);
	}

	@Override
	public OrderVO selectById(int orderId) {
		List<OrderVO> list = null;
		String sql = "SELECT * FROM orders WHERE order_id=?";
		list = jTemp.query(sql, new OrderMapper(), orderId);
        return (list.size() == 0? null:list.get(0));
	}

	@Override
	public List<OrderVO> selectAll() {
		List<OrderVO> list = null;
		String sql = "SELECT * FROM orders";
		list = jTemp.query(sql, new OrderMapper());
		return list;
	}
}
