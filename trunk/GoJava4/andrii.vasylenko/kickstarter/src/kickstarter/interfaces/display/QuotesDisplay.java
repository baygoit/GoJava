package kickstarter.interfaces.display;

import kickstarter.engine.Quote;

public class QuotesDisplay extends AbstractDisplay<Quote> {
	@Override
	public String getView(Quote quote) {
		if (quote == null) {
			return "";
		}

		return quote.getQuote();
	}
}
