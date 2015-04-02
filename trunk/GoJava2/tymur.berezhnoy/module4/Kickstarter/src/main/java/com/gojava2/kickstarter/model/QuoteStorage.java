package com.gojava2.kickstarter.model;

public interface QuoteStorage {
	void add(Quote quote);
	Quote getRandomQuote();
	int getSize();
}