package kr.co.dinner41.mapper;

import kr.co.dinner41.dao.StoreDaoImpl;
import kr.co.dinner41.dao.UserDaoImpl;
import kr.co.dinner41.vo.ReviewVO;
import kr.co.dinner41.vo.StoreVO;
import kr.co.dinner41.vo.UserVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ReviewMapper implements RowMapper<ReviewVO> {
    @Override
    public ReviewVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("review_id");

        int store_id = rs.getInt("store_id");
        StoreVO store= new StoreDaoImpl().selectById(store_id);

        int user_id = rs.getInt("user_id");
        UserVO user = new UserDaoImpl().selectById(user_id);

        String content = rs.getString("review_content");
        int score = rs.getInt("review_score");
        Timestamp date = rs.getTimestamp("review_date");

        return new ReviewVO(id, store, user, score, content, date);
    }
}
