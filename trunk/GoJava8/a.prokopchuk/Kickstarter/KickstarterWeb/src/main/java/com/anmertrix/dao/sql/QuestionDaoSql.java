package com.anmertrix.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.QuestionDao;
import com.anmertrix.domain.Question;

@Repository
public class QuestionDaoSql implements QuestionDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public List<Question> getQuestions(long projectId) {
		List<Question> questions = em.createNamedQuery("Question.getQuestions", Question.class)
				.setParameter("projectId", projectId).getResultList();
		questions.forEach(b -> b.getAnswers().size());
		return questions;
	}

	@Override
	@Transactional
	public void insertQuestion(Question question) {
		em.persist(question);
	}

}
