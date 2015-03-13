package ua.com.goit.gojava.andriidnikitin.util;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

public class ErrorLogger {
	public static void logSQLException (SQLException exception, String interruptedActionDescription, Logger log) {
		log.error("SQLException was occured while " +  interruptedActionDescription);
		log.error("Message:" + exception.getMessage());
		log.error("SQL state: " + exception.getSQLState());
	}

	public static void logNamingException(NamingException exception,
			String interruptedActionDescription, Logger log) {
		log.error("NamingException was occured while " +  interruptedActionDescription);
		log.error("Message:" + exception.getMessage());
		log.error("Reason: " + exception.getExplanation());
	}

	public static void logClassNotFoundException(ClassNotFoundException exception,
			String interruptedActionDescription, Logger log) {
		log.error("NamingException was occured while " +  interruptedActionDescription);
		log.error("Message:" + exception.getMessage());
	}

	public static void logException(Exception exception, Logger log) {
		log.error("Message:" + exception.getMessage());
	}
}
