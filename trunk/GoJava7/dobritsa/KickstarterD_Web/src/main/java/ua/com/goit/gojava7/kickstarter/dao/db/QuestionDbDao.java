package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.dao.DbDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@Component
public class QuestionDbDao extends DbDao<Question> implements QuestionDao {

	private static final String TABLE = "question";
	private static final String FIELDS = "time, question, answer, project_id";
	private static final String INSERTION = "?, ?, ?, ?";

	public QuestionDbDao() {	
		super.TABLE = TABLE;
		super.FIELDS = FIELDS;
	}
	
	public QuestionDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);
	}

	@Override
	public void add(Question element) {
		String query = "INSERT INTO " + TABLE + " (" + FIELDS + ") VALUES (" + INSERTION + ")";
		try (PreparedStatement ps = basicDataSource.getConnection().prepareStatement(query)) {
			writeElement(element, ps);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error! INSERT INTO " + TABLE + " (" + FIELDS + ") VALUES (" + element.getTime() + ", "
					+ element.getQuestion() + "," + element.getAnswer() + ", " + element.getProjectId() + ")");

			e.printStackTrace();
		}
	}

	@Override
	protected Question readElement(ResultSet resultSet) throws SQLException {
		Question question = new Question();
		question.setTime(resultSet.getString("time"));
		question.setQuestion(resultSet.getString("question"));
		question.setAnswer(resultSet.getString("answer"));
		return question;
	}

	protected void writeElement(Question question, PreparedStatement statement) throws SQLException {
		statement.setString(1, question.getTime());
		statement.setString(2, question.getQuestion());
		statement.setString(3, question.getAnswer());
		statement.setInt(4, question.getProjectId());
	}

	@Override
	public List<Question> getByProject(int projectId) {
		String query = "SELECT " + FIELDS + " FROM " + TABLE + " WHERE project_id = " + projectId;
		List<Question> data = new ArrayList<>();
		try (PreparedStatement ps = basicDataSource.getConnection().prepareStatement(query);
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
