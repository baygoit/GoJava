package kickstarter.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import kickstarter.dao.defaultServices.DefaultQuoteService;

import org.junit.Test;

public class test_jdbc {
	public static final String URL = "jdbc:postgresql://localhost:5432/kickstarter";
	public static final String USER ="postgres";
	public static final String PASSWORD ="root";
	
	@Test
	public void test_create_table() {

		try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)) {
			Statement statement = connection.createStatement();
			statement.execute("create table categories (id SERIAL not null PRIMARY KEY, quote varchar(255))");
			//statement.execute("drop table quotes ");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	@Test
	public void test_insert(){
		try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)) {
			DefaultQuoteService quotes=new DefaultQuoteService();
            PreparedStatement statement = connection.prepareStatement("insert into quotes (quote) values(?)");
            statement.setString(1, quotes.getRandomQuote().getQuote());
            statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
