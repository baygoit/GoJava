package ua.com.goit.gojava7.kickstarter.dao.DBImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.model.Question;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class QuestionDaoDb implements QuestionDao {

	private static final Logger log = LoggerFactory.getLogger(QuestionDaoDb.class);

	@PersistenceContext
	private EntityManager em;

	public void add(Question question) {
		log.info("<void> add({})...", question);
		em.persist(question);
	}
}
