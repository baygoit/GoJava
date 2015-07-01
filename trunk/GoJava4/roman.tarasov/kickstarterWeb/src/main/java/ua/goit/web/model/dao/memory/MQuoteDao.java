package ua.goit.web.model.dao.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.goit.web.model.dao.Quote;


public class MQuoteDao  {
	List<Quote> quotes;
	
	public MQuoteDao() {
		quotes = new ArrayList<Quote>();
		Quote quote = new Quote();
		quote.setID(8);
		quote.setQuote("Explore projects, everywhere.");
		quotes.add(quote);

		quote = new Quote();
		quote.setID(4);
		quote.setQuote("Each and every Kickstarter project is the independent creation of someone like you");
		quotes.add(quote);
	}

	public Quote getRandomQuote() {
		return quotes.get(new Random().nextInt(quotes.size()));
	}
}
