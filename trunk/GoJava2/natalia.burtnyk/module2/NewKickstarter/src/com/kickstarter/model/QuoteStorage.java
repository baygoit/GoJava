package com.kickstarter.model;
import java.util.ArrayList;
import java.util.List;

public class QuoteStorage {
	
	private List<String> quotes;
	
	public QuoteStorage() {
		quotes = new ArrayList<String>();
	}
	
	public void addQuote(String quote) {
		quotes.add(quote);
	}
		
	public String getRundomQuote() {
		int i = (int)(Math.random() * quotes.size());
		return quotes.get(i);
	}

}