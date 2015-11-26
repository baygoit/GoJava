package ua.com.goit.gojava7.kickstarter.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.AbstractPaymentDao;

public class PaymentDaoMysqlImpl extends AbstractPaymentDao {

	@Override
	public void add(Payment payment) {
		String insertPayment = "INSERT INTO payments (project_id, user_name, creditCardNumber, donating_sum) VALUES ('" 
				+ payment.getProjectID() + "' , '"+ payment.getUserName() + "', '" 
				+ payment.getCreditCardNumber() + "' , '" + payment.getDonatingSum() + "')";
		
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			statement.executeUpdate(insertPayment);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (statement != null) {
					 statement.close();
			    }
				if (connection != null) {
					 connection.close();
			    }
			} catch (SQLException e) {
				System.out.println("Problems with closing connection...");
			}
		}
	}
	
	@Override
	public List<Payment> getAll() {
		String selectPaymentFilds = "SELECT project_id, user_name, creditCardNumber, donating_sum from payments";
		List<Payment> payments = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectPaymentFilds);
			
			 while (resultSet.next()) {
			        int projectID = resultSet.getInt("project_id");
			        String userName = resultSet.getString("user_name");
			        long creditCardNumber = resultSet.getLong("creditCardNumber");
			        int donatingSum = resultSet.getInt("donating_sum");
			        
			        Payment payment = new Payment(userName, creditCardNumber, donatingSum);
			        payment.setProjectID(projectID);
			        payments.add(payment);
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (statement != null) {
					 statement.close();
			    }
				if (connection != null) {
					 connection.close();
			    }
			} catch (SQLException e) {
				System.out.println("Problems with closing connection...");
			}
		}
		return payments;
	}

	@Override
	public int getSize() {
		String selectCountPayments = "SELECT count(*) from payments";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		int amountOfPayments = 0;
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectCountPayments);

			while (resultSet.next()) {
				amountOfPayments = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (statement != null) {
					 statement.close();
			    }
				if (connection != null) {
					 connection.close();
			    }
			} catch (SQLException e) {
				System.out.println("Problems with closing connection...");
			}
		}
		return amountOfPayments;
	}

	@Override
	public int getSumProjectPayments(Project project) {
		String selectPaymentFilds = "SELECT donating_sum from payments WHERE project_id = " + project.getUniqueID();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		int overalDonatingSum = 0; 
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectPaymentFilds);
			
			 while (resultSet.next()) {
				 int donatingSum = resultSet.getInt("donating_sum");
				 overalDonatingSum += donatingSum;
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (statement != null) {
					 statement.close();
			    }
				if (connection != null) {
					 connection.close();
			    }
			} catch (SQLException e) {
				System.out.println("Problems with closing connection...");
			}
		}
		return overalDonatingSum;
	}
	
	@Override
	public void remove(Payment payment) {
		// TODO Auto-generated method stub
	}
}
