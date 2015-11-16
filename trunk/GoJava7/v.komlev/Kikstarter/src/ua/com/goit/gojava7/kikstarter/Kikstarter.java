package ua.com.goit.gojava7.kikstarter;

import java.io.IOException;

public class Kikstarter {

	private ConsoleReader consoleReader;
	private ConsolePrinter consolePrinter;
	private QuotesStorage quotesStorage;
	private CategoryStorage categoryStorage;

	public Kikstarter(ConsoleReader consoleReader, ConsolePrinter consolePrinter,
			QuotesStorage quotesStorage, CategoryStorage categoryStorage) {
		this.consoleReader = consoleReader;
		this.consolePrinter = consolePrinter;
		this.quotesStorage = quotesStorage;
		this.categoryStorage = categoryStorage;
	}

	public void startUp() throws IOException {
		consolePrinter.printQuote(quotesStorage.getRandomQuote());
		boolean stopWhile = true;

		do {
			consolePrinter.printAllCategories(categoryStorage);
			consolePrinter.printString("Please choose the category from list");

			int numberOfSelectedCategory = (consoleReader.getNumberFromConsoel()) - 1;

			try {
				consolePrinter.printCategory(categoryStorage.getCategory(numberOfSelectedCategory));
			} catch (Exception e) {
				System.out.println("there is no such category!");
				continue;
			}

			do {
				consolePrinter.printProjectsOfCurrentCategory(categoryStorage,
						numberOfSelectedCategory);

				consolePrinter.printString("Enter number project; Enter 0 ot see all categories");
				int numberOfselectedProject = (consoleReader.getNumberFromConsoel()) - 1;
				if (numberOfselectedProject == -1) {
					break;
				} else {
					consolePrinter.printPoject(categoryStorage
							.getCategory(numberOfSelectedCategory).getProject(
									numberOfselectedProject));
				}

				consolePrinter.printString("Enter 0 to see all projects");
			} while (stopWhile);

		} while (stopWhile);
	}

}
