package kickstarter.repository;

import kickstarter.entities.Quote;


public class QuotesRepository {
	Storage<Quote> quotes;

	public QuotesRepository() {
		quotes = new EntityStorage<Quote>();
		Quote quote = new Quote();
		quote.setQuote("Explore projects, everywhere");
		quotes.add(quote);

		quote = new Quote();
		quote.setQuote("'To be is to do'—Socrates. 'To do is to be'—Jean-Paul Sartre. 'Do be do be do'—Frank Sinatra");
		quotes.add(quote);

	}
	public Quote getRandomQuote(){
		return quotes.getRandom();
	}
}
