package ua.nenya.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.QuestionDao;
import ua.nenya.domain.Question;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	private static final String GET_QUESTIONS_BY_PROJECT_NAME = "SELECT questions.id AS id, question FROM projects INNER JOIN questions ON "
			+ "projects.id=questions.project_id WHERE project_name =? ORDER BY id";
	private static final String WRITE_QUESTION_IN_PROJECT = "INSERT INTO Questions (project_id, question) VALUES (?,?)";
	private static final String IS_QUESTION_EXISTS = "SELECT COUNT(help.question) AS count FROM (SELECT * FROM Questions "
			+ "WHERE project_id =? ) AS help WHERE help.question = ?";
	private static final String GET_PROJECT_ID_BY_PROJECT_NAME = "SELECT id FROM projects WHERE project_name = ?";

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Question> getQuestions(String projectName) {
		List<Question> questions = new ArrayList<>();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_QUESTIONS_BY_PROJECT_NAME)) {
			statement.setString(1, projectName);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Question question = new Question();
				String name = set.getString("question");
				question.setName(name);
				questions.add(question);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return questions;
	}

	@Override
	public void writeQuestionInProject(String projectName, String question) {
		int id = getProjectId(projectName);
		if (question == null || question.isEmpty()) {
			return;
		}
		if (isQuestionExists(projectName, question)) {
			return;
		}
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(WRITE_QUESTION_IN_PROJECT)) {
			statement.setInt(1, id);
			statement.setString(2, question);
			statement.executeQuery();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	private boolean isQuestionExists(String projectName, String question) {
		int count = 0;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(IS_QUESTION_EXISTS)) {
			statement.setInt(1, getProjectId(projectName));
			statement.setString(2, question);
			ResultSet set = statement.executeQuery();
			set.next();
			count = set.getInt("count");
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return count != 0;
	}

	private int getProjectId(String projectName) {
		int id = 0;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_PROJECT_ID_BY_PROJECT_NAME)) {
			statement.setString(1, projectName);
			ResultSet set = statement.executeQuery();
			set.next();
			id = set.getInt("id");
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return id;
	}
}
