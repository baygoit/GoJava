package ua.com.goit.gojava7.kickstarter;

public class Kickstarter {

	public static void main(String[] args) {
		QuoteStorage quoteStorage = new QuoteStorage();
		ConsolePrinter.println(quoteStorage.getRandomQuote());
	}

}
