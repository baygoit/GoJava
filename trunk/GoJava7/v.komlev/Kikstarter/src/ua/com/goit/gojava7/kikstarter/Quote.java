package ua.com.goit.gojava7.kikstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
	
	/**
	 * create class Quote which contain list quotes
	 *  
	 */
public class Quote {

	private static Random RANDOM = new Random();
	private static List<String> listQuotes = new ArrayList<>();

	private static void setQuote() {
		listQuotes.add("Two things are infinite: "
				+ "the universe and human stupidity;"
				+ " and I'm not sure about the universe. Albert Einstein");

		listQuotes.add("Coming together is a beginning; "
				+ "keeping together is progress; "
				+ "working together is success. Henry Ford");

		listQuotes.add("If you spend too much time thinking about a thing, "
				+ "you'll never get it done. Bruce Lee");
	}

	//method outputs one random quote
	public String getQuote() {
		setQuote();getClass();
		int randomNumber = RANDOM.nextInt(listQuotes.size());
		return listQuotes.get(randomNumber);
	}

}
