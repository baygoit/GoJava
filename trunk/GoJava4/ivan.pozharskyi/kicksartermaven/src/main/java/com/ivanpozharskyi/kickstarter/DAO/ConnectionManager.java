package com.ivanpozharskyi.kickstarter.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String PASSWORD = "";
	private static final String USERNAME = "sa";
	private static String url = "jdbc:h2:~/kickstarter";
	private static Connection connection;
	public static Connection getConnection() {
		try{
			Class.forName("org.h2.Driver");
			try{
				connection = DriverManager.getConnection(url,USERNAME,PASSWORD);
			}catch(SQLException ex){
				System.out.println("Faild to create DB connection");
			}
		}catch(ClassNotFoundException ex){
			System.out.println("Driver not found");
		}
		return connection;
	}
}
