package com.anmertrix.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.DaoException;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Quote;

@Repository
public class QuoteDaoSql implements QuoteDao {

	private static final String SELECT_QUOTE = "SELECT author, text FROM quote order by rand() limit 1";

	@Autowired
	private DataSource dataSource;

	public Quote getRandomQuote() {
		try (Connection connection = dataSource.getConnection(); 
				PreparedStatement statement = connection.prepareStatement(SELECT_QUOTE)) {
			ResultSet rs = statement.executeQuery();
			rs.next();
			String author = rs.getString("author");
			String text = rs.getString("text");
			Quote quote = new Quote();
			quote.setAuthor(author);
			quote.setQuoteText(text);
			return quote;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
