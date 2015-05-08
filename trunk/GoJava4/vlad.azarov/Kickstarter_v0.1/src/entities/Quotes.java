package entities;

import java.util.Random;

public class Quotes {
	
	private String[] quotes;

	public Quotes(String[] quote) {
		this.quotes = quote;
		this.quotes.addQuote("Inspiring quote #1");
	}
	
	public void addQuote(String quote) {
		this.quotes[quotes.length()] = quote;
	}
	
	
	
	

	
}