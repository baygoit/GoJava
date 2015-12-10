package ua.com.goit.gojava7.kickstarter.controller.console;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class Kickstarter {
	private static final String SEPARATOR = "**********************************************************************";
	private static final String MOVE_TO_THE_NEXT_LINE = "\n";
	
	ConsolePrinter consolePrinter;
	ConsoleScanner consoleScanner;
	
	Category selectedCategoryByUser;
	Project selectedProjectByUser;
	
	CategoryDao categories;
	ProjectDao projects;
	QuoteDao quotes;
	PaymentDao payments;
	FaqDao faqs;
	RewardDao rewards;
	
	public Kickstarter(ConsolePrinter consolePrinter, ConsoleScanner consoleScanner, 
			CategoryDao categoryDao, ProjectDao projectDao, QuoteDao quoteDao, PaymentDao paymentDao, FaqDao faqDao, RewardDao rewards) {
		this.consolePrinter = consolePrinter;
		this.consoleScanner = consoleScanner;
		this.categories = categoryDao;
		this.projects = projectDao;
		this.quotes = quoteDao;
		this.payments = paymentDao;
		this.faqs = faqDao;
		this.rewards = rewards;
	}

	public void start() {
		consolePrinter.print(quotes.getRandomQuote());
		selectCategory();
	}
	
	protected void selectCategory() {
		
		int selectedNumber;
		boolean userChoise = true;
		
		do {
			consolePrinter.printCategories(categories);
			consolePrinter.print(SEPARATOR);
			consolePrinter.print("Please select category (0 for exit): ");
			selectedNumber = consoleScanner.getInt();

			if (selectedNumber < 0 || selectedNumber > categories.getSize()) {
				consolePrinter.print("Please, enter the number between 0 and " + categories.getSize());
				consolePrinter.print(SEPARATOR);
				
			} else if (selectedNumber != 0) {
				consolePrinter.print("You selected category number : " + selectedNumber);
				selectedCategoryByUser = categories.getAll().get(selectedNumber - 1);
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
		List<Project> projectsFromCategory = projects.getProjectsFromCategory(category.getUniqueID());
		
		int numberOfSelectedProject;
		
		if (projectsFromCategory.size() == 0) {
			consolePrinter.print("There is no any project in selected category.");
			consolePrinter.print(SEPARATOR);
			
			numberOfSelectedProject = 0;
		} else {
			boolean userChoise = true;
			do {
				consolePrinter.printProjects(projectsFromCategory, faqs, payments);
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
					consolePrinter.printFullProjectInfo(selectedProjectByUser, faqs, payments);
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
				consolePrinter.print(SEPARATOR);
			}
			
		} while (choseNumber != 0);
		
		consolePrinter.print("You entered 0. Back to projects.");
		consolePrinter.print(SEPARATOR);
	}
	
	protected void donateMoneyForProject(Project project) {
		String userName = consoleScanner.parseUserName();
		long cardNumber = consoleScanner.parseCreditCardNumber();
		providePaymentMethods(project, userName, cardNumber);		
		consolePrinter.printShortProjectInfo(project, faqs, payments);	
	}
	
	protected void askQuestion(Project project) {
		String question = consoleScanner.parseAskingQuestion();
		Faq faq = new Faq();
		faq.setQuestion(question);
		faq.setProjectID(project.getUniqueID());
		faqs.add(faq);
		consolePrinter.print(SEPARATOR);
		consolePrinter.printShortProjectInfo(project, faqs, payments);
	}
	
	protected void providePaymentMethods(Project project, String userName, Long creditCardNumber) {
		StringBuilder paymentMenu = new StringBuilder();
		
		int projectId = project.getUniqueID();
		
		List<Reward> projectRewards = rewards.getProjectsRewards(projectId);
		
		int stepsCoutner = 0;
		
		if (projectRewards.isEmpty()) {
			stepsCoutner ++;
			paymentMenu.
				append("Please select option : ").
				append(MOVE_TO_THE_NEXT_LINE).
				append(stepsCoutner + ". Donate any amount that you want");
		} else {
			paymentMenu.
				append("Please select option : ");
			
			for (Reward reward : projectRewards) {
				stepsCoutner ++;
				paymentMenu.
					append(MOVE_TO_THE_NEXT_LINE).
					append(stepsCoutner + ". Donate " + reward.getDonatingSum() + "$ : " + reward.getDescription());
			}
			
			stepsCoutner ++;
			paymentMenu.
				append(MOVE_TO_THE_NEXT_LINE).
				append(stepsCoutner + ". Donate any amount that you want");
		}
			
		consolePrinter.print(paymentMenu.toString());
		
		int userNumber;
		do {
			userNumber = consoleScanner.getInt();
			
			if (userNumber > 0 && userNumber < stepsCoutner) {
				
				consolePrinter.print("Thank you. You donated " + projectRewards.get(userNumber - 1).getDonatingSum() + "$.");
				consolePrinter.print(SEPARATOR);
				savePaymentInfo(userName, creditCardNumber, projectRewards.get(userNumber - 1).getDonatingSum(), project.getUniqueID(), payments);
				
			} else if (userNumber == stepsCoutner) {
				consolePrinter.print("Please enter donating sum : ");
				
				int donatingSum = consoleScanner.getInt();
				
				consolePrinter.print("Thank you. You donated " + donatingSum + "$.");
				consolePrinter.print(SEPARATOR);
				savePaymentInfo(userName, creditCardNumber, donatingSum, project.getUniqueID(), payments);
				
			} else {
				consolePrinter.print("Please select numbers between 1 and " + stepsCoutner);
				userNumber = 0;
			}
		} while (userNumber == 0);
	}
	
	public void savePaymentInfo(String userName, long creditCardNumber, 
			int donatingSum, int projectID, PaymentDao paymentDao) {
		
		Payment payment = new Payment();
		payment.setUserName(userName);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setDonatingSum(donatingSum);
		payment.setProjectID(projectID);
		paymentDao.add(payment);
	}
		
	public void stop() {
		consoleScanner.close();
	}
}
