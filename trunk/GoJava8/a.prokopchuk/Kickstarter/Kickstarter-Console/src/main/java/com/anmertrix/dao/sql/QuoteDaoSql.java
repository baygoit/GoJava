package com.anmertrix.dao.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Quote;

public class QuoteDaoSql extends DaoSql implements QuoteDao {

	public Quote getRandomQuote() {
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet rs = statement.executeQuery("SELECT author, text FROM quote order by rand() limit 1");
			rs.next();
			Quote quote = new Quote();
			quote.setAuthor(rs.getString("author"));
			quote.setQuoteText(rs.getString("text"));
			return quote;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}

}
