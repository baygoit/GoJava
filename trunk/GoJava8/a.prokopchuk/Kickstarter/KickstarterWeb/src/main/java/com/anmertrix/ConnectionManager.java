package com.anmertrix;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {
	
	public Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:comp/env");
			DataSource dataSource = (DataSource) envCtx.lookup("jdbc/KickstarterDS");
			connection = dataSource.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return connection;
    }
}
