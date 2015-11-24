package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.dao.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteMemoryDao extends MemoryDao<Quote> implements QuoteStorage {
	private Random random;

	public QuoteMemoryDao(List<Quote> data) {
		super(data);
	}

	@Override
	public Quote getRandomQuote() {
		System.out.println(data.size());
		int randomNumber = random.nextInt(data.size());
		return data.get(randomNumber);
	}

}
