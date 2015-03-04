package ua.com.goit.gojava.POM.persistence;

import java.sql.*;



import java.sql.Statement;

import ua.com.goit.gojava.POM.dataModel.POMDataModelRuntimeException;

public class DBDataManager {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new POMDataModelRuntimeException("Could not register DB driver: "+e.getMessage(), e);
		}
	}
	
	private static String connectionString = "jdbc:postgresql://127.0.0.1:5432/POMDataBase";
	private static String user = "postgres";
	private static String password = "root";
	
	public static Connection getConnection() {

		Connection connection;
		
		try {
			 
			connection = DriverManager.getConnection(connectionString, user, password);
 
		} catch (SQLException e) {
 
			throw new POMDataModelRuntimeException("Could not create connection to DB: "+e.getMessage(), e);
 
		};
		
		return connection;
		
	}

	public static void CloseConnections(ResultSet rs, Statement statement, Connection connection) {
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
 
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
			}
		}
 
		if ( connection != null) {
			 try {
				connection.close();
			} catch (SQLException e) {
			}
		}
		
	}
}
