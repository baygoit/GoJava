package com.anmertrix.dao.sql;

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
	public void insertQuestion(Question question) {
		em.persist(question);
	}

}
