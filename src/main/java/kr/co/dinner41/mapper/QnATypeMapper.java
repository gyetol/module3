package kr.co.dinner41.mapper;

import kr.co.dinner41.vo.QnATypeVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QnATypeMapper implements RowMapper<QnATypeVO> {
    @Override
    public QnATypeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//        String email = resultSet.getString("email");
//        String pass = resultSet.getString("pass");
//        String nick = resultSet.getString("nick");
//        Timestamp registerAt = resultSet.getTimestamp("registerAt");
//        Timestamp removeAt = resultSet.getTimestamp("removeAt");
//
//        return new Member(email, pass, nick, registerAt, removeAt);
        return null;
    }
}
