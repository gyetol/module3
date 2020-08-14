package kr.co.dinner41.mapper;

import kr.co.dinner41.dao.QnATypeDaoImpl;
import kr.co.dinner41.dao.QnaTypeDao;
import kr.co.dinner41.dao.UserDaoImpl;
import kr.co.dinner41.exception.QnATypeException;
import kr.co.dinner41.exception.QnATypeSelectException;
import kr.co.dinner41.vo.QnATypeVO;
import kr.co.dinner41.vo.QnAVO;
import kr.co.dinner41.vo.UserVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class QnAMapper implements RowMapper<QnAVO> {
    @Override
    public QnAVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("qna_id");

        String qna_type_id = rs.getString("qna_type_id");
        QnATypeVO type = null;
        try {
            type = new QnATypeDaoImpl().selectById(qna_type_id);
        } catch (QnATypeSelectException e) {
            e.printStackTrace();
        }

        int user_id = rs.getInt("user_id");
        UserVO user = new UserDaoImpl().selectById(user_id);

        int manager_id = rs.getInt("manager_id");
        UserVO manager = new UserDaoImpl().selectById(manager_id);

        String title = rs.getString("qna_title");
        String content = rs.getString("qna_content");
        Timestamp questionDate = rs.getTimestamp("qna_question_date");
        String answerContent = rs.getString("qna_answer_content");
        Timestamp answerDate = rs.getTimestamp("qna_answer_date");
        return new QnAVO(id, type, user, manager, title, content, questionDate, answerContent, answerDate);
    }
}
