package com.kickstarter.dao.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kickstarter.model.Project;
import com.kickstarter.model.Question;

public class DbQuestionDaoImpl extends DbConnector implements QuestionDaoInterface {

	public List<Question> getProjectQuestions(Project p) {
		String projectTitle = p.getTitle();
		ResultSet rs = null;
		Statement statement = null;
		List<Question> list = new ArrayList<>();

		try (Connection conection = getConnection()) {
			statement = conection.createStatement();
			rs = statement.executeQuery("select * from questions where project_title = " + "'" + projectTitle + "'");

			while (rs.next()) {
				Question question = new Question();
				question.setProjectTitle(rs.getString("project_title"));
				question.setQuestion(rs.getString("question"));
				list.add(question);
			}

		} catch (SQLException e) {
			System.out.println("Question MySql connection problem");
		}
		return list;

	}

	public void add(String newQuestion, Project p) {

		String query = "INSERT INTO questions (project_title, question) VALUES " + "('" + p.getTitle() + "', '"
				+ newQuestion + "')";
		Statement statement = null;

		try (Connection conection = getConnection()) {
			statement = conection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println("Question add MySql connection problem");

		}

	}

}
