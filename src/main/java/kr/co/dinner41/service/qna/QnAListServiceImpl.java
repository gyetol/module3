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
        if (user.getType().getId().equals("AD")){
            if (qnaType == null){
                try {
                    list = qnADao.selectAll(page, PAGE_SIZE);
                } catch (QnAException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    list = qnADao.selectAll(page, PAGE_SIZE, qnaType);
                } catch (QnAException e) {
                    e.printStackTrace();
                }
            }
        }else{
            if (qnaType == null){
                try {
                    list = qnADao.selectAllForUser(page, PAGE_SIZE, user);
                } catch (QnAException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    list = qnADao.selectAllForUser(page, PAGE_SIZE, user,qnaType);
                } catch (QnAException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
}
