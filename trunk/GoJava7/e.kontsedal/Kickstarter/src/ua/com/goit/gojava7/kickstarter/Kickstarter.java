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

	public void start() throws IOException {
		consolePrinter.println(quoteStorage.getRandomQuote());
		showChosenCategory();
	}

	public void showChosenCategory() throws IOException {
		boolean repeatChosingOfCategory = true;
		do {
			consolePrinter.println(categoryStorage);
			consolePrinter.println("Chose the category");
			int numberOfSelectedCategory = consoleReader.getNumberFromConsole();
			if (numberOfSelectedCategory > 0 && numberOfSelectedCategory <= categoryStorage.getAllCategories().size()) {
				Category currentCategory = categoryStorage.getCategory(numberOfSelectedCategory);
				consolePrinter.println(currentCategory);
				showChosenProject(numberOfSelectedCategory);
				repeatChosingOfCategory = false;
			} else {
				consolePrinter.println("there is no such category!");
			}
		} while (repeatChosingOfCategory);
	}

	public void showChosenProject(int numberOfSelectedCategory) throws IOException {

		boolean repeatChosingOfProject = true;
		do {
			consolePrinter.println(categoryStorage, numberOfSelectedCategory);
			consolePrinter.println("Enter 0 ot see all categories or chose number of category");
			int numberOfselectedProject = consoleReader.getNumberFromConsole();
			if (numberOfselectedProject == 0) {
				showChosenCategory();
			} else if (numberOfselectedProject > 0 && numberOfselectedProject <= categoryStorage
					.getCategory(numberOfSelectedCategory).getAllProjectsInCategory().size()) {
				Project currentProject = categoryStorage.getCategory(numberOfSelectedCategory)
						.getProject(numberOfselectedProject);
				consolePrinter.println(currentProject);
				consolePrinter.println("Enter 0 ot see all projects in this category\nEnter 1 ot make payment");
				int actionInProject = consoleReader.getNumberFromConsole();
				if (actionInProject == 0) {
					continue;
				} else if (actionInProject == 1) {
					makePayment(numberOfSelectedCategory, currentProject);
				} else {
					consolePrinter.println("bye!");
					repeatChosingOfProject = false;
				}
			}
		} while (repeatChosingOfProject);
	}

	public void makePayment(int numberOfSelectedCategory, Project project) throws IOException {
		consolePrinter.println("Enter your Name");
		String cardOwner = consoleReader.getStringFromConsole();
		consolePrinter.println("Enter Card number");
		long cardNumber = consoleReader.getLongNumberFromConsole();
		consolePrinter.println("Enter the amount");
		int rechargeAmount = consoleReader.getNumberFromConsole();
		project.setPayment(cardOwner, cardNumber, rechargeAmount);
		showChosenProject(numberOfSelectedCategory);
	}

	public void stop() throws IOException {
		consoleReader.closeReader();
	}
}
