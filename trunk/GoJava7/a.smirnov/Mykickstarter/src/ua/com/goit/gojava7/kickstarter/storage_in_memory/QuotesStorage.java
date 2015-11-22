package ua.com.goit.gojava7.kickstarter.storage_in_memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;

public class QuotesStorage implements QuoteDAO {
	
	private static final Random RANDOM = new Random();
	private List<Quote> quotes = new ArrayList<>();
	
	public QuotesStorage() {
		
		Quote quote1 = new Quote("Liberty will not descend to a people, a people must "
				+ "raise themselves to liberty; it is a blessing that must " 
				+ "be earned before it can be enjoyed.", "B. Franklin");

		Quote quote2 = new Quote("Government's first duty is to protect the people, not " 
				+ "run their lives.", "Ronald Reagan");

		Quote quote3 = new Quote("The most terrifying words in the English language are: "
				+ "I'm from the government and I'm here to help.", "Ronald Reagan");

		add(quote1);
		add(quote2);
		add(quote3);
	}

	@Override
	public void add(Quote quote) {
		quotes.add(quote);
	}

	@Override
	public void remove(Quote quote) {
		quotes.remove(quote);
	}

	@Override
	public List<Quote> getAll() {
		return quotes;
	}

	@Override
	public int getSize() {
		return quotes.size();
	}
	
	@Override
	public Quote getRandomQuote() {		
		int randomNumber = RANDOM.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}
}
