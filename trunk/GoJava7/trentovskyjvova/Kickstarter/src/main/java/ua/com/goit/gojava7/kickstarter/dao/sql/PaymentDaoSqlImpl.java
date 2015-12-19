package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

@Repository
public class PaymentDaoSqlImpl implements PaymentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Payment> getPayments(int projectId) {

		String sql = "SELECT id, projectId, name, cardNumber, pledge FROM payment WHERE projectId = ?";
		return jdbcTemplate.query(sql, new Integer[] { projectId }, new BeanPropertyRowMapper<Payment>(Payment.class));
	}

	@Override
	public void addPayment(Payment payment) {

		String sql = "INSERT INTO payment (projectId, name, cardNumber, pledge) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, payment.getProjectId(), payment.getName(), payment.getCardNumber(),
				payment.getPledge());
	}

	@Override
	public int getPledged(int projectId) {

		String sql = "SELECT SUM(pledge) pledged FROM payment WHERE projectId = ?";
		return jdbcTemplate.queryForObject(sql, new Integer[] { projectId }, Integer.class);
	}

}
