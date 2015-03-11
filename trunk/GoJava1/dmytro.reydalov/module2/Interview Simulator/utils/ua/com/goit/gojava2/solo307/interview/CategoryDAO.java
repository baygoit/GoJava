package ua.com.goit.gojava2.solo307.interview;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

	ConnectorJDBC connector;

	public CategoryDAO() {
		try {
			connector = new ConnectorJDBC();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public List<Category> getCategoriesList() throws InterviewSimulatorException {
		Connection connection = null;
		Statement statement = null;
		ResultSet categoriesSet = null;
		try {
			connection = connector.openAccess();
			statement = connection.createStatement();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		} catch (SQLException e) {
			throw new InterviewSimulatorException("Creating statement was failed:-(");
		}
		try {
			categoriesSet = statement.executeQuery("SELECT name, id FROM categories");
		} catch (SQLException e) {
			throw new InterviewSimulatorException("executing query was failed:-(");
		}
		List<Category> categories = new ArrayList<Category>();
		try {
			while (categoriesSet.next()) {
				categories.add(new Category(categoriesSet.getString("name").trim(), categoriesSet.getInt("id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException("reading result set was failed:-(");
		} finally {
			closeConnection(connection);
		}
		return categories;
	}

	public List<Category> getCategories(String[] names) throws InterviewSimulatorException {
		Connection connection = null;
		try {
			connection = connector.openAccess();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new InterviewSimulatorException("Creating statement was failed:-(");
		}
		ResultSet categoriesSet = null;
		for (int i = 0; i < names.length; i++) {
			try {
				final String NAME = "'" + names[i] + "'";
				categoriesSet = statement.executeQuery("SELECT id, name FROM categories WHERE name LIKE " + NAME);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new InterviewSimulatorException("executing query was failed:-(");
			}
		}
		List<Category> categories = new ArrayList<Category>();
		try {
			while (categoriesSet.next()) {
				categories.add(new Category(categoriesSet.getString("name").trim(), categoriesSet.getInt("id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException("reading result set was failed:-(");
		} finally {
			closeConnection(connection);
		}
		return categories;
	}

	public List<Question> getQuestions() throws InterviewSimulatorException {
		Connection connection = null;
		try {
			connection = connector.openAccess();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new InterviewSimulatorException("Creating statement was failed:-(");
		}
		ResultSet questionSet = null;
		try {
			questionSet = statement.executeQuery("select text, id, category_id from questions");
		} catch (SQLException e) {
			throw new InterviewSimulatorException("executing query was failed:-(");
		}
		List<Question> questions = new ArrayList<Question>();
		try {
			while (questionSet.next()) {
				questions.add(new Question(questionSet.getString("text").trim(), questionSet.getInt("id"), questionSet
						.getInt("category_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException("reading result set was failed:-(");
		} finally {
			closeConnection(connection);
		}
		return questions;
	}

	public List<Question> fillQuestions(List<Question> questions) throws InterviewSimulatorException {
		Connection connection = null;
		try {
			connection = connector.openAccess();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new InterviewSimulatorException("Creating statement was failed:-(");
		}
		ResultSet answerSet = null;
		try {
			answerSet = statement.executeQuery("select * from answers");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException("executing query was failed:-(");
		}
		List<Answer> answers = new ArrayList<Answer>();
		final String TRUE = "t";
		try {
			while (answerSet.next()) {
				String bool = answerSet.getString("is_correct");
				boolean isCorrect = false;
				if (bool.equals(TRUE))
					isCorrect = true;
				answers.add(new Answer(answerSet.getInt("id"), answerSet.getString("text").trim(), isCorrect, answerSet
						.getInt("question_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException("reading result set was failed:-(");
		} finally {
			closeConnection(connection);
		}
		for (Question question : questions) {
			for (Answer answer : answers) {
				if (question.getId() == answer.getQuestionId())
					question.addAnswer(answer);
			}
		}
		return questions;
	}

	public List<Category> fillCategories(List<Category> categories, List<Question> questions) {
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

	public void closeConnection(Connection connection) throws InterviewSimulatorException {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new InterviewSimulatorException("closing connection was failed:-(");
		}
	}
}
