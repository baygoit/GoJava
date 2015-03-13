package ua.com.goit.gojava.solo307.interview.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ua.com.goit.gojava.solo307.interview.utils.InterviewSimulatorException;

public class ConnectorJDBC {

	private InitialContext initialContext;

	public ConnectorJDBC() throws InterviewSimulatorException {
		try {
			initialContext = new InitialContext();
			LoggerDAO.daoLogger.trace("Creating initial context was successfull");
		} catch (NamingException e) {
			LoggerDAO.daoLogger.error(e);
			throw new InterviewSimulatorException("Somesthing went wrong with creating InitialContext");
		}
	}

	public Connection openAccess() throws InterviewSimulatorException {
		Connection connection = null;
		Context context = null;
		try {
			context = (Context) initialContext.lookup("java:comp/env");
			DataSource dataSource = (DataSource) context.lookup("jdbc/root");
			connection = dataSource.getConnection();
			LoggerDAO.daoLogger.trace("Getting connection from dataSource was successfull");
		} catch (NamingException e) {
			LoggerDAO.daoLogger.error(e);
			throw new InterviewSimulatorException("Somesthing went wrong with lookup");
		} catch (SQLException e) {
			LoggerDAO.daoLogger.error(e);
			throw new InterviewSimulatorException("Somesthing went wrong with getting connection");
		}
		return connection;
	}
}
