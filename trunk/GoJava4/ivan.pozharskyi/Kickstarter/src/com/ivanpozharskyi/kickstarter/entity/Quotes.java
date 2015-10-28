package com.ivanpozharskyi.kickstarter.entity;

import java.sql.SQLException;

public interface Quotes {
	
	void addQuote(Quote quote) throws SQLException;
	int getSize() throws SQLException;
	Quote getRandom() throws SQLException;
}
