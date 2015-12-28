package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@Repository
public class QuestionDaoSqlImpl implements QuestionDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Question> getQuestions(int projectId) {
		
		String sql = "SELECT id, projectId, questionText FROM question WHERE projectId = ?";
		return jdbcTemplate.query(sql, new Integer[] { projectId },
				new BeanPropertyRowMapper<Question>(Question.class));
	}

	@Override
	public void addQuestion(Question question) {

		String sql = "INSERT INTO question (projectId, questionText) VALUES (?, ?)";
		jdbcTemplate.update(sql, question.getProjectId(), question.getQuestionText());
	}

}
