package com.kickstarter.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBCon {
	String url = "jdbc:mysql://localhost:3306/kickstarter";
	String user = "root";
	String password = "12345";

	public Connection getConnection() {
		try {
			Class.forName("org.apache.commons.dbcp2.BasicDataSource");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
		
			e1.printStackTrace();
		}

		Connection conection = null;
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl(url);
		datasource.setUsername(user);
		datasource.setPassword(password);
		try {
			conection = datasource.getConnection();
		} catch (SQLException e ){

			e.printStackTrace();
		}
		return conection;
	}
}