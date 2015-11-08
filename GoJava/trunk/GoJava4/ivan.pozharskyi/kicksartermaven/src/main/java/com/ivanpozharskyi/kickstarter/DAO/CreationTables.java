package com.ivanpozharskyi.kickstarter.DAO;

import java.sql.*;
public class CreationTables {
	private Connection con;
		
	
	public String createTable() throws ClassNotFoundException, SQLException{
		con = ConnectionManager.getConnection();
		Statement statement;
		statement = con.createStatement();
		statement.execute("CREATE TABLE IF NOT EXISTS projects (id int(20) AUTO_INCREMENT, "
				+ "name text,moneyGot int,moneyNeed int,daysLeft int,category int,PRIMARY KEY(id))");
		PreparedStatement preparedStatement;
		String query = "INSERT INTO projects (name, moneyGot, MoneyNeed, daysLeft, category)"
				+ "VALUES(?, ?, ?, ?, ?)";
	
		preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1," Project1_1");
		preparedStatement.setString(2, "1000");
		preparedStatement.setString(3, "200");
		preparedStatement.setString(4, "15");
		preparedStatement.setString(5, "1");
		preparedStatement.execute();
		
		ResultSet resultSet = statement.executeQuery("SELECT * FROM projects");
		StringBuilder result = new StringBuilder();
		while(resultSet.next()){
			 result.append( "id: "+ resultSet.getString("id")
					 + " name: " + resultSet.getString("name")
					 + "moneyGot: " + resultSet.getString("moneyGot")
					 + "moneyNeed: " + resultSet.getString("moneyNeed")
					 + "daysLeft: " + resultSet.getString("daysLeft")
					 + "category: " + resultSet.getString("category")
					 +"\n");
			
		}
		return result.toString();
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		CreationTables table = new CreationTables();
		
		
		
		System.out.println(table.createTable());
	}
}
