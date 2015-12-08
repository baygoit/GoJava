package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.config.DBConnectionManager;
import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class QuestionDaoSqlImpl implements QuestionDao {
	private DBConnectionManager connectionManager;

	public QuestionDaoSqlImpl(DBConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public List<Question> getQuestions(int projectId) {
		List<Question> questions = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = connectionManager.getConnection();
			stmt = conn.prepareStatement("SELECT id, questionText FROM question WHERE projectId =" + projectId);
			rset = stmt.executeQuery();

			Question question;
			while (rset.next()) {
				int id = rset.getInt("id");
				String questionText = rset.getString("questionText");

				question = new Question();
				question.setId(id);
				question.setProjectId(projectId);
				question.setQuestionText(questionText);

				questions.add(question);
			}
		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		} finally {
            try { if (rset != null) rset.close(); } catch(Exception e) { }
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
		}
		return questions;
	}

	@Override
	public void addQuestion(Question question) {
			
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = connectionManager.getConnection();
			stmt = conn.prepareStatement("INSERT INTO question (projectId, questionText) VALUES ('"
					+ question.getProjectId() + "', '" + question.getQuestionText() + "');");
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		} finally {
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
		}
	}

}
