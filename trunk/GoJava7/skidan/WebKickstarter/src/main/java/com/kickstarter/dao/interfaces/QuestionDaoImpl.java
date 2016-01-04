package com.kickstarter.dao.interfaces;


import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kickstarter.hibernate.HibernateUtil;
import com.kickstarter.model.Project;
import com.kickstarter.model.Question;

@Repository
public class QuestionDaoImpl implements QuestionDao {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	// public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	// this.jdbcTemplate = jdbcTemplate;
	// }

	public void add(String newQuestion, Project project) {
		 Question question = new Question();
		 question.setProject(project);
		 question.setQuestion(newQuestion);
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 session.beginTransaction();
		 session.save(question); 
		 session.getTransaction().commit();
		 session.close();

//		String sql = "INSERT INTO questions (projectId, question) VALUES (?, ?)";
//		jdbcTemplate.update(sql, new Object[] { projectId, newQuestion });
	}

	public List<Question> getProjectQuestions(int projectId) {
		final String sql = "from Question where projectId=" + projectId;
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Question> questionList = session.createQuery(sql).list();
		if (questionList.isEmpty()) {
			return null;
		}
		session.close();
		return questionList;
	}

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
}

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