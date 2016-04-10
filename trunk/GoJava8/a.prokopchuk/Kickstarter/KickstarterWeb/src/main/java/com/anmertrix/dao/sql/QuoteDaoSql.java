package com.anmertrix.dao.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(SELECT_QUOTE);
			rs.next();
			String author = rs.getString("author");
			String text = rs.getString("text");
			return new Quote(author, text);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
