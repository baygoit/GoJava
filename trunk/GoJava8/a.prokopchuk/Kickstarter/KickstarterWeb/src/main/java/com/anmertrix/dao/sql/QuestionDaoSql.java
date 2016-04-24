package com.anmertrix.dao.sql;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.QuestionDao;
import com.anmertrix.domain.Question;
import com.anmertrix.dao.sql.HibernateUtil;

@Repository
public class QuestionDaoSql implements QuestionDao {
	
	@Override
	public void insertQuestion(Question question) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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
