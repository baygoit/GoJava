package ua.com.goit.gojava7.kikstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kikstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kikstarter.dao.database.QuoteDaoDb;
import ua.com.goit.gojava7.kikstarter.domain.Quote;

public class QuoteDaoMemoryTest implements QuoteDao {

	private List<Quote> quotes = new ArrayList<>();

	public QuoteDaoMemoryTest() {
		MemoryQuoteReader memoryQuoteReader = new MemoryQuoteReader();
		quotes = memoryQuoteReader.readQuotes();
	}

	public Quote getQuote(int index) {
		return quotes.get(index - 1);
	}

	@Override
	public Quote getRandomQuote() {
		return quotes.get(new Random().nextInt(quotes.size()));
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

	public static void main(String[] args) {
		QuoteDaoMemoryTest quoteTest = new QuoteDaoMemoryTest();
		QuoteDaoDb quoteDaoDb = new QuoteDaoDb();
		quoteDaoDb.add(quoteTest.getQuote(1));
	}

}
