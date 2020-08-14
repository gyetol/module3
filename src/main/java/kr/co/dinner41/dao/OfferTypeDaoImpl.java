package kr.co.dinner41.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kr.co.dinner41.exception.menu.OfferTypeException;
import kr.co.dinner41.exception.menu.OfferTypeInsertFailedException;
import kr.co.dinner41.vo.OfferTypeVO;

public class OfferTypeDaoImpl implements OfferTypeDao{

	@Autowired
	private JdbcTemplate jTemp;
	
	@Override
	public void insert(OfferTypeVO offerType) throws OfferTypeException {
		
		String sql = "INSERT INTO offer_types VALUES (?,?)";
		
		int result =0;
		
		try {
			result = jTemp.update(sql, offerType.getId(),offerType.getName());
		}
		catch(DataAccessException e) {
			e.printStackTrace();
			throw new OfferTypeInsertFailedException();
		}
		if (result == 0) {
			throw new OfferTypeInsertFailedException();
		}
		
	}

	@Override
	public void delete(String id)  {
		return;
		
	}

	@Override
	public void update(String id, String name) {
		
	return;
		
	}

	@Override
	public List<OfferTypeVO> selectAll() throws OfferTypeException{
		
		String sql = "SELECT * FROM offer_types";
		
		List<OfferTypeVO> offerTypes=jTemp.query(sql,new RowMapper<OfferTypeVO>() {

			@Override
			public OfferTypeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				String id=rs.getString("offer_type_id");
				String name=rs.getString("offer_type_name");
				OfferTypeVO offerType = new OfferTypeVO(id,name);
				return offerType;
			}
			
		});
		return (offerTypes.size()>0?offerTypes:null);
	}

}
