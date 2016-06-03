package ua.nenya.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.domain.Question;
import ua.nenya.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public boolean isQuestionExist(Question question) {
		Query query = em.createNamedQuery("Question.Count");
		query.setParameter("name", question.getName());
		query.setParameter("projectId", question.getProject().getId());
		long count = (long) query.getSingleResult();
		return count!=0;
	}

}
