package ua.com.goit.gojava2.vova.kickstarter.presenter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectToDB {
	
	private final String PASS_DB = "7575";
	private final String NAME_DB = "postgres";
	private final String JDBC_POSTGRESQL_PATH = "jdbc:postgresql://127.0.0.1:5432/kickstarter";
	private Connection connection;
	
    public Connection createStatement(){
    	Connection connection = null;
    	try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
        } catch (Exception ex) {
	        Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
	    }
    	return connection;
    }
    
    public void closeStatement(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
