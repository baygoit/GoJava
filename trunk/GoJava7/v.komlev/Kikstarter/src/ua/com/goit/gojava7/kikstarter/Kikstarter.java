package ua.com.goit.gojava7.kikstarter;

import java.io.IOException;

public class Kikstarter {

	private static final String INDENT = "===============================";
	private ConsoleReader consoleReader;
	private ConsolePrinter consolePrinter;
	private QuotesStorage quotesStorage;
	private CategoryStorage categoryStorage;
	private PaymentStorage paymentStorage;

	public Kikstarter(ConsoleReader consoleReader, ConsolePrinter consolePrinter,
			QuotesStorage quotesStorage, CategoryStorage categoryStorage) {
		this.consoleReader = consoleReader;
		this.consolePrinter = consolePrinter;
		this.quotesStorage = quotesStorage;
		this.categoryStorage = categoryStorage;
		paymentStorage = new PaymentStorage();
	}

	public void startUp() throws IOException {
		consolePrinter.printQuote(quotesStorage.getRandomQuote());
		boolean stopWhile = true;

		do {
			consolePrinter.printAllCategories(categoryStorage);
			consolePrinter.printString("Please choose the category from list; Enter 0 to exit");

			int numberOfSelectedCategory = (consoleReader.getNumberFromConsoel()) - 1;
			if (numberOfSelectedCategory == -1) {
				consolePrinter.printString("You entered 0. Bye!");
				break;
			} else {
				try {
					consolePrinter.printCategory(categoryStorage
							.getCategory(numberOfSelectedCategory));
				} catch (Exception e) {
					System.out.println("there is no such category!");
					continue;
				}

				do {
					consolePrinter.printProjectsOfCurrentCategory(categoryStorage,
							numberOfSelectedCategory);

					consolePrinter
							.printString("Enter number project; Enter 0 ot see all categories");
					int numberOfselectedProject = (consoleReader.getNumberFromConsoel()) - 1;
					if (numberOfselectedProject == -1) {
						break;
					} else {
						consolePrinter.printPoject(categoryStorage.getCategory(
								numberOfSelectedCategory).getProject(numberOfselectedProject));
					}

					consolePrinter
							.printString("Enter 1 to make a payment; Enter 0 to see all projects");
					int numberOfselecedProjectPayment = (consoleReader.getNumberFromConsoel());
					if (numberOfselecedProjectPayment == 0) {
						continue;
					} else {
						setPaymentFromUser(categoryStorage.getCategory(numberOfSelectedCategory)
								.getProject(numberOfselectedProject));
					}
				} while (stopWhile);
			}

		} while (stopWhile);
	}

	public void setPaymentFromUser(Project project) throws IOException {
		consolePrinter.printString(INDENT);
		consolePrinter.printString("Enter User name");
		String currentUserName = (consoleReader.getStringFromConsoel());
		consolePrinter.printString("Enter number card");
		long currentNumberCard = consoleReader.getLongFromConsoel();
		consolePrinter.printString("Enter the desired amount");
		int currentEnteredAmount = consoleReader.getNumberFromConsoel();

		consolePrinter.printString(INDENT);

		Payment payment = new Payment(currentUserName, currentNumberCard, currentEnteredAmount);
		project.setProjectSumFromUser(currentEnteredAmount);
		paymentStorage.setPayment(payment);
		consolePrinter.printPoject(project);

	}
}
