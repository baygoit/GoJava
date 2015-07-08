package goit.nz.kickstarter.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class QuoteList {
	private Map<Integer, Quote> indexedQuotes;

	public QuoteList() {
		indexedQuotes = new HashMap<Integer, Quote>();
	}

	public void add(Quote q) {
		int size = indexedQuotes.size() + 1;
		indexedQuotes.put(size, q);
	}

	public Quote getRandomQuotation() {
		Random generator = new Random();
		int size = indexedQuotes.size();
		Quote result = indexedQuotes.get(generator.nextInt(size) + 1);
		return result;
	}
}
