package ua.com.goit.gojava.m__jane.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ua.com.goit.gojava.m__jane.exceptions.TestingRuntimeException;

public class DBConnectionSystem {
	
	private static DBConnectionSystem instance;
		
	private DBConnectionSystem() {
	}


	public static synchronized DBConnectionSystem getInstance()
	{
		if (instance == null) {
			instance = new DBConnectionSystem();
		}
		return instance;
	}


	public synchronized Connection getConnection() {
		
		Connection connection = null;
		try {
			
			/*Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, 
			    "com.sun.jndi.rmi.registry.RegistryContextFactory");
			env.put(Context.PROVIDER_URL, "rmi://127.0.0.1:5432/testingDB");//jdbc:postgresql://127.0.0.1:5432/testingDB
			//rmi://127.0.0.1:5432/testingDB
			env.put(Context.SECURITY_PRINCIPAL, "postgres");
			env.put(Context.SECURITY_CREDENTIALS, "root");
			Context ctx = new InitialContext(env);*/	
			
			Context ctx = new InitialContext();	
			DataSource dataSource = (DataSource) ctx
					.lookup("java:/comp/env/jdbc/testingDB");
			connection = dataSource.getConnection();

		}
		catch (NamingException e) {
			throw new TestingRuntimeException("Can't open JNDI connection pool!");
			//TODO write to log
		}
		catch (SQLException e) {
			throw new TestingRuntimeException("Can't open connection to DB!");
			//TODO write to log
		}

		if (connection == null) {
			throw new TestingRuntimeException("Can't open JNDI connection pool!");
		}
		return connection;
	}
		
}
