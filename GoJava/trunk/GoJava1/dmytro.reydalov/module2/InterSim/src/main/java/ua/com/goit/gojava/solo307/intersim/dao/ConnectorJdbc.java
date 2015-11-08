package ua.com.goit.gojava.solo307.intersim.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectorJdbc {

	private InitialContext initialContext;

	public ConnectorJdbc() throws InterviewSimulatorDaoException {
		try {
			initialContext = new InitialContext();
		} catch (NamingException e) {
			LoggerDao.daoLogger.error(e);
		}
	}

	public Connection openAccess() throws InterviewSimulatorDaoException {
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		try {
			context = (Context) initialContext.lookup("java:comp/env");
			dataSource = (DataSource) context.lookup("jdbc/root");
			connection = dataSource.getConnection();
		} catch (NamingException e) {
			LoggerDao.daoLogger.error(e);
		} catch (SQLException e) {
			LoggerDao.daoLogger.error(e);
		}
		return connection;
	}
}
