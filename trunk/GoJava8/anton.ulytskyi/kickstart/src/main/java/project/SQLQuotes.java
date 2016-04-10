package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLQuotes {

	 public String showQuote() {		
	    	try {
	   
	    		Class.forName("com.mysql.jdbc.Driver");
	    		Connection myConn = (Connection) DriverManager
						.getConnection(
								"jdbc:mysql://www.db4free.net:3306/kickbase?autoReconnect=true&useSSL=false",
								"author", "xzxzzxzxcaa");

				Statement myStmt = (Statement) myConn.createStatement();

				ResultSet myRs = myStmt
						.executeQuery("SELECT * FROM quotes ORDER BY RAND() limit 1");

				while (myRs.next()) {
					return myRs.getString("quotes");
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}

			return "Please call to Your developer";
		}
}
