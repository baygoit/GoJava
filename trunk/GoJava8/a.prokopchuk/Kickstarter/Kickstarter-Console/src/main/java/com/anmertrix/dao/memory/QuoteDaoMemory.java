package com.anmertrix.dao.memory;

import com.anmertrix.Quote;
import com.anmertrix.dao.QuoteDao;

public class QuoteDaoMemory extends QuoteDao {
	
	public void fillQuotes() {
		quotes.add(new Quote("author1(Memory)", "Quote1"));
		quotes.add(new Quote("author2(Memory)", "Quote2"));
		quotes.add(new Quote("author3(Memory)", "Quote3"));
		quotes.add(new Quote("author4(Memory)", "Quote4"));
		quotes.add(new Quote("author5(Memory)", "Quote5"));
	}
}