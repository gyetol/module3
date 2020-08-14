package kr.co.dinner41.dao;

import kr.co.dinner41.exception.ReviewException;
import kr.co.dinner41.vo.ReviewVO;

import java.util.List;

public class ReviewDaoImpl implements ReviewDao{
    @Override
    public void insert(ReviewVO review) throws ReviewException {

    }

    @Override
    public void delete(int id) throws ReviewException {

    }

    @Override
    public ReviewVO selectedById(int id) throws ReviewException {
        return null;
    }

    @Override
    public ReviewVO selectedByStoreId(int storeId) throws ReviewException {
        return null;
    }

    @Override
    public List<ReviewVO> selectedAll() throws ReviewException {
        return null;
    }
}
