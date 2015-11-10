package ua.com.goit.gojava7.kickstarter;

import java.io.IOException;

// OLEG do we need so many comments here?
// OLEG to big main method - think how to split it
public class Kickstarter {

	public static void main(String[] args) throws IOException {
		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleReader consoleReader = new ConsoleReader();
		QuoteStorage quoteStorage = new QuoteStorage();

		quoteStorage.setQuote(
				"Your work is going to fill a large part of your life,"
						+ " and the only way to be truly satisfied is to do what"
						+ " you believe is great work. And the only way to do"
						+ " great work is to love what you do. If you haven't"
						+ " found it yet, keep looking. Don't settle. As with"
						+ " all matters of the heart, you'll know when you"
						+ " find it. Steve Jobs.");
		quoteStorage.setQuote(
				"Innovation distinguishes between a leader and a follower. Steve Jobs.");

		consolePrinter.println(quoteStorage.getRandomQuote());

		CategoryStorage categoryStorage = new CategoryStorage();
		// creating of categories
		categoryStorage.setCategory("Movie");
		categoryStorage.setCategory("Art");
		categoryStorage.setCategory("Food");

		// add project in category #1
		// OLEG formatting?
		categoryStorage.getCategory(1)
				.setProject(new Project("THE BOONDOCK SAINTS",
						"The Boondock Saints is a 1999 American crime film written and directed by Troy Duffy",
						100000.0, 180));

		// show all categories with index
		consolePrinter.println(categoryStorage);

		// ask user to select 1
		consolePrinter.println("Chose the category");

		// read user input category
		int numberOfSelectedCategory = consoleReader.getNumberFromConsole();

		// show selected category
		consolePrinter
				.println(categoryStorage.getCategory(numberOfSelectedCategory));

		// show projects in selected category
		consolePrinter.println(categoryStorage, numberOfSelectedCategory);

		// read user input project
		int numberOfselectedProject = consoleReader.getNumberFromConsole();

// OLEG formatting?
		consolePrinter
				.println(categoryStorage.getCategory(numberOfSelectedCategory)
						.getProject(numberOfselectedProject));

		consoleReader.closeReader();

	}
}
