package kr.co.dinner41.dao;

import kr.co.dinner41.exception.QnAException;
import kr.co.dinner41.mapper.QnAMapper;
import kr.co.dinner41.vo.QnAVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("qnADao")
public class QnADaoImpl implements QnADao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public void insert(QnAVO qna) throws QnAException {
        String sql = "INSERT INTO qnas VALUES(DEFAULT, ?, ?, DEFAULT, ?, ?, CURRENT_TIMESTAMP, NULL, NULL);";
        template.update(sql, qna.getType().getId(), qna.getUser().getId(),
                qna.getTitle(), qna.getContent());
    }

    @Override
    public void update(QnAVO qna) throws QnAException {
        String sql = "UPDATE qnas SET manager_id = ?, qna_answer_content = ?, qna_answer_date = CURRENT_TIMESTAMP WHERE qna_id = ?";
        template.update(sql, qna.getManager().getId(), qna.getAnswerContent(), qna.getId());
    }

    @Override
    public void delete(String email) throws QnAException {
        return;
    }

    @Override
    public List<QnAVO> selectAll(int page, int pageSize) throws QnAException {
        List<QnAVO> list;
        int startPoint = (page-1)*pageSize;

        String sql = "SELECT * FROM qna_view AS q " +
                "LEFT JOIN user_view u on q.user_id = u.user_id " +
                "LEFT JOIN user_view m on q.manager_id = m.user_id " +
                "ORDER BY qna_question_date DESC LIMIT ?, ?;";
        list = template.query(sql, new QnAMapper(), startPoint, pageSize);
        return list;
    }

    @Override
    public List<QnAVO> selectAll(int page, int pageSize, String qna_type) throws QnAException {
        List<QnAVO> list;
        int startPoint = (page-1)*pageSize;
        String sql = "SELECT * FROM qna_view AS q " +
                "LEFT JOIN user_view u on q.user_id = u.user_id " +
                "LEFT JOIN user_view m on q.manager_id = m.user_id " +
                "WHERE qna_type_id LIKE ? ORDER BY qna_question_date DESC LIMIT ?, ?;";
        list = template.query(sql, new QnAMapper(), qna_type, startPoint, pageSize);
        return list;
    }

    @Override
    public QnAVO selectById(int qna_id) throws QnAException {
        List<QnAVO> list;
        String sql = "SELECT * FROM qna_view AS q " +
                "LEFT JOIN user_view u on q.user_id = u.user_id " +
                "LEFT JOIN user_view m on q.manager_id = m.user_id " +
                "WHERE qna_id = ?;";
        list = template.query(sql, new QnAMapper(), qna_id);
        return (list.size() == 0? null:list.get(0));
    }

    @Override
    public int getTotalRecord() throws QnAException {
        String sql="select count(*) as num from qna_types;";
        List<Integer> list = template.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("num");
            }
        });

        return (list.size() == 0? 0:list.get(0));
    }

    @Override
    public int getTotalRecord(String qna_type) throws QnAException {
        List<Integer> list = template.query("select count(*) as num from qnas WHERE qna_type_id LIKE ?;", new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("num");
            }
        }, qna_type);

        return (list.size() == 0? 0:list.get(0));
    }
}
