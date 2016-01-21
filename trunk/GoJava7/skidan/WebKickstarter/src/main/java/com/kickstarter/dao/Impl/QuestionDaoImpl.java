package com.kickstarter.dao.Impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kickstarter.dao.Interfaces.QuestionDao;
import com.kickstarter.model.Project;
import com.kickstarter.model.Question;

@Repository
public class QuestionDaoImpl implements QuestionDao {
	
	@Autowired(required=false)
	private SessionFactory sessionFactory;

	@Transactional 
	public void add(String newQuestion, Project project) {
		Question question = new Question();
		question.setProject(project);
		question.setQuestion(newQuestion);
		Session session = sessionFactory.openSession();
		session.save(question);
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Question> getProjectQuestions(int projectId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Question where projectId= :projectId");
		query.setInteger("projectId", projectId);
		List<Question> questionList = query.list();
		if (questionList.isEmpty()) {
			return null;
		}
		session.close();
		return questionList;
	}
}










//String sql = "INSERT INTO questions (projectId, question) VALUES (?, ?)";
	// jdbcTemplate.update(sql, new Object[] { projectId, newQuestion });
	// @Autowired
	// private JdbcTemplate jdbcTemplate;

	// public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	// this.jdbcTemplate = jdbcTemplate;
	// }

	/*
	 * public List<Question> getProjectQuestions(int projectId) { String sql =
	 * "select projectId,question from questions where projectId = ?"; return
	 * jdbcTemplate.query(sql, new Object[] { projectId }, new
	 * QuestionMapper());
	 * 
	 * }
	 */

	/*
	 * public final class QuestionMapper implements RowMapper<Question> {
	 * 
	 * public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
	 * Question question = new Question();
	 * question.setProjectId(rs.getInt("projectId"));
	 * question.setQuestion(rs.getString("question")); return question;
	 * 
	 * }
	 * 
	 * }
	 */

// @Autowired
// private BasicDataSource dbCon;
//
// public BasicDataSource getDbCon() {
// return dbCon;
// }
//
// public void setDbCon(BasicDataSource dbCon) {
// this.dbCon = dbCon;
// }
// public List<Question> getProjectQuestions(String projectTitle) {
// ResultSet rs = null;
// List<Question> list = new ArrayList<>();
//
// try (PreparedStatement pStatement = dbCon.getConnection()
// .prepareStatement("select projectTitle,question from questions where
// projectTitle = ?")) {
// pStatement.setString(1, projectTitle);
// rs = pStatement.executeQuery();
//
// while (rs.next()) {
// Question question = new Question();
// question.setProjectTitle(rs.getString("projectTitle"));
// question.setQuestion(rs.getString("question"));
// list.add(question);
// }
// } catch (SQLException e) {
// System.out.println("Question MySql connection problem");
// }
// return list;
// }

// public void add(String newQuestion, String projectTitle) {
// try (PreparedStatement pStatement = dbCon.getConnection()
// .prepareStatement("INSERT INTO questions (projectTitle, question) VALUES (?,
// ?)")) {
// pStatement.setString(1, projectTitle);
// pStatement.setString(2, newQuestion);
// pStatement.executeUpdate();
// } catch (SQLException e) {
// System.out.println("Question add MySql connection problem");
// }
// }
// }

// <aop:config>
// <aop:aspect id ="SomeSpringBean"/>
// <aop:pointcut id = "pointcut1" expression="Execution(*com.dfvd.fad.*(..))" />
// <aop:before>
// pointcut-ref = "pointcut1"
// method="some method in SomeSpringesn(aspect declared)"