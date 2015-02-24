package com.gojava2.kickstarter.model;
import java.util.ArrayList;
import java.util.List;

public class QuoteStorageInVM {
	
	private List<Quote> quotations;

	public QuoteStorageInVM() {
		quotations = new ArrayList<Quote>();
	}
	
	public void addQuote(Quote quote) {
		quotations.add(quote);
	}
	
	public Quote getRandomQuote() {
		int randomInex = (int)(Math.random() * quotations.size());
        return quotations.get((randomInex));
	}
}