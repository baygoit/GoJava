package org.goJava2.kickstarter.model;
import java.util.ArrayList;
import java.util.List;

import org.goJava2.kickstarter.behavior.StorageBehavior;
import org.goJava2.kickstarter.content.Quote;

public class QuoteStorage implements StorageBehavior<Integer> {
	
	private List<Quote> listOfQuotes;
	
	/**
	 * The constructor for Hard-coded quotes.
	 */
	public QuoteStorage() {
		listOfQuotes = new ArrayList<Quote>();
		listOfQuotes.add(new Quote("Sometimes when you innovate, you make mistakes."
				+ "\n It is best to admit them quickly, and get on with\n improving your other innovations.", "Steve Jobs"));
		listOfQuotes.add(new Quote("The common question that gets asked in business is, 'why?'."
				+ "\n That's a good question, but an equally valid question is, 'why not?'", "Jeff Bezos"));
		listOfQuotes.add(new Quote("If there is anything that a man can do well,\n I say let him do it. Give him a chance.", "Abraham Lincoln"));
		listOfQuotes.add(new Quote("Great leaders, like Steve Jobs or Jeff Bezos, also focused on the long term.", "Reed Hastings"));
		listOfQuotes.add(new Quote("When you're curious, you find lots of interesting things to do.", "Walt Disney"));
	}
	
	/**
	 * The constructor for custom quotes.
	 * @param listOfQuotes
	 */
	public QuoteStorage(List<Quote> listOfQuotes) {
		this.listOfQuotes = listOfQuotes;
	}
	
	public QuoteStorage(String s) {
		
	}
	
	public Quote getRandomQuote() {
		int i = (int)(Math.random() * listOfQuotes.size());
		return listOfQuotes.get(i);
	}
	
	@Override
	public List<Quote> getContent() {
		return listOfQuotes;
	}
	
	@Override
	public Quote getSpecificContent(Integer i) {
		return listOfQuotes.get(i);
	}
}