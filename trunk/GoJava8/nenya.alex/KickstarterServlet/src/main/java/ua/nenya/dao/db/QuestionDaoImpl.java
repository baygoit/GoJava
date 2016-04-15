package ua.nenya.dao.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.QuestionDao;
import ua.nenya.domain.Question;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	private static final String GET_QUESTIONS_BY_PROJECT_NAME = "SELECT questions.id AS id, questions.name FROM projects INNER JOIN questions ON "
			+ "projects.id=questions.project_id WHERE projects.name =? ORDER BY id";
	private static final String WRITE_QUESTION_IN_PROJECT = "INSERT INTO Questions (project_id, name) VALUES (?,?)";
	private static final String NUMBER_OF_SOME_QUESTION_IN_PROJECT = "SELECT COUNT(help.name) AS count FROM (SELECT * FROM Questions "
			+ "WHERE project_id =? ) AS help WHERE help.name = ?";
	private static final String GET_PROJECT_ID_BY_PROJECT_NAME = "SELECT id FROM projects WHERE name = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Question> getQuestions(String projectName) {
		return jdbcTemplate.query(GET_QUESTIONS_BY_PROJECT_NAME, new Object[] { projectName },
				new BeanPropertyRowMapper<Question>(Question.class));
	}

	@Override
	public void writeQuestionInProject(String projectName, String question) {
		int id = getProjectId(projectName);
		jdbcTemplate.update(WRITE_QUESTION_IN_PROJECT, new Object[] { id, question });
	}


	public boolean isQuestionValid(String projectName, String question) {
		int count  = jdbcTemplate.queryForObject(NUMBER_OF_SOME_QUESTION_IN_PROJECT,
				new Object[] { getProjectId(projectName), question }, Integer.class);
		
		return count == 0 && !question.isEmpty();
	}

	private int getProjectId(String projectName) {
		return jdbcTemplate.queryForObject(GET_PROJECT_ID_BY_PROJECT_NAME, new Object[] { projectName }, Integer.class);
	}
}
