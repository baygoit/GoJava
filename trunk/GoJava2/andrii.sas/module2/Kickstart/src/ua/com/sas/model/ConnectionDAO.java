package ua.com.sas.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	
	private Connection connection;
	private boolean end = false;

	public void setConnection(String nameOfDB, String login, String password){
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nameOfDB, login, password);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Smth wrong with driver, reinstall it", e);
		} catch (SQLException e) {
			throw new RuntimeException("Connection failed, check your connection parameters", e);
		} finally {
			try {
				if(end){
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("Can't close connection", e);
			}
		}
	}
	
	public Connection getConnection(){
		return connection;
	}
	
	public void setEnd(boolean end){
		this.end = end;
	}
}
