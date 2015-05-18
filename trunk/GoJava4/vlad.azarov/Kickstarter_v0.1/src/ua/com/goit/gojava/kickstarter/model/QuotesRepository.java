package ua.com.goit.gojava.kickstarter.model;

import java.util.ArrayList;
import java.util.Random;

public class QuotesRepository {
    private ArrayList<Quote> quotes;

    public QuotesRepository() {
	quotes = new ArrayList<>();
	
	add(new Quote(
		"Life isn't about finding yourself. Life is about creating yourself",
		"Unknown"));
	add(new Quote(
		"Start by doing what's necessary; then do what's possible and suddenly you are doing the impossible.)",
		"Unknown2"));
	add(new Quote(
		"You have to learn the rules of the game. And then you have to play better than anyone else",
		"Unknown2"));
	add(new Quote(
		"Perfection is not attainable, but if we chase perfection we can catch excellence",
		"Unknown3"));
	add(new Quote(
		"My favorite things in life don't cost any money. It's really clear that the most precious resource we all have is time.",
		"Unknown4"));
    }

    public Quote getRandomQuote() {
	int randomQuoteIndex = new Random().nextInt(quotes.size());
	return quotes.get(randomQuoteIndex);
    }

    public void add(Quote quote) {
	quotes.add(quote);
    }

}
