package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotGetDataException;
import kickstarter.model.engine.Quote;
import kickstarter.model.storage.Storage;

public class QuoteModel implements Model {
	private Storage storage;

	public QuoteModel(Storage storage) {
		this.storage = storage;
	}

	@Override
	public List<String> getData() throws CannotGetDataException {
		List<String> result = new ArrayList<>();

		Quote quote = storage.getRandomQuote();
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
	public List<Object> getParameters(int item) {
		return null;
	}
}
