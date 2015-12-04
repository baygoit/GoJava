package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.DatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionDatabaseDao extends DatabaseDao<Question> implements QuestionStorage{

	private static String		TABLE		= "question";
	private static String		FIELDS		= "time, question, answer, project_id";
	private static final String	INSERTION	= "?, ?, ?, ?";

	public QuestionDatabaseDao(Connection connection) {
		super(connection, FIELDS, TABLE);
	}

	@Override
	public void add(Question element) {
		String query = "INSERT INTO " + TABLE + " (" + FIELDS + ") VALUES (" + INSERTION + ")";
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			writeElement(element, ps);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.err.println("Error! INSERT INTO " + TABLE + " (" + FIELDS + ") VALUES (" + element.getTime() + ", "
					+ element.getTime() + "," + element.getTime() + ", " + element.getTime() + ")");

			e.printStackTrace();
		}
	}

	@Override
	public List<Question> getByProject(String projectName) {
		String query = "SELECT time, question, answer FROM " + TABLE
				+ " WHERE project_id = (SELECT id FROM project WHERE name = '" + prepareStringForDb(projectName) + "')";
		List<Question> data = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readElement(resultSet));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return data;
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

	private void writeElement(Question question, PreparedStatement statement) throws SQLException {
		statement.setString(1, question.getTime());
		statement.setString(2, question.getQuestion());
		statement.setString(3, question.getAnswer());
	}

	private int findProjectId(String projectName) {
		int id;
		String query = "select id from project where name = '" + prepareStringForDb(projectName) + "'";
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
