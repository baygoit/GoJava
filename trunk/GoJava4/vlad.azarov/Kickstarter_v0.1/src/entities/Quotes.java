package entities;

import java.util.Random;

public class Quotes {

	private String[] quotes;

	public Quotes() {
		quotes = new String[] {
				"\"Start by doing what's necessary; then do what's possible;\nand suddenly you are "
				+ "doing the impossible.\"",
				"\"Perfection is not attainable, but if we chase perfection\nwe can catch "
				+ "excellence.\"",
				"\"My favorite things in life don't cost any money. It's\nreally clear that the "
				+ "most precious resource we all have is time.\"",
				"\"You have to learn the rules of the game. And then you have\nto play better than "
				+ "anyone else\"",
				"\"Life isn't about finding yourself. Life is about creating\nyourself.\"" };
	}

	public void showRandomQuote() {
		int randomQuoteIndex = new Random().nextInt(quotes.length);
		System.out.println(quotes[randomQuoteIndex]);
	}

	public void showQuoteMenu() {
		int randomQuoteIndex = new Random().nextInt(quotes.length);
		System.out
				.println("====================================================================");
		System.out.println("Everyday inspiring quote:");
		System.out.println(quotes[randomQuoteIndex]);
		System.out
				.println("--------------------------------------------------------------------");
	}

}