package com.anmertrix.dao.sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.QuestionDao;
import com.anmertrix.domain.Question;

@Repository
public class QuestionDaoSql implements QuestionDao {
	
	private static final String SELECT_QUESTIONS = "SELECT id, question FROM question WHERE project_id=?";
	private static final String INSERT_QUESTION = "INSERT INTO question (project_id, question) VALUES (?, ?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Question> getQuestionsByProjectId(int projectId) {
		return jdbcTemplate.query(SELECT_QUESTIONS, new Object[] { projectId }, new BeanPropertyRowMapper<Question>(Question.class));
	}
	
	@Override
	public void insertQuestion(Question question) {
		jdbcTemplate.update(INSERT_QUESTION, new Object[] { question.getProjectId(), question.getQuestion() });
	}

}
