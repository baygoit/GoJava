package com.anmertrix.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.DaoException;
import com.anmertrix.dao.PaymentDao;
import com.anmertrix.domain.Payment;

@Repository
public class PaymentDaoSql implements PaymentDao {
	
	private static final String SELECT_PAYMENTS = "SELECT id, cardholder_name, amount FROM payment WHERE project_id=?";
	private static final String INSERT_PAYMENT = "INSERT INTO payment (project_id, cardholder_name, card_number, amount) VALUES (?, ?, ?, ?)";

	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Payment> getPaymentsByProjectId(int project_id) {
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_PAYMENTS)) {
			statement.setInt(1, project_id);
			ResultSet rs = statement.executeQuery();
			List<Payment> payments = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String cardholderName = rs.getString("cardholder_name");
				int amount = rs.getInt("amount");
				
				Payment payment = new Payment();
				payment.setId(id);
				payment.setCardholderName(cardholderName);
				payment.setAmount(amount);
				payments.add(payment);				
			}
			return payments;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void insertPayment(Payment payment) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_PAYMENT)) {
			statement.setInt(1, payment.getProjectId());
			statement.setString(2, payment.getCardholderName());
			statement.setString(3, payment.getCardNumber());
			statement.setInt(4, payment.getAmount());
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
