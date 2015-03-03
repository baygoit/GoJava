package com.goit.kickstarter.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KickstarterRunner {

	public static void main(String[] args){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/kickstarterdb", 
					"postgres",	"123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Kickstarter kickstarter = new Kickstarter(connection);
		kickstarter.run();
	}
}
