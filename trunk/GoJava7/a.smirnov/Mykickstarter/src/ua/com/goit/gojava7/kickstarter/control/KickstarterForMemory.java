package ua.com.goit.gojava7.kickstarter.control;

import java.util.Iterator;
import java.util.Set;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Faq;
import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.storage_in_memory.CategoriesStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_memory.FaqStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_memory.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_memory.ProjectsStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_memory.QuotesStorage;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class KickstarterForMemory {

	private static final String SEPARATOR = "**********************************************************************";
	private static final String MOVE_TO_THE_NEXT_LINE = "\n";
	
	private ConsolePrinter consolePrinter;
	private ConsoleScanner consoleScanner;
	private CategoriesStorage categoriesStorage;
	private ProjectsStorage projectsStorage;
	private QuotesStorage quotesStorage;
	private PaymentStorage paymentStorage;
	private FaqStorage faqStorage;

	public KickstarterForMemory() {
		this.consoleScanner = new ConsoleScanner();
		this.consolePrinter = new ConsolePrinter();
		this.categoriesStorage = new CategoriesStorage();
		this.quotesStorage = new QuotesStorage();
		this.paymentStorage = new PaymentStorage();
		this.projectsStorage = new ProjectsStorage(categoriesStorage);
		this.faqStorage = new FaqStorage();
	}

	public void start() {
		consolePrinter.print(quotesStorage.getRandomQuote());
		selectCategory();
	}
	
	protected void selectCategory() {
		Set<Category> AllCategories = categoriesStorage.getAll();
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
		Set<Project> AllProjectsFromCategory = projectsStorage.getAllProjectsFromCategory(category);
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
			append("1 : Donate money").
			append(MOVE_TO_THE_NEXT_LINE).
			append("2 : Ask a question");
		
		int choseNumber;
		do {
			
			consolePrinter.print(chooseMenuInProject.toString());
			consolePrinter.print(SEPARATOR);
			choseNumber = consoleScanner.getInt();

			if (choseNumber == 1) {
				consolePrinter.print("You selected 1. Donate money on project ");
				consolePrinter.print(SEPARATOR);
				donateMoneyForProject(selectedProject);
				consolePrinter.print(SEPARATOR);
			} 
			
			if (choseNumber == 2) {
				consolePrinter.print("You selected 2. Ask a question ");
				consolePrinter.print(SEPARATOR);
				askQuestion(selectedProject);
			}
			
		} while (choseNumber != 0);
		
		consolePrinter.print("You entered 0. Back to projects.");
		consolePrinter.print(SEPARATOR);
	}
	
	protected void donateMoneyForProject(Project project) {
		String userName = consoleScanner.parseUserName();
		long cardNumber = consoleScanner.parseCreditCardNumber();
		int donatingSum = consoleScanner.parseDonatingAmount();
		
		consolePrinter.print(SEPARATOR);
		
		Payment payment = new Payment(userName, cardNumber, donatingSum);
		project.addMoneyToProject(payment.getDonatingSum());
		paymentStorage.add(payment);
		consolePrinter.printBriefProjectInfo(project);	
	}
	
	protected void askQuestion(Project project) {
		String question = consoleScanner.parseAskingQuestion();
		Faq faq = new Faq(question);
		faq.setProject(project);
		faqStorage.add(faq);
		
		consolePrinter.print(SEPARATOR);
		
		consolePrinter.printBriefProjectInfo(project);
		consolePrinter.printFAQs(faqStorage.getAll());
	}
	
	protected void stop() {
		consoleScanner.close();
	}
}
