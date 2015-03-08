package ua.com.sas.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	
	private Connection connection;
	private String nameOfDB;
	private String login;
	private String password;
	
	public ConnectionDAO(String nameOfDB, String login, String password) {
		this.nameOfDB = nameOfDB;
		this.login = login;
		this.password = password;
		setConnection();
	}
	
	private void setConnection(){
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nameOfDB, login, password);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Smth wrong with driver, reinstall it", e);
		} catch (SQLException e) {
			throw new RuntimeException("Connection failed, check your connection parameters", e);
		}
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Can't close connection", e);
		}
	}
	
	public Connection getConnection(){
		return connection;
	}
	
}
