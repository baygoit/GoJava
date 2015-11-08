package ua.com.goit.gojava.solo307.intersim.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.solo307.intersim.commons.ApplicationContextProvider;
import ua.com.goit.gojava.solo307.intersim.domain.Answer;
import ua.com.goit.gojava.solo307.intersim.domain.Category;
import ua.com.goit.gojava.solo307.intersim.domain.Question;

public class CategoryDao {

	ConnectorJdbc connector;

	public CategoryDao() {
		connector = (ConnectorJdbc) ApplicationContextProvider.getBean("connector");
	}

	public List<Category> getCategoriesList()
			throws InterviewSimulatorDaoException {
		LoggerDao.daoLogger.trace("getting a List of categories...");
		Connection connection = null;
		Statement statement = null;
		ResultSet categoriesSet = null;
		try {
			connection = connector.openAccess();
			statement = connection.createStatement();
		} catch (InterviewSimulatorDaoException e) {
			LoggerDao.daoLogger.error(e);
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"Creating statement was failed:-(");
		}
		try {
			categoriesSet = statement
					.executeQuery("SELECT name, id FROM categories");
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"executing query was failed:-(");
		}
		List<Category> categories = new ArrayList<Category>();
		try {
			while (categoriesSet.next()) {
				categories.add(new Category(categoriesSet.getString("name")
						.trim(), categoriesSet.getInt("id")));
			}
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"reading result set was failed:-(");
		} finally {
			closeConnection(connection);
		}
		LoggerDao.daoLogger.trace("List of categories was get...");
		return categories;
	}

	public List<Category> getCategories(String[] names)
			throws InterviewSimulatorDaoException {
		LoggerDao.daoLogger.trace("getting categories...");
		Connection connection = null;
		try {
			connection = connector.openAccess();
		} catch (InterviewSimulatorDaoException e) {
			e.getMessage();
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
		ResultSet categoriesSet = null;
		for (int i = 0; i < names.length; i++) {
			try {
				final String NAME = "'" + names[i] + "'";
				categoriesSet = statement
						.executeQuery("SELECT id, name FROM categories WHERE name LIKE "
								+ NAME);
			} catch (SQLException e) {
				LoggerDao.daoLogger.error(e);
				throw new InterviewSimulatorDaoException(
						"executing query was failed:-(");
			}
		}
		List<Category> categories = new ArrayList<Category>();
		try {
			while (categoriesSet.next()) {
				categories.add(new Category(categoriesSet.getString("name")
						.trim(), categoriesSet.getInt("id")));
			}
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"reading result set was failed:-(");
		} finally {
			closeConnection(connection);
		}
		LoggerDao.daoLogger.trace("categories was get...");
		return categories;
	}

	public List<Question> getQuestions() throws InterviewSimulatorDaoException {
		LoggerDao.daoLogger.trace("getting questions...");
		Connection connection = null;
		try {
			connection = connector.openAccess();
		} catch (InterviewSimulatorDaoException e) {
			e.getMessage();
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
		ResultSet questionSet = null;
		try {
			questionSet = statement
					.executeQuery("select text, id, category_id from questions");
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"executing query was failed:-(");
		}
		List<Question> questions = new ArrayList<Question>();
		try {
			while (questionSet.next()) {
				questions.add(new Question(
						questionSet.getString("text").trim(), questionSet
								.getInt("id"), questionSet
								.getInt("category_id")));
			}
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"reading result set was failed:-(");
		} finally {
			closeConnection(connection);
		}
		LoggerDao.daoLogger.trace("questions was get.");
		return questions;
	}

	public List<Question> attachAnswers(List<Question> questions)
			throws InterviewSimulatorDaoException {
		LoggerDao.daoLogger.trace("filling questions by answers...");
		Connection connection = null;
		try {
			connection = connector.openAccess();
		} catch (InterviewSimulatorDaoException e) {
			e.getMessage();
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
		ResultSet answerSet = null;
		try {
			answerSet = statement.executeQuery("select * from answers");
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"executing query was failed:-(");
		}
		List<Answer> answers = new ArrayList<Answer>();
		final String TRUE = "t";
		try {
			while (answerSet.next()) {
				String bool = answerSet.getString("is_correct");
				boolean isCorrect = false;
				if (bool.equals(TRUE))
					isCorrect = true;
				answers.add(new Answer(answerSet.getInt("id"), answerSet
						.getString("text"), isCorrect, answerSet
						.getInt("question_id")));
			}
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
			throw new InterviewSimulatorDaoException(
					"reading result set was failed:-(");
		} finally {
			closeConnection(connection);
		}
		for (Question question : questions) {
			for (Answer answer : answers) {
				if (question.getId() == answer.getQuestionId())
					question.addAnswer(answer);
			}
		}
		LoggerDao.daoLogger.trace("answers was attached");
		return questions;
	}

	public List<Category> fillCategories(List<Category> categories,
			List<Question> questions) {
		for (Category category : categories) {
			for (Question question : questions) {
				final int CAT_ID = category.getId();
				if (CAT_ID == question.getCategoryId()) {
					category.addQuestion(question);
				}
			}
		}
		return categories;
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
