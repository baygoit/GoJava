package com.anmertrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteSource {
	
	List<Quote> quotes = new ArrayList<Quote>();
	
	public QuoteSource() {
		quotes.add(new Quote("Quote 1."));
		quotes.add(new Quote("Quote 2."));
		quotes.add(new Quote("Quote 3."));
		quotes.add(new Quote("Quote 4."));
		quotes.add(new Quote("Quote 5."));

	}
	
	public String getRandomQuote() {
		Random random = new Random();
		int randomNumber = random.nextInt(quotes.size());
		String quote = quotes.get(randomNumber).getQuoteText();
		return quote;
	}
	
}
