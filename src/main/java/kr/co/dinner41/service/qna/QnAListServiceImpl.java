package kr.co.dinner41.service.qna;

import kr.co.dinner41.dao.QnADaoImpl;
import kr.co.dinner41.exception.QnAException;
import kr.co.dinner41.vo.QnAVO;
import kr.co.dinner41.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("qnAListService")
public class QnAListServiceImpl implements QnAListService{
    @Autowired
    private QnADaoImpl qnADao;
    public static final int PAGE_SIZE = 10;

    @Override
    public List<QnAVO> execute(UserVO user, String qnaType, int page) {
        List<QnAVO> list = null;
        if (qnaType.equals("ALL")){
            try {
                list = qnADao.selectAll(page, PAGE_SIZE, user);
            } catch (QnAException e) {
                e.printStackTrace();
            }
        } else if (qnaType.equals("DON")){
            try {
                list = qnADao.selectAllDone(page, PAGE_SIZE, user);
            } catch (QnAException e) {
                e.printStackTrace();
            }
        } else{
            try {
                list = qnADao.selectAll(page, PAGE_SIZE,qnaType, user);
            } catch (QnAException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<QnAVO> execute(String qnaType, int page) {
        List<QnAVO> list = null;
        if (qnaType.equals("ALL")){
            try {
                list = qnADao.selectAll(page, PAGE_SIZE);
            } catch (QnAException e) {
                e.printStackTrace();
            }
        } else if (qnaType.equals("DON")){
            try {
                list = qnADao.selectAllDone(page, PAGE_SIZE);
            } catch (QnAException e) {
                e.printStackTrace();
            }
        } else{
            try {
                list = qnADao.selectAll(page, PAGE_SIZE, qnaType);
            } catch (QnAException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public int getTotalRecord(){
        try {
            return qnADao.getTotalRecord();
        } catch (QnAException e) {
            return 1;
        }
    }

    public List<Integer> getPages(){
        List<Integer> list = null;
        return list;
    }
}
