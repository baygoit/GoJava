package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteDaoMemoryImpl implements QuoteDao {
	private List<Quote> quotes = new ArrayList<>();
	private Random random;
	
	public QuoteDaoMemoryImpl(Random random) {
		setRandom(random);
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
	
	@Override
	public Quote getRandomQuote() {
		
		quotes.add(new Quote(
				"Your work is going to fill a large part of your life,"
						+ " and the only way to be truly satisfied is to do what"
						+ " you believe is great work. And the only way to do"
						+ " great work is to love what you do. If you haven't"
						+ " found it yet, keep looking. Don't settle. As with"
						+ " all matters of the heart, you'll know when you"
						+ " find it.", "Steve Jobs"));
		quotes.add(new Quote(
				"Innovation distinguishes between a leader and a follower.",
				"Steve Jobs"));
		
		int randomNumber = random.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}


}
