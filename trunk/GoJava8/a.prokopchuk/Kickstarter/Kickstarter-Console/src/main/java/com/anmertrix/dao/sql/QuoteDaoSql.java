package com.anmertrix.dao.sql;

import com.anmertrix.ManagementSystem;
import com.anmertrix.dao.QuoteDao;

public class QuoteDaoSql extends QuoteDao {
	
	@Override
	public void fillQuotes() {
		// no need
	}

	@Override
	public String getRandomQuote() {
		try {
			return ManagementSystem.getInstance().getRandomQuote();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}
