package ua.com.goit.gojava.solo307.intersim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import ua.com.goit.gojava.solo307.intersim.domain.Answer;
import ua.com.goit.gojava.solo307.intersim.domain.Question;
import ua.com.goit.gojava.solo307.intersim.commons.ApplicationContextProvider;
import ua.com.goit.gojava.solo307.intersim.commons.StatisticsTraveler;

public class InterviewDao {

	ConnectorJdbc connector;

	public InterviewDao() {
		connector = (ConnectorJdbc) ApplicationContextProvider.getBean("connector");
	}

	public void addName(String name) throws InterviewSimulatorDaoException {
		LoggerDao.daoLogger.trace("adding name: " + name);
		Connection connection = null;
		try {
			connection = connector.openAccess();
		} catch (InterviewSimulatorDaoException e) {
			LoggerDao.daoLogger.error(e);
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"Creating statement was failed:-(");
		}
		String sql = "INSERT INTO interviews(applicant_name) VALUES ('" + name
				+ "')";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"Performing add name query was failed:-(");
		} finally {
			closeConnection(connection);
		}
		LoggerDao.daoLogger.trace("name: " + name + " written successfully");
	}

	public void addStartTime(long start) throws InterviewSimulatorDaoException {
		LoggerDao.daoLogger.trace("adding start time: " + start);
		Connection connection = null;
		try {
			connection = connector.openAccess();
		} catch (InterviewSimulatorDaoException e) {
			LoggerDao.daoLogger.error(e);
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"Creating statement was failed:-(");
		}
		String sql = "UPDATE interviews SET start_time=" + start
				+ "WHERE id=(SELECT MAX(id) FROM interviews)";
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"Performing add name query was failed:-(");
		} finally {
			closeConnection(connection);
		}
		LoggerDao.daoLogger.trace("inserting time was successfull");
	}

	public long getStartTime() throws InterviewSimulatorDaoException {
		LoggerDao.daoLogger.trace("reading start time");
		Connection connection = null;
		try {
			connection = connector.openAccess();
		} catch (InterviewSimulatorDaoException e) {
			LoggerDao.daoLogger.error(e);
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"Creating statement was failed:-(");
		}
		String sql = "SELECT start_time FROM interviews WHERE id=(SELECT MAX(id) FROM interviews)";
		ResultSet startTime = null;
		long start = 0;
		try {
			startTime = statement.executeQuery(sql);
			while (startTime.next()) {
				start = startTime.getLong("start_time");
			}
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"Performing add name query was failed:-(");
		} finally {
			closeConnection(connection);
		}
		LoggerDao.daoLogger.trace("start time was readen: " + start);
		return start;
	}

	public void addStatistics(StatisticsTraveler dto)
			throws InterviewSimulatorDaoException {
		LoggerDao.daoLogger.trace("adding dto");
		Set<Question> questions = dto.getQuestions();
		Connection connection = null;
		try {
			connection = connector.openAccess();
		} catch (InterviewSimulatorDaoException e) {
			LoggerDao.daoLogger.error(e);
		}
		PreparedStatement preparedStatement = null;
		try {
			addStatistics(connection, preparedStatement, dto);
			for (Question question : questions) {
				final String TABLE_NAME = "statistics";
				int statisticsId = getCurrentId(connection, TABLE_NAME);
				addQuestions(connection, preparedStatement, statisticsId,
						question.getText());
				for (Answer answer : question.getMarkedAnswers()) {
					final String TABLE_NAME2 = "statistics_questions";
					int questionsId = getCurrentId(connection, TABLE_NAME2);
					addAnswers(connection, preparedStatement, questionsId,
							answer.getText(), answer.isAnswerCorrect());
				}
			}
		} catch (InterviewSimulatorDaoException e) {
			LoggerDao.daoLogger.error(e);
		} finally {
			closeConnection(connection);
		}
		LoggerDao.daoLogger.trace("dto has inserted successfully");
	}

	private void addStatistics(Connection connection,
			PreparedStatement preparedStatement, StatisticsTraveler dto)
			throws InterviewSimulatorDaoException {
		LoggerDao.daoLogger.trace("adding to statistics table...");
		int correct = dto.getCorrect();
		int halfCorrect = dto.getHalfCorrect();
		int incorrect = dto.getIncorrect();
		String date = dto.getDate();
		String duration = dto.getDuration();
		int interviewId = 0;
		try {
			final String TABLE_NAME = "interviews";
			LoggerDao.daoLogger.trace("retrieving interviewId");
			interviewId = getCurrentId(connection, TABLE_NAME);
			LoggerDao.daoLogger.trace("id was retrieved = " + interviewId);
		} catch (InterviewSimulatorDaoException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"Something wrong whith interview id");
		}
		try {
			preparedStatement = connection
					.prepareStatement("INSERT INTO statistics (date, duration, incorrect,"
							+ " half_correct, correct, interview_id) VALUES(?,?,?,?,?,?)");
			preparedStatement.setString(1, date);
			preparedStatement.setString(2, duration);
			preparedStatement.setInt(3, incorrect);
			preparedStatement.setInt(4, halfCorrect);
			preparedStatement.setInt(5, correct);
			preparedStatement.setInt(6, interviewId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"Something goes wrong with making preparedStatement");
		}
	}

	private void addQuestions(Connection connection,
			PreparedStatement preparedStatement, int statisticsId,
			String questionText) throws InterviewSimulatorDaoException {
		LoggerDao.daoLogger.trace("adding questions...");
		try {
			preparedStatement = connection
					.prepareStatement("INSERT INTO statistics_questions (statistics_id"
							+ ", question_text) VALUES(?,?)");
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"preparing statement was failed");
		}
		try {
			preparedStatement.setInt(1, statisticsId);
			preparedStatement.setString(2, questionText);
			int updated = preparedStatement.executeUpdate();
			LoggerDao.daoLogger.debug("added " + updated + " questions");
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"seting table name was failed");
		}
	}

	private void addAnswers(Connection connection,
			PreparedStatement preparedStatement, int questionsId,
			String answerText, boolean isCorrect)
			throws InterviewSimulatorDaoException {
		LoggerDao.daoLogger.trace("adding answers...");
		try {
			preparedStatement = connection
					.prepareStatement("INSERT INTO statistics_answers (statistics_questions_id,"
							+ " answer_text, is_correct) VALUES(?,?,?)");
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"preparing statement was failed");
		}
		try {
			preparedStatement.setInt(1, questionsId);
			preparedStatement.setString(2, answerText);
			preparedStatement.setBoolean(3, isCorrect);
			int updated = preparedStatement.executeUpdate();
			LoggerDao.daoLogger.debug("added " + updated + " questions");
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"seting table name was failed");
		}
	}

	private int getCurrentId(Connection connection, String tableName)
			throws InterviewSimulatorDaoException {
		Statement statement = null;
		LoggerDao.daoLogger.trace("getting current id...");
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"creating statement was failed");
		}
		ResultSet rs = null;
		String sql = "SELECT MAX(id) FROM " + tableName;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException("Execute query was failed");
		}
		int id = 0;
		final int ID_COLUMN = 1;
		try {
			while (rs.next()) {
				id = rs.getInt(ID_COLUMN);
			}
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException("Iterate rs was failed");
		}
		LoggerDao.daoLogger.debug("get " + id + " id");
		return id;
	}

	private void closeConnection(Connection connection)
			throws InterviewSimulatorDaoException {
		LoggerDao.daoLogger.trace("closing connection...");
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"closing connection was failed:-(");
		}
	}
}
