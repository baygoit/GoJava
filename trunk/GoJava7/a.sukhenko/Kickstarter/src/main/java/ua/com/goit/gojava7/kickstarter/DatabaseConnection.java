package ua.com.goit.gojava7.kickstarter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void connect() {
		try {
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gojava7?user=Java7&password=superpass");
			if (connection.isValid(1000)) {
				System.out.println("Connection established.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public static void main(String[] args) {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		databaseConnection.connect();
	}

}
