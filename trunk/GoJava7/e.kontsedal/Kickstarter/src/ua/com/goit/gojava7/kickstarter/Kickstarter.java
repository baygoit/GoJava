package ua.com.goit.gojava7.kickstarter;

import java.io.IOException;

public class Kickstarter {
	private ConsoleReader consoleReader;
	private ConsolePrinter consolePrinter;
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;

	public Kickstarter(ConsoleReader consoleReader, ConsolePrinter consolePrinter, QuoteStorage quoteStorage,
			CategoryStorage categoryStorage) {
		this.consoleReader = consoleReader;
		this.consolePrinter = consolePrinter;
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	public void start() throws NumberFormatException, IOException {
		consolePrinter.println(quoteStorage.getRandomQuote());
		consolePrinter.println(categoryStorage);
		consolePrinter.println("Chose the category");
		
		int numberOfSelectedCategory = consoleReader.getNumberFromConsole();
		consolePrinter.println(categoryStorage.getCategory(numberOfSelectedCategory));
		consolePrinter.println(categoryStorage, numberOfSelectedCategory);
		
		int numberOfselectedProject = consoleReader.getNumberFromConsole();
		consolePrinter.println(categoryStorage.getCategory(
				numberOfSelectedCategory).getProject(numberOfselectedProject));
	}

	public void stop() {
		try {
			consoleReader.closeReader();
		} catch (IOException e) {
			System.out.println("wtf?");
		}
	}
}
