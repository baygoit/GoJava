package controller;
import java.sql.*;

import javax.management.RuntimeErrorException;

public class ConnectionToDB {
     
	private final String PASS_DB = "pass";
    private final String NAME_DB = "postgres";
    private final String JDBC_POSTGRESQL_PATH = "jdbc:postgresql://127.0.0.1/kickstarter";
    private Connection connection;
    
public Connection getConnection(){
    Connection connection = null;
    try {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
    } catch (Exception e) {
            new RuntimeException("Exception " + e);
        }
    return connection;
}
	
}
