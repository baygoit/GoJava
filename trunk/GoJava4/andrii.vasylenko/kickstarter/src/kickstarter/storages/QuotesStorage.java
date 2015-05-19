package kickstarter.storages;

import kickstarter.engine.Quote;

public class QuotesStorage implements Storage<Quote> {
	private UniversalStorage<Quote> quotes = new UniversalStorage<Quote>();

	@Override
	public Quote get(int index) throws IndexOutOfBoundsException {
		return quotes.get(index);
	}

	@Override
	public void add(Quote quote) {
		quotes.add(quote);
	}

	@Override
	public int size() {
		return quotes.size();
	}

	@Override
	public boolean empty() {
		return quotes.empty();
	}

	@Override
	public Quote getById(int id) {
		return quotes.getById(id);
	}
}
