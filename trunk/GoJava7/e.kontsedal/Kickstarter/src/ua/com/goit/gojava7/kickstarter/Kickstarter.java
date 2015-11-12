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
		boolean stopWhile = true;
		do {
			consolePrinter.println(categoryStorage);
			consolePrinter.println("Chose the category");

			int numberOfSelectedCategory = consoleReader.getNumberFromConsole();
			do {
				try {
					consolePrinter.println(categoryStorage.getCategory(numberOfSelectedCategory));
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("there is no such category!");
					break;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("there is no such category!");
					break;
				}

				consolePrinter.println(categoryStorage, numberOfSelectedCategory);

				consolePrinter.println("Enter 0 ot see all categories");
				int numberOfselectedProject = consoleReader.getNumberFromConsole();
				if (numberOfselectedProject == 0)
					break;
				try {
					consolePrinter.println(
							categoryStorage.getCategory(numberOfSelectedCategory).getProject(numberOfselectedProject));
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("there is no such project!");
					continue;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("there is no such project!");
					continue;
				}
				consolePrinter.println("Enter 0 ot see all projects in this category");
				int exitProject = consoleReader.getNumberFromConsole();
				if (exitProject == 0)
					continue;
				else {
					System.out.println("bye");
					stopWhile = false;
				}

			} while (stopWhile);

		} while (stopWhile);

	}

	public void stop() throws IOException {
		consoleReader.closeReader();
	}
}
