package ua.com.gojava4.kickstarter.model.repositories;

import java.util.ArrayList;
import java.util.Random;

import ua.com.gojava4.kickstarter.entities.Quote;

public class QuotesRepository {
	private ArrayList<Quote> quotes;

	public QuotesRepository() {
		quotes = new ArrayList<>();
		initialize();
	}

	public Quote getRandomQuote() {
		int randomQuoteIndex = new Random().nextInt(quotes.size());
		return quotes.get(randomQuoteIndex);
	}

	public void add(Quote quote) {
		quotes.add(quote);
	}

	private void initialize() {
		add(new Quote(
				"Life isn't about finding yourself. Life is about creating yourself.",
				"\n(c)Author"));
		add(new Quote(
				"Start by doing what's necessary; then do what's possible and \nsuddenly you are doing the impossible.",
				"(c)Author"));
		add(new Quote(
				"You have to learn the rules of the game. And then you have to \nplay better than anyone else.",
				"(c)Author"));
		add(new Quote(
				"Perfection is not attainable, but if we chase perfection we can \ncatch excellence.",
				"(c)Author"));
		add(new Quote(
				"My favorite things in life don't cost any money. It's really clear\n that the most precious resource we all have is time.",
				"(c)Author"));
	}

}
