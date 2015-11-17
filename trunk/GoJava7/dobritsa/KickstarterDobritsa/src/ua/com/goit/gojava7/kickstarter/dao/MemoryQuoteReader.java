package ua.com.goit.gojava7.kickstarter.dao;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class MemoryQuoteReader implements QuoteReader {

	@Override
	public List<Quote> readQuotes() {
		List<Quote> quotes = new ArrayList<>();

		quotes.add(new Quote(
				"(Memory) There is only one boss. The customer. And he can fire everybody in the company "
				+ "from the chairman on down, simply by  spending his money somewhere else.",
				"_Sam Walton"));
		quotes.add(new Quote("(Memory) Ideas pull the trigger, but instinct loads the gun.", "Don Marquis"));
		quotes.add(new Quote("(Memory) There are no secrets to success. It is the result of preparation, "
				+ "hard work, and learning from failure.", "Colin Powell"));
		quotes.add(new Quote("Happiness does not come from doing easy work but from the afterglow "
				+ "of satisfaction that comes after the achievement of a difficult task that demanded our best.", 
				"(Memory) Theodore Isaac Rubin"));
		return quotes;
	}

}
