package com.anmertrix.dao.sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.AnswerDao;
import com.anmertrix.domain.Answer;

@Repository
public class AnswerDaoSql implements AnswerDao {
	
	private static final String SELECT_ANSWERS = "SELECT question.id AS question_id, answer.id, answer FROM question JOIN answer ON answer.question_id = question.id WHERE project_id = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Answer> getAnswersByProjectId(int projectId) {
		return jdbcTemplate.query(SELECT_ANSWERS, new Object[] { projectId }, new BeanPropertyRowMapper<Answer>(Answer.class));
	}
	
}
