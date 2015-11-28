package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteMemoryDao extends MemoryDao<Quote> implements QuoteStorage {
	private Random random;

	//List<Quote> data = new ArrayList<>();
	public QuoteMemoryDao(List<Quote> data) {
		super(data);
	}

	@Override
	public Quote getRandomQuote() {
		int randomNumber = random.nextInt(data.size());
		return this.data.get(randomNumber);
	}
	
	//@Override
	//public Quote getRandomQuote() {
	//	int randomNumber = random.nextInt(quotes.size());
	//	return quotes.get(randomNumber);
	//}

}
