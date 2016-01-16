package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.validator.MyValidator;
import ua.com.goit.gojava7.kickstarter.model.Question;

@Repository
@Transactional
public class QuestionDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private MyValidator myValidator;

	private static final Logger log = LoggerFactory.getLogger(QuestionDao.class);

	@SuppressWarnings("unchecked")
	public List<Question> getByProject(Long projectId) {
		log.info("<questions> getByProject({})...", projectId);
		Session session = sessionFactory.getCurrentSession();

		return session.createCriteria(Question.class)
				.add(Restrictions.eq("project.id", projectId))
				.list();
	}

	public void createQuestion(String text, Long projectId) {
		log.info("<void> createQuestion({}, {})...", text, projectId);
		if (myValidator.validateQuestion(text)) {
			Question question = new Question();
			question.setQuestion(text);
			question.setProject(projectDao.get(projectId));
			add(question);
		}
	}

	private void add(Question question) {
		log.info("<void> add()...", question);
		Session session = sessionFactory.getCurrentSession();

		session.save(question);
	}
}
