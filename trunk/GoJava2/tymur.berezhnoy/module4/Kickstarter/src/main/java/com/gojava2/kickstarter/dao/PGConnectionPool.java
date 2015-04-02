package com.gojava2.kickstarter.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.ds.PGPoolingDataSource;

public class PGConnectionPool {
	
	private PGPoolingDataSource connections;

	public PGConnectionPool(String host, String database, String user, String password) {
		connections = new PGPoolingDataSource();
//		connections.setDataSourceName("deca");
		connections.setServerName(host);
		connections.setDatabaseName(database);
		connections.setUser(user);
		connections.setPassword(password);
		connections.setMaxConnections(20);
		connections.setInitialConnections(20);
	}

	public Connection getConnection() throws SQLException {
		return connections.getConnection();
	}

	public void putConnection(Connection connection) throws SQLException {
		connection.close();
	}
}