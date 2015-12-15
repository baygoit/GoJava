package ua.com.goit.gojava7.kickstarter.dao.file;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.FileDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteFileDao extends FileDao<Quote> implements QuoteDao {

	public QuoteFileDao(List<Quote> data) {
		super(data);
	}
	
	@Override
	public Quote getRandomQuote() {
		// TODO Auto-generated method stub
		return null;
	}

}
