package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DAOManager {

	public void invest(int amount, int id) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = (Connection) DriverManager
				.getConnection(
						"jdbc:mysql://www.db4free.net:3306/kickbase?autoReconnect=true&useSSL=false",
						"author", "xzxzzxzxcaa");
				Statement statement = (Statement) connection.createStatement()) {
			String archive = "INSERT INTO `accounting`( `date`, `id`, `amount`) VALUES (now(),"
					+ id + "," + amount + ")";
			statement.executeUpdate(archive);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void say(int id, String author, String text)
			throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = (Connection) DriverManager
				.getConnection(
						"jdbc:mysql://www.db4free.net:3306/kickbase?autoReconnect=true&useSSL=false",
						"author", "xzxzzxzxcaa");
				Statement statement = (Statement) connection.createStatement()) {
			String archive = "INSERT INTO `comments`(`id`, `date`, `author`, `text`) VALUES ("
					+ id + ", now(), '" + author + "', '" + text + "');";
			statement.executeUpdate(archive);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
