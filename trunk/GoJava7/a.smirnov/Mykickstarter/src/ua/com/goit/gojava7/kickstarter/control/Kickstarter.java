package ua.com.goit.gojava7.kickstarter.control;

import java.util.Iterator;
import java.util.Set;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoriesStorage;
import ua.com.goit.gojava7.kickstarter.storage.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuotesStorage;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class Kickstarter {

	private static final String SEPARATOR = "**********************************************************************";
	private static final String MOVE_TO_THE_NEXT_LINE = "\n";
	private ConsolePrinter consolePrinter;
	private ConsoleScanner consoleScanner;
	private CategoriesStorage categoriesStorage;
	private QuotesStorage quotesStorage;
	private PaymentStorage paymentStorage;

	public Kickstarter(ConsoleScanner consoleScanner, ConsolePrinter consolePrinter,
			CategoriesStorage categoriesStorage, QuotesStorage quotesStorage, PaymentStorage paymentStorage) {
		
		this.consoleScanner = consoleScanner;
		this.consolePrinter = consolePrinter;
		this.categoriesStorage = categoriesStorage;
		this.quotesStorage = quotesStorage;
		this.paymentStorage = paymentStorage;
	}

	public void start() {
		consolePrinter.print(quotesStorage.getRandomQuote());
		selectCategory();
	}
	
	protected void selectCategory() {
		Set<Category> AllCategories = categoriesStorage.getAllCategories();
		int amountOfCategories = AllCategories.size();
		
		Category selectedCategory = null;
		int numberOfSelectedCategory;
		boolean userChoise = true;
		
		do {
			consolePrinter.printCategories(AllCategories);
			consolePrinter.print(SEPARATOR);
			consolePrinter.print("Please select category (0 for exit): ");
			numberOfSelectedCategory = consoleScanner.getInt();

			if (numberOfSelectedCategory < 0 || numberOfSelectedCategory > amountOfCategories) {
				consolePrinter.print("Please, enter the number between 0 and " + amountOfCategories);
				consolePrinter.print(SEPARATOR);
				continue;
				
			} else if (numberOfSelectedCategory != 0) {
				consolePrinter.print("You selected category number : " + numberOfSelectedCategory);
				selectedCategory = getSelectedCategory(numberOfSelectedCategory, AllCategories);
				consolePrinter.print(selectedCategory);
				consolePrinter.print(SEPARATOR);
				
				selectProjects(selectedCategory);
				
			} else {
				consolePrinter.print("You entered 0. Bye.");
				consolePrinter.print(SEPARATOR);
				userChoise = false;
			}
			
		} while (userChoise);
	}

	protected void selectProjects(Category category) {
		Set<Project> AllProjectsFromCategory = category.getAllProjectsFromCategory();
		int amountOfPrjects = AllProjectsFromCategory.size();
		
		int numberOfSelectedProject;
		
		if (amountOfPrjects == 0) {
			consolePrinter.print("There is no any project in selected category.");
			consolePrinter.print(SEPARATOR);
			numberOfSelectedProject = 0;
		} else {
			Project selectedProject = null;
			boolean userChoise = true;
			do {
				consolePrinter.printProjects(AllProjectsFromCategory, userChoise);
				consolePrinter.print(SEPARATOR);
				consolePrinter.print("Please select project (0 for back to categories): ");
				
				numberOfSelectedProject = consoleScanner.getInt();
	
				if (numberOfSelectedProject < 0 || numberOfSelectedProject > amountOfPrjects) {
					consolePrinter.print("Please, enter the number between 0 and " + amountOfPrjects);
					consolePrinter.print(SEPARATOR);
					continue;
					
				} else if (numberOfSelectedProject != 0) {
					consolePrinter.print("You selected project number : " + numberOfSelectedProject);
					selectedProject = getSelectedProject(numberOfSelectedProject, AllProjectsFromCategory);
					consolePrinter.print(SEPARATOR);
					consolePrinter.printFullProjectInfo(selectedProject);
					consolePrinter.print(SEPARATOR);
					
					activityInsideSelectedProject(selectedProject);
							
				} else {
					consolePrinter.print("You entered 0. Back to categories.");
					consolePrinter.print(SEPARATOR);
					userChoise = false;
				}
				
			} while (userChoise);
		}

	}
	
	protected Category getSelectedCategory(int numberOfSelectedCategory, Set<Category> categories) {
		Iterator<Category> categoryIterator = categories.iterator();
		Category selectedCategory = null;
		int stepsCounter = 0;
		while (categoryIterator.hasNext()) {
			stepsCounter ++;
			if (stepsCounter == numberOfSelectedCategory) {
				selectedCategory = categoryIterator.next();
			} else {
				categoryIterator.next();
			}
			
		}
		return selectedCategory;
	}
	
	
	protected Project getSelectedProject(int numberOfSelectedProject, Set<Project> projects) {
		Iterator<Project> projectsIterator = projects.iterator();
		Project selectedProject = null;
		int stepsCounter = 0;
		while (projectsIterator.hasNext()) {
			stepsCounter ++;
			if (stepsCounter == numberOfSelectedProject) {
				selectedProject = projectsIterator.next();
			} else {
				projectsIterator.next();
			}
			
		}
		return selectedProject;
	}
	
	protected void activityInsideSelectedProject(Project selectedProject) {
		StringBuilder chooseMenuInProject = new StringBuilder();
		
		chooseMenuInProject.
			append("Please select (0 for back to projects): ").
			append(MOVE_TO_THE_NEXT_LINE).
			append("1 : donate money").
			append(MOVE_TO_THE_NEXT_LINE).
			append("2 : Ask a question");
		
		int choseNumber;
		do {
			consolePrinter.print(chooseMenuInProject.toString());
			choseNumber = consoleScanner.getInt();
			consolePrinter.print(SEPARATOR);
			
			if (choseNumber == 1) {
				donateMoneyForProject(selectedProject);
				consolePrinter.print(SEPARATOR);
			}
			
			if (choseNumber == 2) {
				askQuestion(selectedProject);
			}
			
		} while (choseNumber != 0);
		
		consolePrinter.print("You entered 0. Back to projects.");
		consolePrinter.print(SEPARATOR);
	}
	
	protected void donateMoneyForProject(Project project) {
		String userName = getUserName();
		int cardNumber = getCreditCardNumber();
		int donatingSum = getPledgeAmount();
		
		consolePrinter.print(SEPARATOR);
		project.addToCurrentAmountOfMoney(donatingSum);
		System.out.print(consolePrinter.getBriefProjectInfo(project));
		
		Payment payment = new Payment(userName, donatingSum, cardNumber);
		paymentStorage.add(payment);	
	}
	
	protected void askQuestion(Project project) {
		String question = getAskingQuestion();
		consolePrinter.print(SEPARATOR);
		project.addQuestion(question);
		consolePrinter.printFullProjectInfo(project);
	}
	
	protected int getPledgeAmount() {
		int pledgeAmount;
		do {
			consolePrinter.print("Please enter donateing sum : ");
			pledgeAmount = consoleScanner.getInt();
		} while (pledgeAmount == Integer.MAX_VALUE);
		
		return pledgeAmount;
	}
	
	protected int getCreditCardNumber() {
		int creditCardNumber;
		do {
			consolePrinter.print("Please enter you card number : ");
			creditCardNumber = consoleScanner.getInt();
		} while (creditCardNumber == Integer.MAX_VALUE);
		
		return creditCardNumber;
	}
	
	protected String getUserName() {
		consolePrinter.print("Please enter you name :");
		String userName = consoleScanner.getString();
		return userName;
	}
	
	protected String getAskingQuestion() {
		consolePrinter.print("Please your question :");
		String question = consoleScanner.getString();
		return question;
	}
	
	protected void shutdown() {
		consoleScanner.close();
	}
}
