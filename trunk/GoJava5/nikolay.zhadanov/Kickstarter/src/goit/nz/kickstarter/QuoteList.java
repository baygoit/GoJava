package goit.nz.kickstarter;

import java.util.ArrayList;
import java.util.Random;

public class QuoteList {
	private ArrayList<String> quotes;
	
	public QuoteList() {
		quotes = new ArrayList<String>();
	}
	
	public void add(String quote) {
		quotes.add(quote);
	}
	
	public String getRandomQuotation() {
		Random generator = new Random();
		int size = quotes.size();
		return quotes.get(generator.nextInt(size));
	}
}
