package ua.nenya.dao.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.QuestionDao;
import ua.nenya.domain.Question;

@Transactional
@Repository
public class QuestionDaoImpl implements QuestionDao {
	
	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public List<Question> getQuestions(Long projectId) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Question> criteriaQuery = criteriaBuilder.createQuery(Question.class);
		Root<Question> root = criteriaQuery.from(Question.class);
		criteriaQuery.select(root);
		Predicate criteria = criteriaBuilder.equal(root.get("project").get("id"), projectId);
		criteriaQuery.where(criteria);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
		TypedQuery<Question> typedQuery = em.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}
	
	@Override
	public Question writeQuestionInProject(Question question) {
		em.persist(question);
		return question;
	}

}
