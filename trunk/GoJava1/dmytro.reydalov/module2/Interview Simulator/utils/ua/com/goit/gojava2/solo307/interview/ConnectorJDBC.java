package ua.com.goit.gojava2.solo307.interview;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectorJDBC {

	private InitialContext initialContext;

	public ConnectorJDBC() throws InterviewSimulatorException {
		try {
			initialContext = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException("Somesthing went wrong with creating InitialContext");
		}
	}

	public Connection openAccess() throws InterviewSimulatorException {
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		try {
			context = (Context) initialContext.lookup("java:comp/env");
			dataSource = (DataSource) context.lookup("jdbc/root");
			connection = dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException("Somesthing went wrong with lookup");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException("Somesthing went wrong with getting connection");
		}
		return connection;
	}
}
