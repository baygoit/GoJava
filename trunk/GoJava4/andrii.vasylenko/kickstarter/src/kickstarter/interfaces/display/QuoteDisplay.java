package kickstarter.interfaces.display;

import kickstarter.engine.Quote;

public class QuoteDisplay implements Display<Quote> {

	@Override
	public String getDescription(Quote quote) {
		return "Quote: " + quote.getQuote();
	}

	@Override
	public String getDetailedDescription(Quote quote) {
		return getDescription(quote);
	}

}
