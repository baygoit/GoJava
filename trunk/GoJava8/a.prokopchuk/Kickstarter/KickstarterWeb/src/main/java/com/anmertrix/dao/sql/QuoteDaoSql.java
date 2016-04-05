package com.anmertrix.dao.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.anmertrix.ConnectionManager;
import com.anmertrix.dao.DaoException;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Quote;

public class QuoteDaoSql implements QuoteDao {

	private ConnectionManager connectionManager;

	public QuoteDaoSql(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	public Quote getRandomQuote() {
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet rs = statement.executeQuery("SELECT author, text FROM quote order by rand() limit 1");
			rs.next();
			String author = rs.getString("author");
			String text = rs.getString("text");
			return new Quote(author, text);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
