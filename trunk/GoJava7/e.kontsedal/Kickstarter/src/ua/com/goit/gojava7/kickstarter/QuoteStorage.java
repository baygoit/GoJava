package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteStorage {

	private static final Random RANDOM = new Random();
	private static final List<String> QUOTES = new ArrayList<>();
	{
		QUOTES.add("Your work is going to fill a large part of your life,"
				+ " and the only way to be truly satisfied is to do what"
				+ " you believe is great work. And the only way to do"
				+ " great work is to love what you do. If you haven't"
				+ " found it yet, keep looking. Don't settle. As with"
				+ " all matters of the heart, you'll know when you"
				+ " find it. Steve Jobs.");
		QUOTES.add("Innovation distinguishes between a leader and a follower. Steve Jobs.");
	}

	public String getRandomQuote() {

		int randomNumber = RANDOM.nextInt(QUOTES.size());
		return QUOTES.get(randomNumber);
	}
}
