package kickstarter.dao.defaultServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kickstarter.dao.interfaces.iQuoteService;
import kickstarter.entity.Quote;

public class DefaultQuoteService implements iQuoteService {
	List<Quote> quotes;

	public DefaultQuoteService() {
		quotes = new ArrayList<Quote>();
		Quote quote = new Quote();
		quote.setID(1);
		quote.setQuote("Explore iprojects, everywhere");
		quotes.add(quote);

		quote = new Quote();
		quote.setID(2);
		quote.setQuote("'To be is to do'—Socrates. 'To do is to be'—Jean-Paul Sartre. 'Do be do be do'—Frank Sinatra");
		quotes.add(quote);
	}

	@Override
	public Quote getRandomQuote() {
		return quotes.get(new Random().nextInt(quotes.size()));
	}
}
