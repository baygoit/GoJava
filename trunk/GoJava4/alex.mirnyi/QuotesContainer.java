package Kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuotesContainer {
	private List<Quotes> quotes;
	private int index;
	private Quotes random;
	
	public QuotesContainer() {
		quotes = new ArrayList<Quotes>();
		defaultQuotes();
		this.index = new Random().nextInt(quotes.size());
		this.random = quotes.get(index);
	}
	
	public void defaultQuotes() {
		this.quotes.add(new Quotes("Just do it"));
		this.quotes.add(new Quotes("Impossible is nothing"));
//		this.quotes.add("Smile makes you better");
//		this.quotes.add("To be or not to be");
	}
	
	public void addQuote(Quotes quote) {
		this.quotes.add(quote);
	}

	public Quotes get(int index) throws IndexOutOfBoundsException {
		return quotes.get(index);
	}
	
	public int size() {
		return quotes.size();
	}
	

	public List<Quotes> getQuotes() {
		return quotes;
	}

	public Quotes getRandom() {
		return random;
	}

}
