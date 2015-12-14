package ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuestionStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.model.Question;

public class QuestionDbStorage extends AbstractQuestionStorage {

	private final String INSERT_QUESTION = "INSERT INTO questions (id_project, question) VALUES (?, ?)";
	private final String SELECT_ALL_QUESTIONS = "SELECT id, id_project, question FROM questions";

	private JdbcDispatcher dispatcher;

	public QuestionDbStorage(JdbcDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	@Override
	public List<Question> getAll() {
		List<Question> questions = new ArrayList<>();
		try (Connection connection = dispatcher.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUESTIONS);) {
			while (resultSet.next()) {
				Question question = new Question();
				question.setIdQuestion(resultSet.getInt("id"));
				question.setIdParentProject(resultSet.getInt("id_project"));
				question.setQuestion(resultSet.getString("question"));
				questions.add(question);
			}
		} catch (SQLException e) {
			System.err.println("DB reading problem");
		}
		return questions;
	}

	@Override
	public void add(Question question) {
		try (Connection connection = dispatcher.getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_QUESTION);) {
			statement.setInt(1, question.getIdParentProject());
			statement.setString(2, question.getQuestion());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			System.err.println("DB writing problem");
		}
	}

}
