package ua.com.goit.gojava7.kickstarter.dao.mysql;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.dao.AbstractDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;

public class PaymentDaoMysqlImpl extends AbstractDao implements PaymentDao {

	public void add(Payment payment) {
		String sql = "INSERT INTO payments (project_id, user_name, credit_card_number, donating_sum) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { payment.getProjectID(), payment.getUserName(), payment.getCreditCardNumber(),
				payment.getDonatingSum() });
	}

	public void remove(Payment payment) {
		String sql = "DELETE FROM payments WHERE project_id = ?";
		jdbcTemplate.update(sql, new Object[] { payment.getProjectID() });
	}

	public int getSumProjectPayments(int projectId) {
		String sql = "SELECT SUM(donating_sum) FROM payments WHERE project_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { projectId }, Integer.class);
	}
}
