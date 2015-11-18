package ua.com.goit.gojava7.kickstarter.control;

import java.util.Iterator;
import java.util.List;
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
	
	private Category selectedCategoryByUser;
	private Project selectedProjectByUser;

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
		
		int selectedNumber;
		boolean userChoise = true;
		
		do {
			consolePrinter.printCategories(categoriesStorage.getAll());
			consolePrinter.print(SEPARATOR);
			consolePrinter.print("Please select category (0 for exit): ");
			selectedNumber = consoleScanner.getInt();

			if (selectedNumber < 0 || selectedNumber > categoriesStorage.getSize()) {
				consolePrinter.print("Please, enter the number between 0 and " + categoriesStorage.getSize());
				consolePrinter.print(SEPARATOR);
				
			} else if (selectedNumber != 0) {
				consolePrinter.print("You selected category number : " + selectedNumber);
				selectedCategoryByUser = categoriesStorage.getAll().get(selectedNumber - 1);
				consolePrinter.print(selectedCategoryByUser);
				consolePrinter.print(SEPARATOR);
				
				selectProjects(selectedCategoryByUser);
				
			} else {
				consolePrinter.print("You entered 0. Bye.");
				consolePrinter.print(SEPARATOR);
				userChoise = false;
			}
			
		} while (userChoise);
	}

	protected void selectProjects(Category category) {
		List<Project> projectsFromCategory = projectsStorage.getProjectsFromCategory(category);
		
		int numberOfSelectedProject;
		
		if (projectsFromCategory.size() == 0) {
			consolePrinter.print("There is no any project in selected category.");
			consolePrinter.print(SEPARATOR);
			
			numberOfSelectedProject = 0;
		} else {
			boolean userChoise = true;
			do {
				consolePrinter.printProjects(projectsFromCategory, faqStorage, paymentStorage);
				consolePrinter.print(SEPARATOR);
				consolePrinter.print("Please select project (0 for back to categories): ");
				
				numberOfSelectedProject = consoleScanner.getInt();
	
				if (numberOfSelectedProject < 0 || numberOfSelectedProject > projectsFromCategory.size()) {
					consolePrinter.print("Please, enter the number between 0 and " + projectsFromCategory.size());
					consolePrinter.print(SEPARATOR);
									
				} else if (numberOfSelectedProject != 0) {
					consolePrinter.print("You selected project number : " + numberOfSelectedProject);
					selectedProjectByUser = projectsFromCategory.get(numberOfSelectedProject - 1);
					consolePrinter.print(SEPARATOR);
					consolePrinter.printFullProjectInfo(selectedProjectByUser, faqStorage, paymentStorage);
					consolePrinter.print(SEPARATOR);
					
					activityInsideSelectedProject(selectedProjectByUser);
							
				} else {
					consolePrinter.print("You entered 0. Back to categories.");
					consolePrinter.print(SEPARATOR);
					userChoise = false;
				}
				
			} while (userChoise);
		}

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
		payment.setProjectID(project.getUniqueID());
		project.donateMoney(payment.getDonatingSum());
		paymentStorage.add(payment);
		consolePrinter.printShortProjectInfo(project, faqStorage, paymentStorage);	
	}
	
	protected void askQuestion(Project project) {
		String question = consoleScanner.parseAskingQuestion();
		Faq faq = new Faq(question);
		faq.setProjectID(project.getUniqueID());
		faqStorage.add(faq);
		
		consolePrinter.print(SEPARATOR);
		
		consolePrinter.printShortProjectInfo(project, faqStorage, paymentStorage);
	}
	
	protected void stop() {
		consoleScanner.close();
	}
}
