package DataContainers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Data.Quote;

public class QuotesContainer {
	private List<Quote> quotes;
	
	
	public QuotesContainer() {
		quotes = new ArrayList<Quote>();
	}
	
	public void add(Quote quote) {
		quotes.add(quote);
	}

	public Quote get(int index) throws IndexOutOfBoundsException {
		return quotes.get(index);
	}
	
	public int size() {
		return quotes.size();
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
	
	public boolean empty() {
		return quotes.isEmpty();
	}

}
