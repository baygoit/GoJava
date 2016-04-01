package com.anmertrix;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

// TODO it's integration test
public class ConnectionManagerTest {

	private ConnectionManager connectionManager = new ConnectionManager();

	@Test
	public void testGetConnection() throws SQLException {
		Connection connection = connectionManager.getConnection();
		assertThat(connection, notNullValue());
		assertThat(connection.isClosed(), is(false));
	}

	@Test
	public void testCloseConnection() throws SQLException {
		Connection connection = connectionManager.getConnection();
		connectionManager.closeConnection();
		assertThat(connection.isClosed(), is(true));
	}

	@Test
	public void testGetConnectionAfterClose() throws SQLException {
		Connection connection = connectionManager.getConnection();
		connectionManager.closeConnection();
		connection = connectionManager.getConnection();
		assertThat(connection, notNullValue());
		assertThat(connection.isClosed(), is(false));
	}
}
