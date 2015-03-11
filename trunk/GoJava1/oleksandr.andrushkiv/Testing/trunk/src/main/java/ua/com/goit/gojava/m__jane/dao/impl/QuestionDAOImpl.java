package ua.com.goit.gojava.m__jane.dao.impl;

import static ua.com.goit.gojava.m__jane.utils.ClassNameUtil.getCurrentClassName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.goit.gojava.m__jane.dao.QuestionDAO;
import ua.com.goit.gojava.m__jane.exceptions.TestingRuntimeException;
import ua.com.goit.gojava.m__jane.model.question.Question;
import ua.com.goit.gojava.m__jane.model.question.SimpleQuestion;
import ua.com.goit.gojava.m__jane.utils.DBConnectionSystem;

public class QuestionDAOImpl implements QuestionDAO {

	private DBConnectionSystem dbConnectionSystem;
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

	public QuestionDAOImpl() {
		dbConnectionSystem = DBConnectionSystem.getInstance();
		log.info("got dbConnectionSystem!");
	}

	@Override
	public void saveSimpleQuestion(SimpleQuestion question) {

		try (Connection connection = dbConnectionSystem.getConnection();) {

			String sql = "Insert Into simple_question(content,standart_answer) " + "Values(?,?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, question.getContent());
			st.setString(2, question.getStandartAnswer());
			st.executeUpdate();

		} catch (SQLException e) {
			// e.printStackTrace();
			// TODO write to log
			log.error("Can't save question to DB!", e);
			throw new TestingRuntimeException("Can't save question to DB!");
		}

	}

	@Override
	public List<Question> getQuestionList() {
		List<Question> list = new ArrayList<>();
		try (Connection connection = dbConnectionSystem.getConnection();) {

			String sql = "Select id,content,standart_answer from simple_question";

			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				SimpleQuestion simpleQuestion = new SimpleQuestion();
				simpleQuestion.setId(rs.getInt("id"));
				simpleQuestion.setContent(rs.getString("content"));
				simpleQuestion.setStandartAnswer(rs.getString("standart_answer"));
				list.add(simpleQuestion);
			}

		} catch (SQLException e) {
			// e.printStackTrace();
			// TODO write to log
			log.error("Can't read question from DB!", e);
			throw new TestingRuntimeException("Can't read question from DB!");
		}

		return list;
	}

	@Override
	public void deleteQuestion(Integer id) {

		try (Connection connection = dbConnectionSystem.getConnection();) {

			String sql = "Delete from simple_question where id=?";

			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e) {
			// e.printStackTrace();
			// TODO write to log
			log.error("Can't delete question from DB!", e);
			throw new TestingRuntimeException("Can't delete question from DB!");

		}
	}

	@Override
	public SimpleQuestion getSimpleQuestion(Integer id) {

		try (Connection connection = dbConnectionSystem.getConnection();) {

			String sql = "Select id,content,standart_answer from simple_question where id=?";

			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				SimpleQuestion simpleQuestion = new SimpleQuestion();
				simpleQuestion.setId(rs.getInt("id"));
				simpleQuestion.setContent(rs.getString("content"));
				simpleQuestion.setStandartAnswer(rs.getString("standart_answer"));
				return simpleQuestion;
			}

		} catch (SQLException e) {
			// e.printStackTrace();
			// TODO write to log
			log.error("Can't get question from DB!", e);
			throw new TestingRuntimeException("Can't get question from DB!");

		}
		return null;
	}

	@Override
	public void updateSimpleQuestion(SimpleQuestion question) {

		try (Connection connection = dbConnectionSystem.getConnection();) {

			String sql = "Update simple_question Set content=?,standart_answer=? where id=?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, question.getContent());
			st.setString(2, question.getStandartAnswer());
			st.setInt(3, question.getId());
			st.executeUpdate();

		} catch (SQLException e) {
			// e.printStackTrace();
			// TODO write to log
			log.error("Can't update question to DB!", e);
			throw new TestingRuntimeException("Can't update question to DB!");

		}

	}

}
