package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.models.Question;

@Repository
public class QuestionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(QuestionDao.class);

	public QuestionDao() {
		log.info("Constructor QuestionDao()...");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add(Question question) {
		log.info("<void> add({})...", question);
		String query = "insert into question (time, question, project_id) values (?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {question.getTime(), question.getQuestion(), question.getProjectId()});
	}

	public List<Question> getByProject(int projectId) {
		log.info("<Question> getByProject({})...", projectId);
		String query = "select time, question, answer, project_id from question where project_id = ?";
		return jdbcTemplate.query(query, new Object[] { projectId }, new QuestionMapper());
	}

	private final class QuestionMapper implements RowMapper<Question> {
		public Question mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			log.info("QuestionMapper()...");
			Question question = new Question();
			question.setTime(resultSet.getString("time"));
			question.setQuestion(resultSet.getString("question"));
			question.setAnswer(resultSet.getString("answer"));
			log.debug("QuestionMapper() returned question: {}", question);
			return question;
		}
	}
}
