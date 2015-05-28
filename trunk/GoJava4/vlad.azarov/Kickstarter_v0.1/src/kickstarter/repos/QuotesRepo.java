package kickstarter.repos;

import java.util.ArrayList;
import java.util.Random;

import kickstarter.model.Quote;

public class QuotesRepo {
    
    private ArrayList<Quote> quotes;

    public QuotesRepo() {
	quotes = new ArrayList<>();

	add(new Quote(
		"Life isn't about finding yourself. Life is about creating yourself.",
		"Author"));
	add(new Quote(
		"Start by doing what's necessary; then do what's possible and \nsuddenly you are doing the impossible.",
		"Author"));
	add(new Quote(
		"You have to learn the rules of the game. And then you have to \nplay better than anyone else.",
		"Author"));
	add(new Quote(
		"Perfection is not attainable, but if we chase perfection we can \ncatch excellence.",
		"Author"));
	add(new Quote(
		"My favorite things in life don't cost any money. It's really clear\n that the most precious resource we all have is time.",
		"Author"));
    }

    public void add(Quote quote) {
	quotes.add(quote);
    }

    public String showRandomQuote() {
	StringBuilder result = new StringBuilder();
	int randomQuoteIndex = new Random().nextInt(quotes.size());
	String author = quotes.get(randomQuoteIndex).getQuoteAuthor();
	String content = quotes.get(randomQuoteIndex).getQuoteContent();
	result.append("\"" + content + "\"\n");
	result.append("\t\t\t\t\t\t\t");
	result.append("(c)" + author);
	return result.toString();
    }
}
