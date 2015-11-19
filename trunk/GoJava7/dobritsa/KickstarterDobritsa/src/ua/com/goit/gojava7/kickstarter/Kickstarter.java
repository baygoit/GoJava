package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.CategoryPrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.Printer;
import ua.com.goit.gojava7.kickstarter.console.ProjectPrinter;
import ua.com.goit.gojava7.kickstarter.console.QuotePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private ConsoleScanner consoleScanner = new ConsoleScanner();
	private Printer printer = new Printer();

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
		do {
			chooseCategory();
			if (numberOfCategory == 0) {
				System.out.println("See you soon!");
				break;
			}
			do {
				chooseProject();
				if (numberOfProject != 0)
					printer.print(BORDER + "\nCurrent category: " + currentCategory.getName() + "\nCurrent project: #"
							+ (numberOfProject) + "\n");					
					viewProject(currentProject);
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

	public void viewProject(Project project) { 
		boolean exit = false;
		while (!exit) {
			projectPrinter.printFull(project);
			exit = chooseOptionOfProject(currentProject);
		}
	}

	public boolean chooseOptionOfProject(Project project) { 
		String text = consoleScanner.getOption();
		if (text.equals("b")) { 
			donate(project);
		}
		if (text.equals("a")) {
			addQuestion(project);
		}
		if (text.equals("0")) {
			return true;
		}
		return false;
	}

	public void donate(Project project) {
		printer.print(BORDER + "\n\nEnter your name:");
		consoleScanner.getName();
		printer.print("\nEnter your card's number:");
		consoleScanner.getCreditCard();
		chooseReward(project);		
	}

	public void chooseReward(Project project) {
		printer.print("\nLet's choose your reward!\n");
		List<Reward> rewards = new ArrayList<>(project.getRewards());
		projectPrinter.printRewards(rewards);
		int numberOfReward = consoleScanner.getInt(0, rewards.size() + 1);
		if (numberOfReward == 0)
			return;
		if (numberOfReward == (rewards.size() + 1)) {
			int minDonation = 1;
			int maxDonation = project.getGoal() - project.getPledged();
			printer.print("\nEnter amount from " + minDonation + " to " + maxDonation + " :");
			int amount = consoleScanner.getInt(minDonation, maxDonation);
			printer.print("\nIt was collected before: $" + project.getPledged());
			doDonate(project, amount);
			printer.print("Now collected: $" + project.getPledged());
		} else {
			printer.print("\nAmount of your donation is $" + rewards.get(numberOfReward - 1).getAmount());
			printer.print("It was collected before: $" + project.getPledged());
			doDonate(project, project.getRewards().get(numberOfReward - 1).getAmount());
			printer.print("Now collected: $" + project.getPledged());
		}
	}
	
	public void doDonate(Project project, int amount) {
		project.addToPledged(amount);
	}

	
	public void addQuestion(Project project) {
		printer.print("Ask your question about project: ");
		project.addQuestion(new Question(consoleScanner.getString()));
	}

	public void shutdown() {
		consoleScanner.close();
	}	
}
