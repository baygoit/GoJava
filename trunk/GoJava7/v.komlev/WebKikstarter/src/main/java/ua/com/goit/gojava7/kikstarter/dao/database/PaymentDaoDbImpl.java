package ua.com.goit.gojava7.kikstarter.dao.database;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kikstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kikstarter.domain.Payment;

@Repository
public class PaymentDaoDbImpl implements PaymentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Payment payment) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(payment);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void remove(Payment payment) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(payment);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Integer getSumOfProject(int projectId) {
		Session session=sessionFactory.openSession();
		
		Criteria criteria=session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("projects.id",projectId));
		criteria.setProjection(Projections.sum("amount_donation"));
		Integer resultSum=(Integer)criteria.uniqueResult();
		
		session.close();
		return resultSum;
	}

}
