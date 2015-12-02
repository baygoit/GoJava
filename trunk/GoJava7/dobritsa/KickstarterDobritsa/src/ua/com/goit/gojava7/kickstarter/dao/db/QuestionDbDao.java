package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import ua.com.goit.gojava7.kickstarter.dao.DbDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionDbDao extends DbDao<Question> implements QuestionDao {

	private static final String TABLE = "question";
	private static final String FIELDS = "time, question, answer, project_id";
	private static final String INSERTION = "?, ?, ?, ?";

	public QuestionDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);
	}
	
	@Override
	public void add(Question element) {
		String query = "INSERT INTO " + TABLE + " (" + FIELDS + ") VALUES (" + INSERTION + ")";
		try (Connection connection = basicDataSource.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
			writeElement(element, ps);
			ps.executeUpdate();			
		} catch (SQLException e) {
			System.err.println("Error! INSERT INTO " + TABLE + " (" + FIELDS + ") VALUES (" + element.getTime() + ", "
					+ element.getQuestion() + "," + element.getAnswer() + ", " + element.getProjectId() + ")");

			e.printStackTrace();
		}
	}

	@Override
	public List<Question> getByProject(String projectName) {
		String query = "SELECT time, question, answer FROM " + TABLE
				+ " WHERE project_id = (SELECT id FROM project WHERE name = '" + prepareStringForDb(projectName) + "')";
		List<Question> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection(); PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
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
		statement.setInt(4, question.getProjectId());
	}

	private int findProjectId(String projectName) {
		int id;
		String query = "SELECT id FROM " + TABLE + " WHERE name = '" + prepareStringForDb(projectName) + "'";
		try (Connection connection = basicDataSource.getConnection(); PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Question> getByProject(int projectId) {
		String query = "SELECT " + FIELDS + " FROM " + TABLE + " WHERE project_id = " + projectId;
		List<Question> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readElement(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

}
