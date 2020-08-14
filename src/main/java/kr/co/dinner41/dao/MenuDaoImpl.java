package kr.co.dinner41.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.dinner41.exception.menu.MenuDeleteFailedException;
import kr.co.dinner41.exception.menu.MenuException;
import kr.co.dinner41.exception.menu.MenuInsertFailedException;
import kr.co.dinner41.exception.menu.MenuUpdateFailedException;
import kr.co.dinner41.service.menu.MenuListByUserService;
import kr.co.dinner41.service.menu.MenuListByUserServiceImpl;
import kr.co.dinner41.vo.MenuVO;
import kr.co.dinner41.vo.StoreVO;

@Repository("memeberDao")
public class MenuDaoImpl  implements MenuDao{

	@Autowired
	private JdbcTemplate jTemp;
	
	@Override
	public void insert(MenuVO menu, StoreVO store) throws MenuException {
		String sql = "INSERT INTO menus VALUES(?,?,?,?,?,?,?,?,?,?,default)";
		
		int result =0;
		
		try {
			result = jTemp.update(sql, menu.getStore().getId(),menu.getId(),menu.getOfferType(),menu.getTag()
					,menu.getName(), menu.getPrice(), menu.getAmount(),menu.getDescription(),menu.getNotice(),menu.getPhoto());
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new MenuInsertFailedException();
		}
		if (result == 0) {
			throw new MenuInsertFailedException();
		}
	}

	@Override
	public void delete(int menuId) throws MenuException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		String now = sdf.format(calendar.getTime());
		
		String sql = "UPDATE menus SET menu_remove_date = '"+ now +"' WHERE menu_id = " + menuId;
		
		int result =0;
		
		try {
			result = jTemp.update(sql,menuId);
		}
		catch(DataAccessException e) {
			e.printStackTrace();
			throw new MenuDeleteFailedException();
		}
		
		if (result == 0) {
			throw new MenuDeleteFailedException();
		}
		
		
		
	}

	@Override
	public void update(MenuVO menu, StoreVO store) throws MenuException {
		String sql = "UPDATE menus SET offer_type_id = ?, menu_tag = ?, menu_name = ?, menu_price = ?, menu_amount = ?, menu_description = ?, menu_notice = ?,menu_photo = ? WHERE menuId = ? ";
		
        int result =0;
		
		try {
			result = jTemp.update(sql, menu.getOfferType(),menu.getTag(),menu.getName(), menu.getPrice(), menu.getAmount(),menu.getDescription(),menu.getNotice(),menu.getPhoto());
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new MenuUpdateFailedException();
		}
		if (result == 0) {
			throw new MenuUpdateFailedException();
		}
	}

	@Override
	public ArrayList<MenuVO> selectAll(int page, int pageSize, String condition, String word) throws MenuException {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM menus ");
	
		switch(condition) {
		
		case MenuListByUserServiceImpl.CONDITION_TITLE : 
			sb.append("WHERE menu_name LIKE '%" + word + "%' AND menu_remove_date is null ");
			sb.append("AND menu_amount > 0 ");
			break;
			
		case MenuListByUserServiceImpl.CONDITION_DESCRIPTION : 
			sb.append("WHERE menu_description LIKE '%" + word + "%' AND menu_remove_date is null ");
			sb.append("AND menu_amount > 0 ");
			break;
			
		default :
			sb.append("WHERE (menu_name LIKE '%" + word + "%' ");
			sb.append("OR menu_description LIKE '%" + word + "%') ");
			sb.append("AND menu_remove_date is null " );
			break;
		}
		
		int startPoint = (page - 1) * pageSize;
		sb.append("ORDER BY menu_id DESC ");
		sb.append("LIMIT " + startPoint + ","+ pageSize);
		
		
		
	
	
		
	
		
		
	
	
	}

	@Override
	public MenuVO selectById(int menuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getCount(int menuId) {
		// TODO Auto-generated method stub
		
	}

}
