package kickstarter.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kickstarter.entities.Quote;


public class QuotesRepository {
	List<Quote> quotes;

	public QuotesRepository() {
		quotes = new ArrayList<Quote>();
		Quote quote = new Quote();
		quote.setQuote("Explore projects, everywhere");
		quotes.add(quote);

		quote = new Quote();
		quote.setQuote("'To be is to do'—Socrates. 'To do is to be'—Jean-Paul Sartre. 'Do be do be do'—Frank Sinatra");
		quotes.add(quote);

	}
	public Quote getRandomQuote(){
		return quotes.get(new Random().nextInt(quotes.size()));
	}

}
