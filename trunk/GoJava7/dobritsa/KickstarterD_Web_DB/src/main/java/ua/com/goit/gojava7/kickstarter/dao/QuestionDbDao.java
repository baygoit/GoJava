package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.DbDao;
import ua.com.goit.gojava7.kickstarter.models.Question;

@Component
public class QuestionDbDao extends DbDao<Question>{
	
	private static final Logger log = LoggerFactory.getLogger(QuestionDbDao.class);	 

	private static final String TABLE = "question";
	private static final String FIELDS = "time, question, answer, project_id";
	private static final String INSERTION = "?, ?, ?, ?";

	public QuestionDbDao() {	
		log.info("Constructor QuestionDbDao()...");		
		super.TABLE = TABLE;
		super.FIELDS = FIELDS;
	}
	
	public QuestionDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);		
	}

	public void add(Question element) {	
		log.info("add({})...", element);		
		String query = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
		log.debug("add({}) built query: {}", element, query);
		
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			writeElement(element, ps);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Question readElement(ResultSet resultSet) throws SQLException {
		log.info("readElement()...");	
		Question question = new Question();question.setTime(resultSet.getString("time"));
		question.setQuestion(resultSet.getString("question"));
		question.setAnswer(resultSet.getString("answer"));
		log.debug("readElement() returned question: {}", question);
		return question;
	}

	protected void writeElement(Question question, PreparedStatement statement) throws SQLException {
		log.info("writeElement({})...", question);
		statement.setString(1, question.getTime());
		statement.setString(2, question.getQuestion());
		statement.setString(3, question.getAnswer());
		statement.setInt(4, question.getProjectId());
	}

	public List<Question> getByProject(int projectId) {
		log.info("getByProject({})...", projectId);		
		String query = "SELECT " + FIELDS + " FROM " + TABLE + " WHERE project_id = " + projectId;
		log.debug("getByProject({}) built query: {}", projectId, query);
		
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
		log.debug("getByProject({}) returned questions: {}", projectId, data);
		return data;
	}	
}
