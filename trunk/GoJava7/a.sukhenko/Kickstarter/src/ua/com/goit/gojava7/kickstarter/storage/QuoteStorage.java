package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.model.Quote;

/**
 * @author Devian
 * @category Storage
 */
public class QuoteStorage {
	private List<Quote> quotes = new ArrayList<>();
	private static final Random rand = new Random();
	
	public Quote getRandomQuote(){
		int random = rand.nextInt(quotes.size());
		return quotes.get(random);
		
	}
	public void addQuote(Quote q){
		quotes.add(q);
	}
	
	/**
	 * @return Unmodifiable List of <b>Quote</b>s
	 */
	public List<Quote> getQuotes(){
		return Collections.unmodifiableList(quotes);
		
	}
	
}
