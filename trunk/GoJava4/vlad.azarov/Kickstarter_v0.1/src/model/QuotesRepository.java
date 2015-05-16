package model;

import java.util.ArrayList;
import java.util.Random;

public class QuotesRepository {
    ArrayList<Quote> quotes;

    public QuotesRepository() {
	quotes = new ArrayList<>();
	quotes.add(new Quote(
		"Start by doing what's necessary; then do what's possible and suddenly you a doing the impossible.",
		"Unknown"));
	quotes.add(new Quote(
		"Start by doing what's necessary; then do what's possible and suddenly you are doing the impossible.)",
		"Unknown2"));
	quotes.add(new Quote("Quotote#3", "Unknown2"));
    }


    // public Quote() {
    // quotes = new String[] {
    // "Start by doing what's necessary; then do what's possible and suddenly you are "
    // + "doing the impossible.",
    // "Perfection is not attainable, but if we chase perfection we can catch "
    // + "excellence.\"",
    // "\"My favorite things in life don't cost any money. It's really clear that the "
    // + "most precious resource we all have is time.\"",
    // "\"You have to learn the rules of the game. And then you have\nto play better than "
    // + "anyone else\"",
    // "\"Life isn't about finding yourself. Life is about creating\nyourself.\""
    // };
    // }

    public Quote getRandomQuote() {
	int randomQuoteIndex = new Random().nextInt(quotes.size());
	return quotes.get(randomQuoteIndex);
    }

    
}
