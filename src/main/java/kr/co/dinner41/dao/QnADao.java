package kr.co.dinner41.dao;

import kr.co.dinner41.exception.QnAException;
import kr.co.dinner41.vo.QnAVO;

import java.util.List;

public interface QnADao {
    void insert(QnAVO qna) throws QnAException;
    void update(QnAVO qna) throws QnAException;
    void delete(String email) throws QnAException;
    List<QnAVO> selectAll(int page, int pageSize) throws QnAException;
    List<QnAVO> selectAll(int page, int pageSize, String qna_type) throws QnAException;
    QnAVO selectById(int qna_id) throws QnAException;
    int getTotalRecord() throws QnAException;
    int getTotalRecord(String qna_type) throws QnAException;
}
