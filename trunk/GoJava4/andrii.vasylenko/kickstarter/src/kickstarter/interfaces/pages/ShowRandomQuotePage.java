package kickstarter.interfaces.pages;

import java.util.Random;

import kickstarter.engine.Quote;
import kickstarter.storages.QuotesStorage;

public class ShowRandomQuotePage implements Page {

	private QuotesStorage quotes;

	public ShowRandomQuotePage(QuotesStorage quotes) {
		this.quotes = quotes;
	}

	@Override
	public String getHead() {
		return "Quote:";
	}

	@Override
	public String getBody() {
		Quote randomQuote = getRandom();
		if (randomQuote == null) {
			return "";
		}
		return randomQuote.getQuote();
	}

	private Quote getRandom() {
		if (quotes.isEmpty()) {
			return null;
		}
		int randomIndex = new Random().nextInt(quotes.size());
		return quotes.get(randomIndex);
	}

}
