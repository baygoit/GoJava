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

    final class QuestionRowMapper implements RowMapper<Question> {
        @Override
        public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
            Question question = new Question();
            question.setId(rs.getInt("id"));
            question.setRequest(rs.getString("request"));
            question.setReply(rs.getString("reply"));
            return question;
        }
    }

    static final String GET_BY_PROJECT_ID_QUERY = "SELECT id, request, reply FROM questions WHERE project_id = ?";
    static final String ADD_QUERY = "INSERT INTO questions (project_id, request) VALUES (?, ?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private QuestionRowMapper mapper = new QuestionRowMapper();

    public void getAllForProject(Project project) {
        project.setQuestions(
                jdbcTemplate.query(GET_BY_PROJECT_ID_QUERY, new Object[] { project.getId() }, mapper));
    }

    public void add(int projectId, Question question) {
        jdbcTemplate.update(ADD_QUERY, projectId, question.getRequest());
    }

}
