package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class PaymentDaoSqlImpl implements PaymentDao {
	private DataSource dataSource;

	public PaymentDaoSqlImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Payment> getPayments(int projectId) {
		List<Payment> payments = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(
					"SELECT id, name, cardNumber, pledge FROM payment WHERE projectId = " + projectId);
			rset = stmt.executeQuery();

			Payment payment;
			while (rset.next()) {
				int id = rset.getInt("id");
				String name = rset.getString("name");
				String cardNumber = rset.getString("cardNumber");
				int pledge = rset.getInt("pledge");

				payment = new Payment();
				payment.setId(id);
				payment.setProjectId(projectId);
				payment.setName(name);
				payment.setCardNumber(cardNumber);
				payment.setPledge(pledge);
				payments.add(payment);
			}
		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		} finally {
            try { if (rset != null) rset.close(); } catch(Exception e) { }
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
		}
		
		return payments;
	}

	@Override
	public void addPayment(Payment payment) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("INSERT INTO payment (projectId, name, cardNumber, pledge) VALUES ('"
					+ payment.getProjectId() + "', '" + payment.getName() + "', '" + payment.getCardNumber() + "', '"
					+ payment.getPledge() + "');");
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		} finally {
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
		}

	}

	@Override
	public int getPledged(int projectId) {
		int pledged = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("SELECT SUM(pledge) pledged FROM payment WHERE projectId =" + projectId);
			rset = stmt.executeQuery();

			while (rset.next()) {
				pledged = rset.getInt("pledged");
			}
		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		} finally {
            try { if (rset != null) rset.close(); } catch(Exception e) { }
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
		}
		return pledged;
	}

}
