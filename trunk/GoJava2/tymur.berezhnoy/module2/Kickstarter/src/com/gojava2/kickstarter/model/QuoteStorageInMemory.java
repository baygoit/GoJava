package com.gojava2.kickstarter.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteStorageInMemory implements QuoteStorage {
	
	private List<Quote> quotations;
	private Random random;
	
	public QuoteStorageInMemory(Random random) {
		quotations = new ArrayList<Quote>();
		this.random = random;
	}
	
	@Override
	public void add(Quote quote) {
		quotations.add(quote);
	}
	
	@Override
	public Quote getRandomQuote() {
		int randomInex = random.nextInt(quotations.size());
        return quotations.get((randomInex));
	}
}