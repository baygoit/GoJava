package ua.com.goit.gojava7.kickstarter.dao.mysql;

import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.dao.AbstractJdbcTemplate;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;

@Repository
public class PaymentDaoMysqlImpl extends AbstractJdbcTemplate implements PaymentDao {

	public void add(Payment payment) {
		String sql = "INSERT INTO payments (project_id, user_name, credit_card_number, donating_sum) VALUES (?, ?, ?, ?)";
		getJdbcTemplate().update(
				sql,
				new Object[] { payment.getProjectID(), payment.getUserName(), payment.getCreditCardNumber(),
						payment.getDonatingSum() });
	}

	public void remove(Payment payment) {
		String sql = "DELETE FROM payments WHERE project_id = ?";
		getJdbcTemplate().update(sql, new Object[] { payment.getProjectID() });
	}

	public int getSumProjectPayments(int projectId) {
		String sql = "SELECT SUM(donating_sum) FROM payments WHERE project_id = ?";
		return getJdbcTemplate().queryForObject(sql, new Object[] { projectId }, Integer.class);
	}
}
