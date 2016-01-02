package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.hibernate.HibernateUtil;

@Repository
public class QuestionDaoSqlImpl implements QuestionDao {
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/

	@Override
	public List<Question> getQuestions(int projectId) {
		
		/*String sql = "SELECT id, projectId, questionText FROM question WHERE projectId = ?";
		return jdbcTemplate.query(sql, new Integer[] { projectId },
				new BeanPropertyRowMapper<Question>(Question.class));*/

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = session.createCriteria(Question.class);	
		criteria.add(Restrictions.eq("projectId", projectId));
		List<Question> questions = criteria.list();
		
		session.close();

		return questions;
	}

	@Override
	public void addQuestion(Question question) {

		/*String sql = "INSERT INTO question (projectId, questionText) VALUES (?, ?)";
		jdbcTemplate.update(sql, question.getProjectId(), question.getQuestionText());*/
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		session.save(question);
		session.getTransaction().commit();

		session.close();
	}

}
