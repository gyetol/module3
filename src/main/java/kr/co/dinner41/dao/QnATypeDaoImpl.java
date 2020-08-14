package kr.co.dinner41.dao;

import kr.co.dinner41.exception.QnATypeException;
import kr.co.dinner41.mapper.QnATypeMapper;
import kr.co.dinner41.vo.QnATypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("qnATypeDaoImpl")
public class QnATypeDaoImpl implements QnaTypeDao{
    @Autowired
    private JdbcTemplate template;

    @Override
    public void insert(QnATypeVO qnAType) throws QnATypeException {
        return;
    }

    @Override
    public void delete(String id) throws QnATypeException {
        return;
    }

    @Override
    public void update(String id, String name) throws QnATypeException {
        return;
    }

    @Override
    public List<QnATypeVO> selectAll() throws QnATypeException {
        List<QnATypeVO> list = null;
        String sql = "";
        list = template.query(sql, new QnATypeMapper());
        return list;
    }
}
