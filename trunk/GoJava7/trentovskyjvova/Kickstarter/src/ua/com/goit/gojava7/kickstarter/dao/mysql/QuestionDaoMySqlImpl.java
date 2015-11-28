package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class QuestionDaoMySqlImpl implements QuestionDao {
	private Connection connection;

	public QuestionDaoMySqlImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Question> getQuestions(int projectId) {
		List<Question> questions = new ArrayList<>();

		try (PreparedStatement ps = connection
				.prepareStatement("SELECT id, questionText FROM question WHERE projectId ="
						+ projectId);
				ResultSet rs = ps.executeQuery()) {

			Question question;
			while (rs.next()) {
				int id = rs.getInt("id");
				String questionText = rs.getString("questionText");

				question = new Question();
				question.setId(id);
				question.setProjectId(projectId);
				question.setQuestionText(questionText);

				questions.add(question);
			}
		} catch (SQLException e) {

			throw new IODatabaseException("Problem with database", e);
		}
		return questions;
	}

	@Override
	public void addQuestion(Question question) {
		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO question (projectId, questionText) VALUES ('"
						+ question.getProjectId()
						+ "', '"
						+ question.getQuestionText() + "');");) {
			ps.executeUpdate();

		} catch (SQLException e) {

			throw new IODatabaseException("Problem with database", e);
		}

	}

}
