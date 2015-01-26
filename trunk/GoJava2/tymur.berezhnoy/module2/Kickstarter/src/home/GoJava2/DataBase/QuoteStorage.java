package home.GoJava2.DataBase;
import home.GoJava2.Content.Quote;

import java.util.ArrayList;
import java.util.List;

public class QuoteStorage {
	private List<Quote> listOfQuotes;
	
	public QuoteStorage(List<Quote> listOfQuotes) {
		this.listOfQuotes = listOfQuotes;
		listOfQuotes.add(new Quote("Sometimes when you innovate, you make mistakes."
				+ "\n It is best to admit them quickly, and get on with\n improving your other innovations.", "Steve Jobs"));
		listOfQuotes.add(new Quote("The common question that gets asked in business is, 'why?'."
				+ "\n That's a good question, but an equally valid question is, 'why not?'", "Jeff Bezos"));
		listOfQuotes.add(new Quote("If there is anything that a man can do well,\n I say let him do it. Give him a chance.", "Abraham Lincoln"));
	}
	
	public void addQuoteToStorage(Quote quote) {
		listOfQuotes.add(quote);
	}
	
	public Quote getRandomQuote() {
		int i = (int)(Math.random() * listOfQuotes.size());
		return listOfQuotes.get(i);
	}
}