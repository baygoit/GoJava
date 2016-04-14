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

import com.anmertrix.dao.AnswerDao;
import com.anmertrix.dao.DaoException;
import com.anmertrix.domain.Answer;

@Repository
public class AnswerDaoSql implements AnswerDao {
	
	private static final String SELECT_ANSWERS = "SELECT question.id AS question_id, answer.id, answer FROM question JOIN answer ON answer.question_id = question.id WHERE project_id = ?";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Answer> getAnswersByProjectId(int projectId) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_ANSWERS)) {
			statement.setInt(1, projectId);
			ResultSet rs = statement.executeQuery();
			
			List<Answer> answers = new ArrayList<Answer>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String answerText = rs.getString("answer");
				int questionId = rs.getInt("question_id");
				
				Answer answer = new Answer();
				answer.setId(id);
				answer.setAnswer(answerText);
				answer.setQuestionId(questionId);;
				answers.add(answer);
			}
			return answers;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
}
