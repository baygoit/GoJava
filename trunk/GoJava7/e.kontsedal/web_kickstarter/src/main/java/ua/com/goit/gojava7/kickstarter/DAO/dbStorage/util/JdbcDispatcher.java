package ua.com.goit.gojava7.kickstarter.DAO.dbStorage.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class JdbcDispatcher {
	
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/kickstarter";
	private static final String DB_USER = "admin";
	private static final String DB_PASSWORD = "admin";
	private static final int CONN_POOL_SIZE = 5;

	private BasicDataSource bds;

	public JdbcDispatcher() {
		try {
			Class.forName(DRIVER_CLASS_NAME);
			bds = new BasicDataSource();
			bds.setDriverClassName(DRIVER_CLASS_NAME);
			bds.setUrl(DB_URL);
			bds.setUsername(DB_USER);
			bds.setPassword(DB_PASSWORD);
			bds.setInitialSize(CONN_POOL_SIZE);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
        Connection connection = bds.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }

	public void close() {
    	try {
    		if (bds != null && !bds.isClosed()) {
    			bds.close();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

