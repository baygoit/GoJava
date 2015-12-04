package ua.com.goit.gojava7.kickstarter.DAO.dbStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractPaymentStorage;
import ua.com.goit.gojava7.kickstarter.model.Payment;

public class PaymentDbStorage extends AbstractPaymentStorage{
	
	private final String INSERT_PAYMENT = "INSERT INTO payments (id_project, card_owner, card_number, amount) VALUES (?, ?, ?, ?)";
	private final String SELECT_ALL_PAYMENTS = "SELECT id, name FROM payments";
	private final String SELECT_PAYMENTS_FROM_PROJECT = "SELECT amount FROM payments WHERE id_project = ";


	@Override
	public List<Payment> getAll() {
		List<Payment> payments = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(DATABASE_URL, DBLOGIN, DBPASSWORD);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_PAYMENTS);

			while (resultSet.next()) {
				Payment payment = new Payment();
				payment.setIdPayment(resultSet.getInt("id"));
				payment.setIdParentProject(resultSet.getInt("id_project"));
				payment.setCardOwner(resultSet.getString("card_owner"));
				payment.setCardNumber(resultSet.getLong("card_number"));
				payment.setRechargeAmount(resultSet.getInt("amount"));
				payments.add(payment);
			}
		} catch (SQLException e) {
			System.err.println("DB reading problem");
		}
		return payments;
	}

	@Override
	public void add(Payment payment) {
		try {
			Connection connection = DriverManager.getConnection(DATABASE_URL, DBLOGIN, DBPASSWORD);
			PreparedStatement statement = connection.prepareStatement(INSERT_PAYMENT);
			statement.setInt(1, payment.getIdParentProject());
			statement.setString(2, payment.getCardOwner());
			statement.setLong(3, payment.getCardNumber());
			statement.setInt(4, payment.getRechargeAmount());
			statement.executeUpdate();

		} catch (SQLException e) {
			System.err.println("DB writing problem");
		}
	}

	@Override
	public int getSummaryProjectCostsCollected(int idProject) {
		int sum = 0;
		try {
			Connection connection = DriverManager.getConnection(DATABASE_URL, DBLOGIN, DBPASSWORD);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_PAYMENTS_FROM_PROJECT + idProject);
			while (resultSet.next()) {
				sum += resultSet.getInt("amount");
			}
		} catch (SQLException e) {
			System.err.println("DB reading problem");
		}
		return sum;
	}

}
