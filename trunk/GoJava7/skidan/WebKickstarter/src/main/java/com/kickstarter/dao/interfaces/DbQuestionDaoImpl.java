package com.kickstarter.dao.interfaces;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kickstarter.model.Question;
@Repository
public class DbQuestionDaoImpl  implements QuestionDaoInterface {
	
	@Autowired
	private BasicDataSource dbCon;
	
	public BasicDataSource getDbCon() {
		return dbCon;
	}


	public void setDbCon(BasicDataSource dbCon) {
		this.dbCon = dbCon;
	}

	

	public List<Question> getProjectQuestions(String projectTitle) {
		ResultSet rs = null;
		List<Question> list = new ArrayList<>();

		try (PreparedStatement pStatement = dbCon.getConnection().prepareStatement("select projectTitle,question from questions where projectTitle = ?")) {
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

		try (PreparedStatement pStatement = dbCon.getConnection().prepareStatement("INSERT INTO questions (projectTitle, question) VALUES (?, ?)")) {
			pStatement.setString(1, projectTitle);
			pStatement.setString(2, newQuestion);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Question add MySql connection problem");
		}
	}
}
