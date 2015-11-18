package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.CategoryPrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.ProjectPrinter;
import ua.com.goit.gojava7.kickstarter.console.QuotePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private ConsoleScanner consoleScanner = new ConsoleScanner();;

	private CategoryPrinter categoryPrinter = new CategoryPrinter();
	private ProjectPrinter projectPrinter = new ProjectPrinter();
	private QuotePrinter quotePrinter = new QuotePrinter();

	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;

	private Project currentProject = null;
	private Category currentCategory = null;

	private int numberOfCategory;
	private int indexOfCategory;
	private int numberOfProject;
	private int indexOfProject;

	private String BORDER = "\n________________________________________________________";
	private int NUMBER_OF_FIRST_PROJECT = 1;

	public Kickstarter(QuoteStorage quoteStorage, CategoryStorage categoryStorage) {
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	public void run() {
		quotePrinter.printRandomQuote(quoteStorage);
		do {System.out.println (new java.util.Date ().toLocaleString());
			chooseCategory();
			if (numberOfCategory == 0) {
				System.out.println("See you soon!");
				break;
			}
			do {
				chooseProject();
				if (numberOfProject != 0)
					viewProject();
			} while (numberOfProject != 0);

		} while (numberOfCategory != 0);
	}

	public void chooseCategory() {
		printAboutCategories();
		setCurrentCategory();
	}

	public void printAboutCategories() {
		System.out.println(BORDER + "\nList of categories:\n");
		categoryPrinter.printCategories(categoryStorage.getAll());
		System.out.println("\nChoose a category by number ('0' for exit): ");
	}

	public void setCurrentCategory() {
		numberOfCategory = consoleScanner.getInt(NUMBER_OF_FIRST_PROJECT, categoryStorage.size());
		if (numberOfCategory == 0)
			return;
		indexOfCategory = numberOfCategory - 1;
		currentCategory = categoryStorage.get(indexOfCategory);
	}

	public void chooseProject() {
		printAboutProjects();
		setCurrentProject();
	}

	public void printAboutProjects() {
		System.out.println(BORDER + "\nCurrent category: #" + numberOfCategory + "(" + currentCategory.getName() + ")"
				+ "\nList of projects:");
		projectPrinter.printProjects(currentCategory.getAll());
		System.out.println("\nChoose a project by number ('0' to choose another category): ");
	}

	public void setCurrentProject() {
		numberOfProject = consoleScanner.getInt(NUMBER_OF_FIRST_PROJECT, currentCategory.size());
		if (numberOfProject == 0)
			return;
		indexOfProject = numberOfProject - 1;
		currentProject = categoryStorage.get(indexOfCategory).get(indexOfProject);
	}

	public void viewProject() {
		boolean exit = false;
		while (!exit) {
			printAboutProject();
			exit = chooseOptionOfProject();
		}
	}

	public void printAboutProject() {
		System.out.println(BORDER + "\nCurrent category: " + currentCategory.getName() + "\nCurrent project: #"
				+ (numberOfProject) + "\n");
		projectPrinter.printFull(currentProject);
	}

	public boolean chooseOptionOfProject() {
		String text = consoleScanner.getOption();
		if (text.equals("b")) {
			donate();
		}
		if (text.equals("a")) {
			ask();
		}
		if (text.equals("0")) {
			return true;
		}
		return false;
	}

	public void donate() {
		System.out.println(BORDER + "\n\nEnter your name:");
		consoleScanner.getName();
		System.out.println("\nEnter your card's number:");
		consoleScanner.getCreditCard();
		chooseReward();		
	}

	public void chooseReward() {
		System.out.println("\nLet's choose your reward!\n");
		List<Reward> rewards = new ArrayList<>(currentProject.getRewards());
		projectPrinter.printRewards(rewards);
		int numberOfReward = consoleScanner.getInt(0, rewards.size() + 1);
		if (numberOfReward == 0)
			return;
		if (numberOfReward == (rewards.size() + 1)) {
			int minDonation = 1;
			int maxDonation = currentProject.getGoal() - currentProject.getPledged();
			System.out.println("\nEnter amount from " + minDonation + " to " + maxDonation + " :");
			int amount = consoleScanner.getInt(minDonation, maxDonation);
			System.out.println("\nIt was collected before: $" + currentProject.getPledged());
			doDonate(amount);
			System.out.println("Now collected: $" + currentProject.getPledged());
		} else {
			System.out.println("\nAmount of your donation is $" + rewards.get(numberOfReward - 1).getAmount());
			System.out.println("It was collected before: $" + currentProject.getPledged());
			doDonate(currentProject.getRewards().get(numberOfReward - 1).getAmount());
			System.out.println("Now collected: $" + currentProject.getPledged());
		}
	}
	
	public void doDonate(int amount) {
		currentProject.addToPledged(amount);
	}

	public void ask() {
		System.out.println("Ask your question about project: ");
		currentProject.addQuestion(new Question((new java.util.Date ().toLocaleString()), consoleScanner.getString()));
	}

	public void shutdown() {
		consoleScanner.close();
	}

}
