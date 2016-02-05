package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@Repository
@Transactional
public class QuestionDaoSqlImpl implements QuestionDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Question> getQuestions(Long projectId) {
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Question> criteriaQuery = criteriaBuilder.createQuery(Question.class);
		Root<Question> entityRoot = criteriaQuery.from(Question.class);
		criteriaQuery.select(entityRoot);
		criteriaQuery.where(criteriaBuilder.equal(entityRoot.get("projectId") , projectId));
		TypedQuery<Question> query = em.createQuery(criteriaQuery);

		return query.getResultList();
		
	}

	@Override
	public void addQuestion(Question question) {
		
		em.merge(question);
	}

}
