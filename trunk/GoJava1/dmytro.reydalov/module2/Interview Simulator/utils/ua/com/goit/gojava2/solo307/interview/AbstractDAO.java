package ua.com.goit.gojava2.solo307.interview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	
	public Connection makeConnection() throws InterviewSimulatorException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new InterviewSimulatorException(
					"init JDBC driver was failed :-(");
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/interview_db",
					"postgres", "svd555");
		} catch (SQLException e) {
			throw new InterviewSimulatorException(
					"Connection to db was faild:-(");
		}
		return conn;
	}
	
	public Statement getStatement(Connection conn)
			throws InterviewSimulatorException {
		Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			throw new InterviewSimulatorException(
					"Creating statement was failed:-(");
		}
		return statement;
	}
	
}
