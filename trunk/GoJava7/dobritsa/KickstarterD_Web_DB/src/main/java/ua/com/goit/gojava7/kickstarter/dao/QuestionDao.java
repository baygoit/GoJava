package ua.com.goit.gojava7.kickstarter.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.model.Question;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class QuestionDao {

	private static final Logger log = LoggerFactory.getLogger(QuestionDao.class);

	@PersistenceContext
	private EntityManager em;

	public void add(Question question) {
		log.info("<void> add({})...", question);

		em.persist(question);
	}
}
