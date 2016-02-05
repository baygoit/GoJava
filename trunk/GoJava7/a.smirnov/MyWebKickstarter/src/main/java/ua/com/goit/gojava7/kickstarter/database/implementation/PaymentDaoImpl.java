package ua.com.goit.gojava7.kickstarter.database.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.database.contract.PaymentDao;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public long getSumProjectPayments(int projectId) {
		Long result = (Long) entityManager.createNamedQuery("Payment.findProjectPayments").setParameter("id", projectId).getSingleResult();
		return (result != null) ? result : 0;
	}

	@Override
	@Transactional
	public void add(Payment payment) {
		entityManager.persist(payment);
	}
	
	@Override
	@Transactional
	public void remove(Payment payment) {
		entityManager.remove(payment);
	}
}
