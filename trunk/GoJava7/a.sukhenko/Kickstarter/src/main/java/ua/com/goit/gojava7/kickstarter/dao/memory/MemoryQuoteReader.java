package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class MemoryQuoteReader {
	public List<Quote> readQuotes() {
		List<Quote> quotes = new ArrayList<Quote>();
		quotes.add(new Quote(QuoteStorage.QUOTE_BY_PRINCESS_DIANA, "Princess Diana"));
		quotes.add(new Quote(QuoteStorage.QUOTE_BY_MISHA_COLLINS, "Misha Collins"));
		return quotes;

	}
}
