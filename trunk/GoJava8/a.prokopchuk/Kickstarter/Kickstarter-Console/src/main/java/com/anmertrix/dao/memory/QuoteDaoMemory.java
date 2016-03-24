package com.anmertrix.dao.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.anmertrix.Quote;
import com.anmertrix.dao.QuoteDao;

public class QuoteDaoMemory implements QuoteDao {
	
	protected List<Quote> quotes = new ArrayList<Quote>();
	
	public QuoteDaoMemory() {
		quotes.add(new Quote("author1(Memory)", "Quote1"));
		quotes.add(new Quote("author2(Memory)", "Quote2"));
		quotes.add(new Quote("author3(Memory)", "Quote3"));
		quotes.add(new Quote("author4(Memory)", "Quote4"));
		quotes.add(new Quote("author5(Memory)", "Quote5"));
	}

	@Override
	public Quote getRandomQuote() {
		Random random = new Random();
		int randomNumber = random.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}
}