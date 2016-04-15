package ua.dborisenko.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@Repository
public class QuestionDao {

    private final class QuestionRowMapper implements RowMapper<Question> {
        @Override
        public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
            Question question = new Question();
            question.setId(rs.getInt("id"));
            question.setRequest(rs.getString("request"));
            question.setReply(rs.getString("reply"));
            return question;
        }
    }

    private static final String QUERY_GET_QUESTIONS = "SELECT id, request, reply FROM questions WHERE project_id = ?";
    private static final String QUERY_ADD_QUESTION = "INSERT INTO questions (project_id, request) VALUES (?, ?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getAllForProject(Project project) {
        project.setQuestions(
                jdbcTemplate.query(QUERY_GET_QUESTIONS, new Object[] { project.getId() }, new QuestionRowMapper()));
    }

    public void addToProject(int projectId, Question question) {
        jdbcTemplate.update(QUERY_ADD_QUESTION, projectId, question.getRequest());
    }

}
