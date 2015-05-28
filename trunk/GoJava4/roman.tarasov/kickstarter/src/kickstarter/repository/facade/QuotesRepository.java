package kickstarter.repository.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kickstarter.entities.Quote;

public class QuotesRepository implements Serializable {

	private static final long serialVersionUID = 5350012877298043267L;

	ArrayList<Quote> quotes;

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotesToCopy) {
		quotes = new ArrayList<Quote>();
		for (Quote quote : quotesToCopy) {
			quotes.add(quote);
		}
	}
}