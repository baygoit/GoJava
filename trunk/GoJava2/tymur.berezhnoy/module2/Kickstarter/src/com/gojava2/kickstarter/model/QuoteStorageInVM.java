package com.gojava2.kickstarter.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteStorageInVM {
	
	private List<Quote> quotations;
	private Random random;
	
	public QuoteStorageInVM(Random random) {
		quotations = new ArrayList<Quote>();
		this.random = random;
	}
	
	public void addQuote(Quote quote) {
		quotations.add(quote);
	}
	
	public Quote getRandomQuote() {
		int randomInex = random.nextInt(quotations.size());
        return quotations.get((randomInex));
	}
}