package com.anmertrix.dao.sql;

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
	@Transactional
	public void insertPayment(Payment payment) {
		em.persist(payment);
	}
}
