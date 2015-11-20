package ua.com.goit.gojava7.kikstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuotesStorage {

	private static final Random RANDOM = new Random();
	public static List<Quote> quoteslist = new ArrayList<>();

	public void addQuote(Quote qoute) {
		quoteslist.add(qoute);
	}

	public Quote getQuote(int index) {
		return quoteslist.get(index - 1);
	}

	public List<Quote> getAllQuotes() {
		return quoteslist;
	}

	// method outputs one random quote
	public Quote getRandomQuote() {
		int ranodom = RANDOM.nextInt(quoteslist.size());
		return quoteslist.get(ranodom);
	}
}
