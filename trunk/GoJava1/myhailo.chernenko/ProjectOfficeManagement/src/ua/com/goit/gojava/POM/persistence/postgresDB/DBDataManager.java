package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelRuntimeException;

public class DBDataManager {
	
	/*static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new POMDataModelRuntimeException("Could not register DB driver: "+e.getMessage(), e);
		}
	}*/
	private static final Logger LOG=Logger.getLogger(DBDataManager.class);
	
	public static Connection getConnection() {

		Connection connection;
		
		try {
			 
			InitialContext cxt = new InitialContext();
			Context envContext = (Context) cxt.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/POMDataBase");
			connection = ds.getConnection();
			
		} catch (SQLException | NamingException e) {
 
			LOG.error("Could not create connection to DB: "+e.getMessage(), e);
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
