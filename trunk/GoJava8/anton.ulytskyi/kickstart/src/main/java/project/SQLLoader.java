package project;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SQLLoader {

	Connection connection;
	Statement statement;
	public BaseOfProjects kickstarter = new BaseOfProjects();

	public BaseOfProjects reload() throws ClassNotFoundException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager
					.getConnection(
							"jdbc:mysql://www.db4free.net:3306/kickbase?autoReconnect=true&useSSL=false",
							"author", "xzxzzxzxcaa");
			statement = (Statement) connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM projects");

			while (result.next()) {
				Date date = result.getDate("start");
				Calendar start = new GregorianCalendar();
				start.setTime(date);
				kickstarter.projects.add(new Project(result.getInt("id"),
						result.getString("name"), result.getString("category"),
						0, result.getInt("need_money"), start, "", result
								.getString("story"), result.getString("url")));
			}
			result.close();
			fillAmount(connection, statement);
			fillComments(connection, statement);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL problems");
		}
		return kickstarter;
	}

	private void fillComments(Connection connection2, Statement statement2) {

		ResultSet questions;
		try {
			for (Project project : kickstarter.projects) {
				StringBuilder sb = new StringBuilder();
				questions = statement
						.executeQuery("SELECT `author`, `text` FROM `comments` WHERE id = "
								+ project.getId());
				while (questions.next()) {

					sb.append(questions.getString("author") + ": "
							+ questions.getString("text")
							+ "<br />");

				}
				if (questions != null) {
					project.setComments(sb.toString());
				}

				questions.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void fillAmount(Connection connection, Statement statement) {

		ResultSet sum;
		try {
			for (Project project : kickstarter.projects) {

				sum = statement
						.executeQuery("SELECT SUM(amount) FROM accounting WHERE id = "
								+ project.getId());
				sum.next();
				String money = sum.getString(1);
				if (money != null) {
					project.setHaveMoney(Integer.parseInt(money));
				}
				sum.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public List<String> getCategories() throws ClassNotFoundException{
		List<String> categories = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager
					.getConnection(
							"jdbc:mysql://www.db4free.net:3306/kickbase?autoReconnect=true&useSSL=false",
							"author", "xzxzzxzxcaa");
			statement = (Statement) connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM categories");

			while (result.next()) {
			categories.add(result.getString("category"));
			}
			result.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL problems");
		}
		return categories;
	}

	}

