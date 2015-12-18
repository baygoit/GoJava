package ua.com.goit.gojava7.kickstarter.DAO.dbStorage.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class JdbcDispatcher {
	
	
	private BasicDataSource bds;

	public JdbcDispatcher(String driver, String url, String user, String password, int size) {
		try {
			Class.forName(driver);
			bds = new BasicDataSource();
			bds.setDriverClassName(driver);
			bds.setUrl(url);
			bds.setUsername(user);
			bds.setPassword(password);
			bds.setInitialSize(size);
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

//	public void close() {
//    	try {
//    		if (bds != null && !bds.isClosed()) {
//    			bds.close();
//			}			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
}

