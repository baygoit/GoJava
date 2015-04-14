package ua.com.goit.gojava.andriidnikitin.MyShop.commons;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;


public class ErrorLogger {	
	

	public static void logSQLException (SQLException exception, 
			String interruptedActionDescription, Logger log) {
		StringBuilder error = new StringBuilder();
		error.append("SQLException was occured while " +  interruptedActionDescription);
		log.error(error, exception);
	}

	public static void logNamingException(NamingException exception,
			String interruptedActionDescription, Logger log) {
		StringBuilder error = new StringBuilder();
		error.append("NamingException was occured while " +  interruptedActionDescription);
		log.error(error, exception);
	}

	public static void logClassNotFoundException(ClassNotFoundException exception,
			String interruptedActionDescription, Logger log) {
		StringBuilder error = new StringBuilder();
		error.append("NamingException was occured while " +  interruptedActionDescription);
		log.error(error, exception);
	}

	public static void logException(Exception exception, Logger log) {
		log.error(exception);
	}

	public static void loggerNotProvided() {
		Logger root = Logger.getRootLogger();
		root.error(new NullPointerException("logger not provided"));
		
	}

	public static void loggerNotProvided(String string) {
		Logger root = Logger.getRootLogger();
		root.error(new NullPointerException("logger for " + string + " not provided"));
	}
}
