package ua.com.goit.gojava7.kikstarter;

import java.io.IOException;

import ua.com.goit.gojava7.kikstarter.dao.memory.QuoteDaoMemory;
import ua.com.goit.gojava7.kikstarter.domain.Project;

public class Kikstarter {

	private static final String INDENT = "===============================";
	private ConsoleReader consoleReader;
	private ConsolePrinter consolePrinter;
	private QuoteDaoMemory quoteDaoMemory;
	private CategoryStorage categoryStorage;
	private PaymentStorage paymentStorage;

	public Kikstarter(ConsoleReader consoleReader, ConsolePrinter consolePrinter,
			QuoteDaoMemory quoteDaoMemory, CategoryStorage categoryStorage) {
		this.consoleReader = consoleReader;
		this.consolePrinter = consolePrinter;
		this.quoteDaoMemory = quoteDaoMemory;
		this.categoryStorage = categoryStorage;
		paymentStorage = new PaymentStorage();
	}

	public void startUp() throws IOException {
		consolePrinter.printQuote(quoteDaoMemory.getRandomQuote());
		boolean stopWhile = true;

		do {
			consolePrinter.printAllCategories(categoryStorage);
			consolePrinter.printString("Please choose the category from list; Enter 0 to exit");

			int numberOfSelectedCategory = (consoleReader.getNumberFromConsoel()) - 1;
			if (numberOfSelectedCategory == -1) {
				consolePrinter.printString("You entered 0. Bye!");
				stopWhile = false;
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
						consolePrinter.printString(INDENT);
						consolePrinter.printPoject(categoryStorage.getCategory(
								numberOfSelectedCategory).getProject(numberOfselectedProject));
					}

					consolePrinter
							.printString("Enter 1 to make a payment; Enter 2 to to ask question; 0 - all porjects");
					int numberOfselecedProjectPayment = (consoleReader.getNumberFromConsoel());
					if (numberOfselecedProjectPayment == 0) {
						continue;
					} else if (numberOfselecedProjectPayment == 1) {
						setPaymentFromUser(categoryStorage.getCategory(numberOfSelectedCategory)
								.getProject(numberOfselectedProject));
					} else if (numberOfselecedProjectPayment == 2) {
						setQuestionFromUser(categoryStorage.getCategory(numberOfSelectedCategory)
								.getProject(numberOfselectedProject));
					}
					consolePrinter.printString("Enter 1 to see all projects; 0 - to exit");
					int numberOfselecedProjectExitOrNot = (consoleReader.getNumberFromConsoel());
					if (numberOfselecedProjectExitOrNot == 0) {
						consolePrinter.printString("You entered 0. Bye!");
						stopWhile = false;
						break;
					} else {
						continue;
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

	public void setQuestionFromUser(Project project) throws IOException {
		consolePrinter.printString("Enter your question:");
		String currentUserQuestion = (consoleReader.getStringFromConsoel());

		consolePrinter.printString(INDENT);

		project.setProjectQuestion(currentUserQuestion);
		consolePrinter.printPoject(project);
	}
}
