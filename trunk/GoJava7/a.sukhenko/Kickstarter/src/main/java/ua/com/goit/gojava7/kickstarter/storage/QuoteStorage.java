package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

/**
 * @author Devian
 * @category Storage
 */
@XmlRootElement(name = "quotes")
public class QuoteStorage {
	private List<Quote> quotes = new ArrayList<>();
	public static final String QUOTE_BY_PRINCESS_DIANA = "Carry out a random act of kindness, with no expectation of reward, safe in the knowledge that one day someone might do the same for you.";
	public static final String QUOTE_BY_MISHA_COLLINS = "I actually think that the most efficacious way of making a difference is to lead by example, and doing random acts of kindness is setting a very good example of how to behave in the world.";
	private static final Random rand = new Random();

	@XmlElement(name = "quote")
	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	public Quote getRandomQuote() {
		int random = rand.nextInt(quotes.size());
		return quotes.get(random);

	}

	public void addQuote(Quote q) {
		quotes.add(q);
	}

	/**
	 * @return Unmodifiable List of <b>Quote</b>s
	 */
	public List<Quote> getQuotes() {
		return quotes;

	}

}
