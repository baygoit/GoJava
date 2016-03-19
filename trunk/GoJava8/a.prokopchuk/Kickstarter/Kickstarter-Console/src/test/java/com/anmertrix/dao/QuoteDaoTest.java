package com.anmertrix.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.anmertrix.Quote;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.dao.file.QuoteDaoFile;

public class QuoteDaoTest {
	
	@Test
	public void setQuote() {
		QuoteDao quoteSource = new QuoteDaoFile();
		Quote quote = new Quote("author", "test");
		quoteSource.setQuote(quote);
		assertEquals("test (author)", quoteSource.getRandomQuote());
	}
}
