package com.anmertrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class QuoteDao {

	List<Quote> quotes = new ArrayList<Quote>();

	public String getRandomQuote() {
		Random random = new Random();
		int randomNumber = random.nextInt(quotes.size());
		String quote = quotes.get(randomNumber).getQuoteText() + "("
				+ quotes.get(randomNumber).getAuthor() + ")";
		return quote;
	}

	public void setQuote(Quote quote) {
		quotes.add(quote);
	}

	public abstract void fillQuotes();

}
