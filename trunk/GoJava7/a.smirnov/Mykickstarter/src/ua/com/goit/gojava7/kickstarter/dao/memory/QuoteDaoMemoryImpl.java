package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.AbstractQuoteDao;

public class QuoteDaoMemoryImpl extends AbstractQuoteDao {
	private static final Random RANDOM = new Random();
	private List<Quote> quotes = new ArrayList<>();
	
	public QuoteDaoMemoryImpl() {
		Quote quote1 = new Quote();
		quote1.setQuoteText("Liberty will not descend to a people, a people must "
				+ "raise themselves to liberty; it is a blessing that must " 
				+ "be earned before it can be enjoyed.");
		quote1.setAuthor("B. Franklin");

		Quote quote2 = new Quote();
		quote2.setQuoteText("Government's first duty is to protect the people, not " 
				+ "run their lives.");
		quote2.setAuthor("R. Reagan");

		Quote quote3 = new Quote();
		quote3.setQuoteText("The most terrifying words in the English language are: "
				+ "I'm from the government and I'm here to help.");
		quote3.setAuthor("Ronald Reagan");

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
	public int getSize() {
		return quotes.size();
	}
	
	@Override
	public Quote getRandomQuote() {		
		int randomNumber = RANDOM.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}
}
