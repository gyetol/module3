package kr.co.dinner41.dao;

import java.util.List;

import kr.co.dinner41.exception.menu.OfferTypeException;
import kr.co.dinner41.vo.OfferTypeVO;

public interface OfferTypeDao {
	
	public void insert(OfferTypeVO offerType) throws OfferTypeException ;
	public void delete(String id);
	public void update(String id, String name);
	public List<OfferTypeVO> selectAll() throws OfferTypeException;

}
