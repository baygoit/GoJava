package ua.nenya.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {

	private Connection connection;
 
	private void openConnection(){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
            try {
                Context context = new InitialContext();
                DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Kickstarter");
                //DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/yehifwbp");
                connection = dataSource.getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
	}

	public synchronized Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			openConnection();
		}
		return connection;
	}

}
