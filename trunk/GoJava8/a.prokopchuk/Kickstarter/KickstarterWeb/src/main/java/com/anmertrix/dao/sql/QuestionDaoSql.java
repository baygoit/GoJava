package com.anmertrix.dao.sql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.QuestionDao;
import com.anmertrix.domain.Question;

@Repository
public class QuestionDaoSql implements QuestionDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
	public void insertQuestion(Question question) {
		Session session = sessionFactory.getCurrentSession();
		session.save(question);
	}
}
