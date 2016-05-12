package com.anmertrix.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.PaymentDao;
import com.anmertrix.domain.Payment;

@Repository
public class PaymentDaoSql implements PaymentDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Payment> getPaymentsByProjectId(long projectId) {
		return em.createNamedQuery("Payment.getPayments", Payment.class)
				.setParameter("projectId", projectId).getResultList();
	}
	
	@Override
	public long getGatheredBudgetByProjectId(long projectId) {
		Long result = (Long) em.createNamedQuery("Payment.getGatheredBudget").setParameter("projectId", projectId).getSingleResult();
		return (result != null) ? result : 0;
	}

	@Override
	@Transactional
	public void insertPayment(Payment payment) {
		em.persist(payment);
	}
}
