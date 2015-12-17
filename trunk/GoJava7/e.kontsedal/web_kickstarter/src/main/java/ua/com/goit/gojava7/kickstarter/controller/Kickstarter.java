package ua.com.goit.gojava7.kickstarter.controller;

import java.io.IOException;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractCategoryStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractPaymentStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractProjectStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuestionStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuoteStorage;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleReader;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Question;

public class Kickstarter {
	private ConsoleReader consoleReader;
	private ConsolePrinter consolePrinter;
	private AbstractQuoteStorage quoteStorage;
	private AbstractCategoryStorage categoryStorage;
	private AbstractProjectStorage projectStorage;
	private AbstractPaymentStorage paymentStorage;
	private AbstractQuestionStorage questionStorage;

	public Kickstarter(ConsoleReader consoleReader, ConsolePrinter consolePrinter, AbstractQuoteStorage quoteStorage,
			AbstractCategoryStorage categoryStorage, AbstractProjectStorage projectStorage, AbstractPaymentStorage paymentStorage,
			AbstractQuestionStorage questionStorage) {
		this.consoleReader = consoleReader;
		this.consolePrinter = consolePrinter;
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
		this.projectStorage = projectStorage;
		this.paymentStorage = paymentStorage;
		this.questionStorage = questionStorage;
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
			if (numberOfSelectedCategory > 0 && numberOfSelectedCategory <= categoryStorage.getAll().size()) {
				int idOfCurrentCategory = categoryStorage.getIdOfCategory(numberOfSelectedCategory - 1);
				Category currentCategory = categoryStorage.getCategoryById(idOfCurrentCategory);
				consolePrinter.println(currentCategory);
				chosingProject(idOfCurrentCategory);
				repeatChosingOfCategory = false;
			} else {
				consolePrinter.println("there is no such category!");
			}
		} while (repeatChosingOfCategory);
	}

	public void chosingProject(int idOfCurrentCategory) throws IOException {

		boolean repeatChosingOfProject = true;
		do {
			consolePrinter.println(projectStorage, idOfCurrentCategory, paymentStorage);
			consolePrinter.println("Enter 0 to see all categories or chose number of category");
			int numberOfselectedProject = consoleReader.getNumberFromConsole();
			if (numberOfselectedProject == 0) {
				showChosenCategory();
			} else if (numberOfselectedProject > 0 && numberOfselectedProject <= projectStorage
					.getProjectsFromSelectedCategory(idOfCurrentCategory).size()) {
				int idOfCurrentProject = projectStorage.getProjectsFromSelectedCategory(idOfCurrentCategory)
						.get(numberOfselectedProject - 1).getIdProject();
				Project currentProject = projectStorage.getProjectById(idOfCurrentProject);
				
				consolePrinter.println(currentProject, paymentStorage, questionStorage);
				consolePrinter.println("Enter 0 to see all projects in this category" + "\nEnter 1 to make payment "
						+ "\nEnter 2 to leave a question");
				
				int actionNumber = consoleReader.getNumberFromConsole();
				
				repeatChosingOfProject = actionInProject(currentProject, actionNumber);

			} else {
				consolePrinter.println("chose correct number of movie!");
			}
		} while (repeatChosingOfProject);
	}

	public boolean actionInProject(Project project, int action) throws IOException {
		boolean repeatChosingOfProject = true;
		if (action == 0) {
			chosingProject(project.getIdProject());
		} else if (action == 1) {
			makePayment(project);
		} else if (action == 2) {
			leaveQuestion(project);
		} else {
			consolePrinter.println("bye!");
			repeatChosingOfProject = false;
		}
		return repeatChosingOfProject;
	}

	public void makePayment(Project project) throws IOException {
		consolePrinter.println("Enter your Name");
		String cardOwner = consoleReader.getStringFromConsole();
		consolePrinter.println("Enter Card number");
		long cardNumber = consoleReader.getLongNumberFromConsole();
		consolePrinter.println("Chose amount \n 1: $1 \n 2: $10 \n 3: $40 \n 4: your amount");
		int action = 0;
		int rechargeAmount = 0;
		do {
			action = consoleReader.getNumberFromConsole();
			if (action == 1) {
				rechargeAmount = 1;
			} else if (action == 2) {
				rechargeAmount = 10;
			} else if (action == 3) {
				rechargeAmount = 40;
			} else if (action == 4) {
				consolePrinter.println("Enter amount");
				rechargeAmount = consoleReader.getNumberFromConsole();;
			} else {
				consolePrinter.println("chose correct number!");
			}
		} while (action < 1 || action > 4);
		Payment payment = new Payment();
		payment.setCardNumber(cardNumber);
		payment.setCardOwner(cardOwner);
		payment.setRechargeAmount(rechargeAmount);
		payment.setIdParentProject(project.getIdProject());
		paymentStorage.add(payment);
	}

	public void leaveQuestion(Project project) throws IOException {
		consolePrinter.println("Enter your question");
		Question question = new Question();
		String questionStr = consoleReader.getStringFromConsole();
		question.setQuestion(questionStr);
		question.setIdParentProject(project.getIdProject());
		questionStorage.add(question);
	}

	public void stop() throws IOException {
		consoleReader.closeReader();
	}
}
