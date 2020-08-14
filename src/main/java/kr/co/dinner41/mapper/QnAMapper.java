package kr.co.dinner41.mapper;

import kr.co.dinner41.vo.QnATypeVO;
import kr.co.dinner41.vo.QnAVO;
import kr.co.dinner41.vo.UserTypeVO;
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
        String qna_type_name = rs.getString("qna_type_name");
        QnATypeVO type = new QnATypeVO(qna_type_id, qna_type_name);

        int user_id = rs.getInt("u.user_id");
        String user_type_id = rs.getString("u.user_type_id");
        String user_type_name = rs.getString("u.user_type_name");
        UserTypeVO user_type = new UserTypeVO(user_type_id, user_type_name);
        String user_email = rs.getString("u.user_email");
        String user_password = rs.getString("u.user_password");
        String user_name = rs.getString("u.user_name");
        String user_address = rs.getString("u.user_address");
        String user_subAddress = rs.getString("u.user_sub_address");
        double user_latitude = rs.getDouble("u.user_latitude");
        double user_longitude = rs.getDouble("u.user_longitude");
        String user_phone = rs.getString("u.user_phone");
        Timestamp user_registerDate = rs.getTimestamp("u.user_register_date");
        Timestamp user_removeDate = rs.getTimestamp("u.user_remove_date");
        UserVO user = new UserVO(user_id, user_type, user_email, user_password, user_name, user_address, user_subAddress, user_latitude, user_longitude, user_phone, user_registerDate, user_removeDate);

        int manager_id = rs.getInt("manager_id");
        String manager_type_id = rs.getString("m.user_type_id");
        String manager_type_name = rs.getString("m.user_type_name");
        UserTypeVO manager_type = new UserTypeVO(manager_type_id, manager_type_name);
        String manager_email = rs.getString("m.user_email");
        String manager_password = rs.getString("m.user_password");
        String manager_name = rs.getString("m.user_name");
        String manager_address = rs.getString("m.user_address");
        String manager_subAddress = rs.getString("m.user_sub_address");
        double manager_latitude = rs.getDouble("m.user_latitude");
        double manager_longitude = rs.getDouble("m.user_longitude");
        String manager_phone = rs.getString("m.user_phone");
        Timestamp manager_registerDate = rs.getTimestamp("m.user_register_date");
        Timestamp manager_removeDate = rs.getTimestamp("m.user_remove_date");
        UserVO manager = new UserVO(manager_id, manager_type, manager_email, manager_password, manager_name, manager_address, manager_subAddress, manager_latitude, manager_longitude, manager_phone, manager_registerDate, manager_removeDate);

        String title = rs.getString("qna_title");
        String content = rs.getString("qna_content");
        Timestamp questionDate = rs.getTimestamp("qna_question_date");
        String answerContent = rs.getString("qna_answer_content");
        Timestamp answerDate = rs.getTimestamp("qna_answer_date");

        return new QnAVO(id, type, user, manager, title, content, questionDate, answerContent, answerDate);
    }
}
