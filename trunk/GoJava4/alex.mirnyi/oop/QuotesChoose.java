package oop;

import java.util.Random;
import java.util.logging.Logger;

public class QuotesChoose {
	private static String[] quotes = Quotes.quotes;
	private static int index = new Random().nextInt(quotes.length);
	private static String random = (quotes[index]);
	
	public static String getRandom() {
		return random;
	}

}
