package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectToDB {
	
	private static final String PASS_DB = "7575";
	private static final String NAME_DB = "postgres";
	private static final String JDBC_POSTGRESQL_PATH = "jdbc:postgresql://127.0.0.1:5432/kickstarter";
	private static Connection connection = null;
	public static Statement statement;
	
    public static void createStatement(){
    	Connection connection = null;
    	try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            statement = connection.createStatement();
        } catch (Exception ex) {
	        Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
	    }
    }
    
    public static void closeStatement(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
