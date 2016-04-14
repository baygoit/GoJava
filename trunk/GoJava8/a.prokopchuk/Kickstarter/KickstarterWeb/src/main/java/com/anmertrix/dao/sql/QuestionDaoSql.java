package com.anmertrix.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.DaoException;
import com.anmertrix.dao.QuestionDao;
import com.anmertrix.domain.Question;

@Repository
public class QuestionDaoSql implements QuestionDao {
	
	private static final String SELECT_QUESTIONS = "SELECT id, question FROM question WHERE project_id=?";
	private static final String INSERT_QUESTION = "INSERT INTO question (project_id, question) VALUES (?, ?)";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Question> getQuestionsByProjectId(int projectId) {
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_QUESTIONS)) {
			statement.setInt(1, projectId);
			ResultSet rs = statement.executeQuery();
			
			List<Question> questions = new ArrayList<Question>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String questionText = rs.getString("question");
				
				Question question = new Question();
				question.setId(id);
				question.setQuestion(questionText);
				questions.add(question);
			}
			return questions;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public void insertQuestion(Question question) {		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_QUESTION)) {
			statement.setInt(1, question.getProjectId());
			statement.setString(2, question.getQuestion());
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
