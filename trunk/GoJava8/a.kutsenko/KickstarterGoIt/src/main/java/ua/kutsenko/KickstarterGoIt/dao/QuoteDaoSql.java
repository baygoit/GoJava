package ua.kutsenko.KickstarterGoIt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.kutsenko.KickstarterGoIt.domain.Quote;

public class QuoteDaoSql extends QuoteDao {

	@Override
	public void fillQuotes() {
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://s14.thehost.com.ua:3306/kickstarterAlex?user=kickstarterAlex&password=kickstarterAlex&useSSL=true")) {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT id, author, text FROM quotes order by rand() limit 1");
			rs.next();
			String author = rs.getString("author");
			String text = rs.getString("text");
			quotes.add(new Quote(text ,author));
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}

	

}
