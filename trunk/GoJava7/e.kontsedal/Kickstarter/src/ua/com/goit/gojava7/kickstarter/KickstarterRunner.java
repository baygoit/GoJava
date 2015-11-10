package ua.com.goit.gojava7.kickstarter;

import java.io.IOException;

// OLEG do we need so many comments here?
// OLEG to big main method - think how to split it
public class KickstarterRunner {

	public static void main(String[] args) throws IOException {
		ConsoleReader consoleReader = new ConsoleReader();
		ConsolePrinter consolePrinter = new ConsolePrinter();
		QuoteStorage quoteStorage = initQuotes();
		CategoryStorage categoryStorage = initCategiries();
		initProjects(categoryStorage);
		
		Kickstarter kickstarter = new Kickstarter(consoleReader, consolePrinter, quoteStorage, categoryStorage);
		kickstarter.start();
		kickstarter.stop();

	}

	private static QuoteStorage initQuotes() {
		QuoteStorage quoteStorage = new QuoteStorage();
		quoteStorage.setQuote("Your work is going to fill a large part of your life,"
				+ " and the only way to be truly satisfied is to do what"
				+ " you believe is great work. And the only way to do"
				+ " great work is to love what you do. If you haven't"
				+ " found it yet, keep looking. Don't settle. As with"
				+ " all matters of the heart, you'll know when you" + " find it. Steve Jobs.");
		quoteStorage.setQuote("Innovation distinguishes between a leader and a follower. Steve Jobs.");
		return quoteStorage;
	}
	private static CategoryStorage initCategiries() {
		CategoryStorage categoryStorage = new CategoryStorage();
		categoryStorage.setCategory("Movie");
		categoryStorage.setCategory("Art");
		categoryStorage.setCategory("Food");
		
		return categoryStorage;
	}
	private static void initProjects(CategoryStorage categoryStorage) {
		categoryStorage.getCategory(1).setProject(new Project("THE BOONDOCK SAINTS",
				"The Boondock Saints is a 1999 American crime film written and directed by Troy Duffy",
				1000000, 180));
	}
}
