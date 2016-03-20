package categories;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SqlDAO implements DAO {
	
Connection connection;
Statement statement;
Category kickstarter = new Category();

	@Override
	public Category loadBase() {
		try {
			connection = (Connection) DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/kickstarter?autoReconnect=true&useSSL=false",
							"root", "root");
			statement = (Statement) connection.createStatement();
			
			ResultSet result = statement
					.executeQuery("SELECT * FROM projects");
			
			while (result.next()) {
				Date date = Date.valueOf(result.getString("start"));
				Calendar start = new GregorianCalendar();
				start.setTime(date);
				
				kickstarter.category.add(new Project(result.getInt("id"),result.getString("name"), 
						result.getString("description"),result.getString("type"),
						result.getInt("needMoney"), start,result.getString("history"),
						result.getString("url")));
				
				kickstarter.saveComment(result.getInt("id"), new StringBuilder(result.getString("comments")));
				kickstarter.setCash(result.getInt("id"), result.getInt("haveMoney"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL problems");
		}
		return kickstarter;
	}

	@Override
	public void sendMoney(int id, int money, String card ) {
		
		try {
			connection = (Connection) DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/kickstarter?autoReconnect=true&useSSL=false",
							"root", "root");
		
		statement = (Statement) connection.createStatement();
		
		String archive = "insert into payment (time, payer, recipient, amount) values(now(), "+card+", "+id+", "+money+");";
		String transfer = "UPDATE projects SET haveMoney = haveMoney +"+money+" WHERE id= "+id+";";
		statement.executeUpdate(archive);
		statement.executeUpdate(transfer);
		connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL problems");
		}
	}

	@Override
	public void sendMassage(int id, String author, String text) {
		try {
			connection = (Connection) DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/kickstarter?autoReconnect=true&useSSL=false",
							"root", "root");
		
		statement = (Statement) connection.createStatement();
		
		String archive = "insert into comments (recipient, author, text, date) values("+id+", \""+author+"\", \""+text+"\", now());";
		String updateText = "\""+Project.FOR_GOOD_SAVING+author + ": `" + text+"`\"";
		String dialog = "UPDATE projects SET comments = CONCAT(comments, "+ updateText +")  WHERE id= "+id+";";
		statement.executeUpdate(archive);
		statement.executeUpdate(dialog);
		connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL problems");
		}
	}

}
