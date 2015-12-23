package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.models.Payment;

@Repository
public class PaymentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(PaymentDao.class);

	public PaymentDao() {
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add(Payment payment) {
		log.info("<void> add({})...", payment);
		String query = "insert into payment (user, card, amount, project_id) values (?, ?, ?, ?)";
		jdbcTemplate.update(query,
				new Object[] { payment.getUser(), payment.getCard(), payment.getAmount(), payment.getProjectId() });
	}

	public List<Payment> getByProject(int projectId) {
		log.info("<Payment> getByProject({})...", projectId);
		String query = "select user, card, amount, project_id from payment where project_id = ?";
		return jdbcTemplate.query(query, new Object[] { projectId }, new PaymentMapper());
	}

	public Integer calculatePledgedForProject(int projectId) {
		log.info("<int> calculatePledgedForProject({})...", projectId);
		String query = "select sum(amount) as sum from payment where project_id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { projectId }, Integer.class);
	}

	public List<Payment> findTop5Project() {
		log.info("<payments> findTop5Project({})...");
		String query = "select sum(amount) as amount, project_id from payment group by project_id order by amount desc limit 5";
		return jdbcTemplate.query(query, new TopPaymentMapper());
	}

	private final class PaymentMapper implements RowMapper<Payment> {
		public Payment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			log.info("PaymentMapper()...");
			Payment payment = new Payment();
			payment.setUser(resultSet.getString("user"));
			payment.setCard(resultSet.getString("card"));
			payment.setAmount(resultSet.getInt("amount"));
			payment.setProjectId(resultSet.getInt("project_id"));
			log.debug("PaymentMapper() returned payment: {}", payment);
			return payment;
		}
	}

	private final class TopPaymentMapper implements RowMapper<Payment> {
		public Payment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			log.info("PaymentMapper()...");
			Payment payment = new Payment();
			payment.setAmount(resultSet.getInt("amount"));
			payment.setProjectId(resultSet.getInt("project_id"));
			log.debug("PaymentMapper() returned payment: {}", payment);
			return payment;
		}
	}
}
