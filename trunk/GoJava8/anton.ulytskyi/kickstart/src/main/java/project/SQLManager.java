package project;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SQLManager {
	
	Connection connection;
	Statement statement;
//	BaseOfProjects kickstarter = new BaseOfProjects();
	
	public void invest(int amount, int id) throws ClassNotFoundException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager
					.getConnection(
							"jdbc:mysql://www.db4free.net:3306/kickbase?autoReconnect=true&useSSL=false",
							"author", "xzxzzxzxcaa");

			statement = (Statement) connection.createStatement();

			String archive = "INSERT INTO `accounting`( `date`, `id`, `amount`) VALUES (now(),"+id+","+amount+")";
			statement.executeUpdate(archive);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL problems");
		}
	}
	public void say(int id, String author, String text) throws ClassNotFoundException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager
					.getConnection(
							"jdbc:mysql://www.db4free.net:3306/kickbase?autoReconnect=true&useSSL=false",
							"author", "xzxzzxzxcaa");

			statement = (Statement) connection.createStatement();

			String archive = "INSERT INTO `comments`(`id`, `date`, `author`, `text`) VALUES ("+id+", now(), '"+author+"', '"+text+"');";
			statement.executeUpdate(archive);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL problems");
		}
	}
	}
		
	


