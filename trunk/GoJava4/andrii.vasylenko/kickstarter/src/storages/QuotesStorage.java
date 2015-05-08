package storages;

import java.util.Random;

import kickstarter.data_types.Quote;

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
		throw new UnsupportedOperationException();
	}

	public Quote getRandom() throws IndexOutOfBoundsException {
		if (empty()) {
			throw new IndexOutOfBoundsException();
		}
		int randomIndex = getRandomIndex();
		return quotes.get(randomIndex);
	}

	private int getRandomIndex() {
		return new Random().nextInt(size());
	}
}
