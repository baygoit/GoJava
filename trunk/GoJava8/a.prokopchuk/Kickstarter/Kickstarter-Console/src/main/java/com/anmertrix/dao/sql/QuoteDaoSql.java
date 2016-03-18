package com.anmertrix.dao.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.anmertrix.ConnectionManager;
import com.anmertrix.dao.QuoteDao;

public class QuoteDaoSql extends QuoteDao {

	private ConnectionManager connectionManager;

	public QuoteDaoSql(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public void fillQuotes() {
		// no need
	}

	@Override
	public String getRandomQuote() {
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet rs = statement.executeQuery("SELECT author, text FROM quote order by rand() limit 1");
			rs.next();
			String author = rs.getString("author");
			String text = rs.getString("text");
			return text + " (" + author + ")";
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
