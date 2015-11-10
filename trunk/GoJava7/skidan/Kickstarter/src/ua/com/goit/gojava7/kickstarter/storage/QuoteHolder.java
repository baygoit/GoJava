package ua.com.goit.gojava7.kickstarter.storage;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class QuoteHolder {
	Random random = new Random();
	 private List<String> quotes = new LinkedList<>();

	{

		quotes.add("To improve is to change; to be perfect is to change often. "
				+ " Winston_churchill");
		quotes.add("A pessimist sees the difficulty in every opportunity;"
				+ " an optimist sees the opportunity in every difficulty "
				+" Winston Churchill");
		quotes.add("Attitude is a little thing that makes a big difference. "
				+ " Winston Churchill");

	}

	public String getQuote() {

		return quotes.get((int) (Math.random() * quotes.size()));

	}

	public List<String> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
	
}