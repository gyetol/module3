package kr.co.dinner41.dao;

import kr.co.dinner41.exception.QnAException;
import kr.co.dinner41.vo.QnAVO;

import java.util.List;

public class QnADaoImpl implements QnADao {
    @Override
    public void insert(QnAVO qna) throws QnAException {

    }

    @Override
    public void delete(String email) throws QnAException {

    }

    @Override
    public List<QnAVO> selectAll(int page, int pageSize, String condition, String word) throws QnAException {
        return null;
    }

    @Override
    public List<QnAVO> selectAll(int page, int pageSize, String condition, String word, String qna_type) throws QnAException {
        return null;
    }

    @Override
    public QnAVO selectById(int qna_id) throws QnAException {
        return null;
    }

    @Override
    public int getTotalRecord(String condition, String word, String qna_type) throws QnAException {
        return 0;
    }
}
