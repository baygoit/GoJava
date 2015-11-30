package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.DbDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionDbDao extends DbDao<Question> implements QuestionStorage {

	private static String TABLE = "question";
	private static String FIELDS = "time, question, answer, project_id";

	public QuestionDbDao(Connection connection) {
		super(connection, FIELDS, TABLE);

	}

	@Override
	public void add(Question element) {
		String query = "INSERT INTO question (time, question, answer, project_id) VALUES (" + FIELDS + ")";
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			writeElementToRecord(element, ps);
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Question> getByProject(String projectName) {
		
		System.out.println(projectName);
		System.out.println(prepareStringForDb(projectName));
		//String query = "select time, question, answer from question where project_id = 44')";
		String query = "select time, question, answer from question where project_id = (select id from project where name = '"
				+ prepareStringForDb(projectName) + "')";
		List<Question> questions = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				Question question;
				question = new Question();
				question.setTime(resultSet.getString("time"));
				question.setQuestion(resultSet.getString("question"));
				question.setAnswer(resultSet.getString("answer"));
				questions.add(question);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questions;
	}

	@Override
	protected Question readElement(ResultSet resultSet) throws SQLException {
		Question question;
		question = new Question();
		question.setTime(resultSet.getString("time"));
		question.setQuestion(resultSet.getString("question"));
		question.setAnswer(resultSet.getString("answer"));
		return question;
	}

	private void writeElementToRecord(Question element, PreparedStatement statement) throws SQLException {
		statement.setString(size() + 1, element.getTime());
		statement.setString(size() + 1, element.getQuestion());
		statement.setString(size() + 1, element.getAnswer());
		statement.setString(size() + 1, element.getProjectName());
	}

}
