package Kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Quotes {
	private List<String> quotes = new ArrayList<String>();
	private int index;
	private String random;
	

	public Quotes() {
		this.quotes= quotes;
		defaultQuotes();
		this.index = new Random().nextInt(quotes.size());
		this.random = quotes.get(index);
	}
	
	public void defaultQuotes() {
		this.quotes.add("Just do it");
		this.quotes.add("Impossible is nothing");
		this.quotes.add("Smile makes you better");
		this.quotes.add("To be or not to be");
	}
	
	public void addQuote(String quote) {
		this.quotes.add(quote);
	}
	
	public List<String> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	public String getRandom() {
		return random;
	}

}