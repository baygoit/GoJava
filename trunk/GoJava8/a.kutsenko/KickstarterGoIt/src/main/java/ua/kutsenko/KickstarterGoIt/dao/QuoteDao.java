package ua.kutsenko.KickstarterGoIt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.kutsenko.KickstarterGoIt.domain.Quote;

public abstract class QuoteDao {
	protected List<Quote> quotes = new ArrayList<Quote>();

	public String getQuote() {
		Random random = new Random();
		int quoteId = random.nextInt(quotes.size());
		StringBuilder sb = new StringBuilder();
		sb.append(quotes.get(quoteId).getText()+ " ");
		sb.append("(c)" + quotes.get(quoteId).getAuthor());
		String result = sb.toString();
		return result;
		
	}
	public String getQuote(Quote quote){
		StringBuilder sb = new StringBuilder();
		sb.append(quote.getText());
		sb.append(" . " + quote.getAuthor());
		String result = sb.toString();
		return result;
		
	}
	

	public abstract void fillQuotes();
}
