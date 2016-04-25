package com.anmertrix.dao.sql;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.QuestionDao;
import com.anmertrix.domain.Question;

@Repository
public class QuestionDaoSql implements QuestionDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertQuestion(Question question) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			session.save(question);
 			transaction = session.beginTransaction();
 			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
