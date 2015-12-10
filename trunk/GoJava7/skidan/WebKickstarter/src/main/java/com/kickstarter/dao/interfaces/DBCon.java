package com.kickstarter.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;
//import org.apache.tomcat.jdbc.pool.DataSource;

public class DBCon {
	private String url = "jdbc:mysql://localhost:3306/kickstarter";
	private String user = "root";
	private String password = "12345";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() {
		BasicDataSource datasource = null;
		try {
			// Class.forName("org.apache.commons.dbcp2.BasicDataSource");
			Class.forName("com.mysql.jdbc.Driver");
			datasource = new BasicDataSource();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		Connection conection = null;

		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl(url);
		datasource.setUsername(user);
		datasource.setPassword(password);
		try {
			conection = datasource.getConnection();
		} catch (SQLException e) {
			System.out.println("Connection problem " + e.getMessage());
		}
		return conection;
	}
}