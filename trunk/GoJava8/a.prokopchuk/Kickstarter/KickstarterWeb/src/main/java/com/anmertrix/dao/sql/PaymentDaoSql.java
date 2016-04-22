package com.anmertrix.dao.sql;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.PaymentDao;
import com.anmertrix.domain.Payment;

@Repository
public class PaymentDaoSql implements PaymentDao {
	
	private static final String SELECT_PAYMENTS = "SELECT id, cardholder_name, amount FROM payment WHERE project_id=?";
	private static final String SELECT_GATHERED_BUDGETS = "SELECT SUM(amount) FROM payment GROUP BY project_id";
	private static final String INSERT_PAYMENT = "INSERT INTO payment (project_id, cardholder_name, card_number, amount) VALUES (?, ?, ?, ?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Payment> getPaymentsByProjectId(int projectId) {
		return jdbcTemplate.query(SELECT_PAYMENTS, new Object[] { projectId }, new BeanPropertyRowMapper<Payment>(Payment.class));
	}
	
	@Override
	public List<Long> getGatheredBudgets() {
		return jdbcTemplate.queryForList(SELECT_GATHERED_BUDGETS, Long.class);
	}

	@Override
	public void insertPayment(Payment payment) {
		jdbcTemplate.update(INSERT_PAYMENT, new Object[] { payment.getProjectId(), payment.getCardholderName(), payment.getCardNumber(), payment.getAmount() });
	}

}
