package com.anmertrix.dao.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Quote;

public class QuoteDaoMemory implements QuoteDao {
	
	protected List<Quote> quotes = new ArrayList<Quote>();
	
	@Override
	public Quote getRandomQuote() {
		Random random = new Random();
		int randomNumber = random.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}
	
	@Override
	public void initData() {
		Quote quote1 = new Quote();
		quote1.setAuthor("author1(Memory)");
		quote1.setQuoteText("Quote1");
		quotes.add(quote1);
		
		Quote quote2 = new Quote();
		quote2.setAuthor("author2(Memory)");
		quote2.setQuoteText("Quote2");
		quotes.add(quote2);
		
		Quote quote3 = new Quote();
		quote3.setAuthor("author3(Memory)");
		quote3.setQuoteText("Quote3");
		quotes.add(quote3);
		
		Quote quote4 = new Quote();
		quote4.setAuthor("author4(Memory)");
		quote4.setQuoteText("Quote4");
		quotes.add(quote4);
		
		Quote quote5 = new Quote();
		quote5.setAuthor("author5(Memory)");
		quote5.setQuoteText("Quote5");
		quotes.add(quote5);
	}
}