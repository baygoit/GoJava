package com.kickstarter.model;

import java.util.ArrayList;
import java.util.Random;

public class QuotesStorage {

	private Random random;

	public QuotesStorage(Random random) {
		this.random = random;
	}

	public String getRundomQuote() {
		ArrayList<String> quotes = new ArrayList<String>();
		quotes.add("Lost time is never found again.\"");
		quotes.add("The future belongs to those, who believe of their dreams.\"");
		quotes.add("If you never try you'll never know.\"");
		quotes.add("The only way to do great work, is to love what you do.\"");
		quotes.add("Every thing is easy, when you are crazy and nothing is easy when you are lazy.\"");
		quotes.add("An investment in knowledge always pays the best interest.\"");
		quotes.add("It does not matter how slowly you go so long as you do not stop.\"");
		quotes.add("Money spent on the brain, is never spent in vain.\"");

		int index = random.nextInt(quotes.size());
		return quotes.get(index);
	}

}