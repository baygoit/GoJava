package goit.nz.kickstarter.model;

import goit.nz.kickstarter.dao.Quote;
import goit.nz.kickstarter.dao.QuoteList;

import java.util.HashMap;
import java.util.Map;

public class QuoteModel extends Model {
	private QuoteList quotes;
	
	public QuoteModel(String type, QuoteList quotes, String name) {
		super(type, name);
		this.quotes = quotes;
	}
	
	@Override
	public int size() {
		return 1;
	}

	@Override
	public Map<Integer, Map<String, String>> getData() {
		Map<Integer, Map<String, String>> result = new HashMap<Integer, Map<String, String>>();
		Map<String, String> info = new HashMap<String, String>();
		Quote random = quotes.getRandomQuotation();
		info.put(random.getText(), random.getAuthor());
		result.put(size(), info);
		return result;
	}

}
