package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteMemoryDao extends MemoryDao<Quote> implements QuoteDao {
	private Random random;

	public QuoteMemoryDao(List<Quote> data) {
		super(data);
	}

	// TODO fix it
	@Override
	public Quote getRandomQuote() {
		int randomNumber = random.nextInt(this.size());
		return this.get(randomNumber);
	}
	
}
