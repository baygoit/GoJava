package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.hibernate.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.models.Project;
import ua.com.goit.gojava7.kickstarter.models.Question;

@Repository
public class QuestionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(QuestionDao.class);

	public QuestionDao() {
		log.info("Constructor QuestionDao()...");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add(Question question) {
		log.info("<void> add({})...", question);
		String query = "insert into question (time, question, project_id) values (?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {question.getTime(), question.getQuestion(), question.getProjectId()});
	}

	@SuppressWarnings("unchecked")
	public List<Question> getByProject(Project project) {		
		log.info("<questions> getByProject({})...", project);
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Question> questions = session.createCriteria(Question.class)
				.add(Restrictions.eq("Project", project))
				.list();

		session.close();
		log.debug("<questions> getByProject({}) returned questions: {}", project, questions);
		return questions;		
	}
}
