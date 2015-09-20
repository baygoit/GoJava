package kickstarter.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.NoSuchDataException;
import kickstarter.model.dao.DAO;
import kickstarter.model.engine.Quote;

public class QuoteModel implements Model {
	private DAO dao;

	@Override
	public void init(DAO dao, List<Object> parameters) {
		this.dao = dao;
	}

	@Override
	public List<String> getData() throws NoSuchDataException, SQLException {
		List<String> result = new ArrayList<>();

		Quote quote = dao.getRandomQuote();
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
