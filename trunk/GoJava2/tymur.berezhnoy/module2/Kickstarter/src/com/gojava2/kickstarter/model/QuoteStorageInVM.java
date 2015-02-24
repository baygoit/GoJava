package com.gojava2.kickstarter.model;
import java.util.ArrayList;
import java.util.List;

public class QuoteStorageInVM {
	
	private List<Quote> quotations;

	public QuoteStorageInVM() {
		quotations = new ArrayList<Quote>();
		quotations.add(new Quote("Sometimes when you innovate, you make mistakes."
				+ "\n It is best to admit them quickly, and get on with\n improving your other innovations.", "Steve Jobs"));
		quotations.add(new Quote("The common question that gets asked in business is, 'why?'."
				+ "\n That's a good question, but an equally valid question is, 'why not?'", "Jeff Bezos"));
		quotations.add(new Quote("If there is anything that a man can do well,\n I say let him do it. Give him a chance.", "Abraham Lincoln"));
		quotations.add(new Quote("Great leaders, like Steve Jobs or Jeff Bezos, also focused on the long term.", "Reed Hastings"));
		quotations.add(new Quote("When you're curious, you find lots of interesting things to do.", "Walt Disney"));
	}
	
	public List<Quote> getQuotations() {
		return quotations;
	}
	
	public Quote getRandomQuote() {
		int randomInex = (int)(Math.random() * quotations.size());
        return quotations.get((randomInex));
	}
}