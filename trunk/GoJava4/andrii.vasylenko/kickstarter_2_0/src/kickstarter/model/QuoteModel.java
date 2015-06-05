package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotGetDataException;
import kickstarter.model.dao.QuotesDAO;
import kickstarter.model.engine.Quote;

public class QuoteModel implements Model {
	private QuotesDAO quotesDAO;

	public QuoteModel(QuotesDAO quotesDAO) {
		this.quotesDAO = quotesDAO;
	}

	@Override
	public List<String> getData() throws CannotGetDataException {
		List<String> result = new ArrayList<>();

		Quote quote = quotesDAO.getRandomQuote();
		if (quote != null) {
			result.add(quote.getQuote());
		}

		return result;
	}

	@Override
	public boolean showOnly() {
		return true;
	}

	@Override
	public List<Object> getParameters(int item, String input) {
		return null;
	}
}
