package kr.co.dinner41.service.review;

import kr.co.dinner41.command.ReviewInsertCommand;
import kr.co.dinner41.dao.ReviewDaoImpl;
import kr.co.dinner41.dao.StoreDaoImpl;
import kr.co.dinner41.dao.UserDaoImpl;
import kr.co.dinner41.exception.ReviewInsertException;
import kr.co.dinner41.vo.ReviewVO;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("reviewInsertService")
public class ReviewInsertServiceImpl implements ReviewInsertService {
    @Autowired
    private ReviewDaoImpl reviewDao;

    @Autowired
    private StoreDaoImpl storeDao;

    @Override
    public void execute(ReviewInsertCommand command, UserVO user) {
        int storeId = Integer.parseInt(command.getStoreId());
        StoreVO store = storeDao.selectById(storeId);

        ReviewVO review = new ReviewVO();
        review.setStore(store);
        review.setContent(command.getContent());

        int score = Integer.parseInt(command.getScore());
        review.setScore(score);

        int orderId = Integer.parseInt(command.getOrderId());
        review.setOrder_id(orderId);

        try {
            reviewDao.insert(review);
        } catch (ReviewInsertException e) {
            e.printStackTrace();
        }
    }
}
