package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class PaymentDaoSqlImpl implements PaymentDao {
	private DaoProvider daoProvider;

	public PaymentDaoSqlImpl(DaoProvider daoProvider) {
		this.daoProvider = daoProvider;
	}

	@Override
	public List<Payment> getPayments(int projectId) {
		List<Payment> payments = new ArrayList<>();
		Connection connection = daoProvider.open();
		
		try (PreparedStatement ps = connection
				.prepareStatement("SELECT id, name, cardNumber, pledge FROM payment WHERE projectId ="
						+ projectId);
				ResultSet rs = ps.executeQuery()) {

			Payment payment;
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String cardNumber = rs.getString("cardNumber");
				int pledge = rs.getInt("pledge");

				payment = new Payment();
				payment.setId(id);
				payment.setProjectId(projectId);
				payment.setName(name);
				payment.setCardNumber(cardNumber);
				payment.setPledge(pledge);
				payments.add(payment);
			}
		} catch (SQLException e) {
			getPayments(projectId);
			//throw new IODatabaseException("Problem with database", e);
		}
		return payments;
	}

	@Override
	public void addPayment(Payment payment) {
		Connection connection = daoProvider.open();
		
		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO payment (projectId, name, cardNumber, pledge) VALUES ('"
						+ payment.getProjectId()
						+ "', '"
						+ payment.getName()
						+ "', '"
						+ payment.getCardNumber()
						+ "', '"
						+ payment.getPledge()
						+ "');");) {
			ps.executeUpdate();

		} catch (SQLException e) {
			addPayment(payment);
			//throw new IODatabaseException("Problem with database", e);
		}

	}

	@Override
	public int getPledged(int projectId) {
		int pledged = 0;
		Connection connection = daoProvider.open();
		
		try (PreparedStatement ps = connection
				.prepareStatement("SELECT SUM(pledge) pledged FROM payment WHERE projectId ="
						+ projectId);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				pledged = rs.getInt("pledged");
			}
		} catch (SQLException e) {
			getPledged(projectId);
			//throw new IODatabaseException("Problem with database", e);
		}
		return pledged;
	}

}
