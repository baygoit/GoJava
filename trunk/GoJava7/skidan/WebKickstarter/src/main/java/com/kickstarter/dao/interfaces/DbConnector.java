package com.kickstarter.dao.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnector {

	String url = "jdbc:mysql://localhost:3306/kickstarter";
	String user = "root";
	String password = "12345";


	
	public Connection getConnection() {

		Connection conection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conection;
	}
}