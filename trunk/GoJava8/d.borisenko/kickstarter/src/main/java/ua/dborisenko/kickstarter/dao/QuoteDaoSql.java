package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.dborisenko.kickstarter.domain.Quote;

public class QuoteDaoSql extends QuoteDao {

	@Override
	public void fillQuotes() {
		// no need
	}

	@Override
	public Quote getRandomQuote() {
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://db4free.net:3306/gojava4omarchuk?user=gojava4omarchuk&password=somepassword&useSSL=true")) {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT id, author, text FROM quote order by rand() limit 1");
			rs.next();
			int id = rs.getInt("id");
			String author = rs.getString("author");
			String text = rs.getString("text");
			return new Quote(id, author, text);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
