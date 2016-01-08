package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.models.Question;

@Repository
public class QuestionDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger log = LoggerFactory.getLogger(QuestionDao.class);

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Question question) {
		log.info("<void> add({})...", question);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(question);
		session.getTransaction().commit();

		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Question> getByProject(Long projectId) {
		log.info("<questions> getByProject({})...", projectId);
		Session session = sessionFactory.openSession();

		List<Question> questions = session.createCriteria(Question.class)
				.add(Restrictions.eq("project.id", projectId))
				.list();

		session.close();
		log.debug("<questions> getByProject({}) returned questions: {}", projectId, questions);

		if (questions.isEmpty())
			return null;

		return questions;
	}
}
