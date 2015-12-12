package com.kickstarter.dao.interfaces;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


import com.kickstarter.model.Question;

public class DbQuestionDaoImpl extends DBCon implements QuestionDaoInterface {

	public List<Question> getProjectQuestions(String projectTitle) {
		ResultSet rs = null;
		List<Question> list = new ArrayList<>();

		try (PreparedStatement pStatement = getConnection().prepareStatement("select * from questions where projectTitle = ?")) {
			pStatement.setString(1, projectTitle);
			rs = pStatement.executeQuery();

			while (rs.next()) {
				Question question = new Question();
				question.setProjectTitle(rs.getString("projectTitle"));
				question.setQuestion(rs.getString("question"));
				list.add(question);
			}
		} catch (SQLException e) {
			System.out.println("Question MySql connection problem");
		}
		return list;
	}

	public void add(String newQuestion, String projectTitle) {

		try (PreparedStatement pStatement = getConnection().prepareStatement("INSERT INTO questions (projectTitle, question) VALUES (?, ?)")) {
			pStatement.setString(1, projectTitle);
			pStatement.setString(2, newQuestion);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Question add MySql connection problem");
		}
	}
}
