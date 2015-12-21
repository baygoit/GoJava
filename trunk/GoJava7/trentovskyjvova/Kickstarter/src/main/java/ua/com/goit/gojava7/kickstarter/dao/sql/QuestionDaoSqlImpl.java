package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

@Repository
public class QuestionDaoSqlImpl implements QuestionDao {
	@Autowired
	private DataSource dataSource;

	@Override
	public List<Question> getQuestions(int projectId) {
		List<Question> questions = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("SELECT id, questionText FROM question WHERE projectId = ?");
			stmt.setInt(1, projectId);
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
			try {
				if (rset != null)
					rset.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return questions;
	}

	@Override
	public void addQuestion(Question question) {

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("INSERT INTO question (projectId, questionText) VALUES (?, ?)");
			stmt.setInt(1, question.getProjectId());
			stmt.setString(2, question.getQuestionText());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

}
