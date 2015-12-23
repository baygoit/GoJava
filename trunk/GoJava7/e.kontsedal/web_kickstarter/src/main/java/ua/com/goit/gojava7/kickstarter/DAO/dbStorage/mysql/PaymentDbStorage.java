package ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractPaymentStorage;
import ua.com.goit.gojava7.kickstarter.model.Payment;

public class PaymentDbStorage extends AbstractPaymentStorage {

	private final String INSERT_PAYMENT = "INSERT INTO payments (id_project, card_owner, card_number, amount) VALUES (?, ?, ?, ?)";
	private final String SELECT_ALL_PAYMENTS = "SELECT id, name FROM payments";
	private final String SELECT_PAYMENTS_FROM_PROJECT = "SELECT SUM(amount) FROM payments WHERE id_project = ";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Payment> getAll() {
		return jdbcTemplate.query(SELECT_ALL_PAYMENTS, new Mapper());
	}

	@Override
	public void add(Payment payment) {
//		jdbcTemplate.batchUpdate(INSERT_PAYMENT, new StatementSetter(payment));
		System.out.println(payment);
		jdbcTemplate.update(INSERT_PAYMENT, new Object[] {payment.getIdParentProject(), payment.getCardOwner(), payment.getCardNumber(), payment.getRechargeAmount()});
	}

	@Override
	public int getSummaryProjectCostsCollected(int idProject) {
		return jdbcTemplate.queryForObject(SELECT_PAYMENTS_FROM_PROJECT + idProject, Integer.class);
	}

	public class Mapper implements RowMapper<Payment> {
		@Override
		public Payment mapRow(ResultSet resultSet, int index) throws SQLException {
			
			Payment payment = new Payment();
			payment.setIdPayment(resultSet.getInt("id"));
			payment.setIdParentProject(resultSet.getInt("id_project"));
			payment.setCardOwner(resultSet.getString("card_owner"));
			payment.setCardNumber(resultSet.getLong("card_number"));
			payment.setRechargeAmount(resultSet.getInt("amount"));
			return payment;
		}
	}
	
	public class StatementSetter implements BatchPreparedStatementSetter {
		
		List<Payment> payments;
		
		public StatementSetter(Payment payment) {
			payments = new ArrayList<>();
			payments.add(payment);
		}
		
		@Override
		public int getBatchSize() {
			return payments.size();
		}

		@Override
		public void setValues(PreparedStatement statement, int index) throws SQLException {
		
			Payment payment = payments.get(index);
			statement.setInt(1, payment.getIdParentProject());
			statement.setString(2, payment.getCardOwner());
			statement.setLong(3, payment.getCardNumber());
			statement.setInt(4, payment.getRechargeAmount());
		}

	}
}
