package com.anmertrix.dao.sql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.PaymentDao;
import com.anmertrix.domain.Payment;

@Repository
public class PaymentDaoSql implements PaymentDao {
	
	private static final String SELECT_GATHERED_BUDGET = "SELECT COALESCE(SUM(amount),0) FROM payment WHERE project_id=?";
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public long getGatheredBudgetByProjectId(long projectId) {
		return jdbcTemplate.queryForObject(SELECT_GATHERED_BUDGET, new Object[] { projectId }, Long.class);
	}

	@Transactional
	@Override
	public void insertPayment(Payment payment) {
		try (Session session = sessionFactory.openSession()) {
			session.save(payment);
		}
	}

}
