package com.go_java4.alex_mirn.dao;

import java.sql.SQLException;

import com.go_java4.alex_mirn.data.Quote;

public interface QuotesDao {
	void add(Quote quote) throws SQLException;

	Quote getRandomQuote() throws SQLException;

	void createTableQuotes() throws SQLException;
}
