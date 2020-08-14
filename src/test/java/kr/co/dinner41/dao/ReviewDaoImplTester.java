package kr.co.dinner41.dao;

import kr.co.dinner41.exception.ReviewInsertException;
import kr.co.dinner41.vo.ReviewVO;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class ReviewDaoImplTester {
    @Autowired
    private ApplicationContext ctx;

    @Test
    public void testInsert(){
        ReviewDaoImpl dao = ctx.getBean("reviewDao", ReviewDaoImpl.class);
        UserDaoImpl userDao = ctx.getBean("userDao", UserDaoImpl.class);
        UserVO user = userDao.selectById(4);
        StoreDaoImpl storeDao = ctx.getBean("storeDao", StoreDaoImpl.class);
        StoreVO store = storeDao.selectById(1);

        ReviewVO reviewVO = new ReviewVO(0, store, user, 4, "taste Good", null);

        try {
            dao.insert(reviewVO);
        } catch (ReviewInsertException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectById(){

    }

    @Test
    public void testSelectByStoreId(){

    }

    @Test
    public void testSelectedAll(){

    }
}
