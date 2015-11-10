package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteStorage {

	private final Random RANDOM = new Random();
	private final List<String> QUOTES = new ArrayList<>();

	public void setQuote(String string) {
		this.QUOTES.add(string);
	}

	public String getRandomQuote() {
		int randomNumber = RANDOM.nextInt(QUOTES.size());
		return QUOTES.get(randomNumber);
	}
}