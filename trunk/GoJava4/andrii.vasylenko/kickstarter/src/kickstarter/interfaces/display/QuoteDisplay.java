package kickstarter.interfaces.display;

import kickstarter.engine.Quote;

public class QuoteDisplay implements Display<Quote> {
	@Override
	public String getDescription(Quote quote) {
		if (quote == null) {
			return "";
		}
		
		return "Quote:" + quote.getQuote();
	}
}
