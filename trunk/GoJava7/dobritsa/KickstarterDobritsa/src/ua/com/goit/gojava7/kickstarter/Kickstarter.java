package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.CategoryPrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.ProjectPrinter;
import ua.com.goit.gojava7.kickstarter.console.QuotePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private ConsoleScanner consoleScanner = new ConsoleScanner();;

	private CategoryPrinter categoryPrinter = new CategoryPrinter();
	private ProjectPrinter projectPrinter = new ProjectPrinter();
	private QuotePrinter quotePrinter = new QuotePrinter();

	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;

	private String BORDER = "\n________________________________________________________";
	private int NUMBER_OF_FIRST_PROJECT = 1;
	private Project currentProject = null;
	private Category currentCategory = null;
	private int numberOfCategory;
	private int indexOfCategory;
	private int numberOfProject;
	private int indexOfProject;

	public Kickstarter(QuoteStorage quoteStorage, CategoryStorage categoryStorage) {
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	public void run() {
		quotePrinter.printRandomQuote(quoteStorage);
		while (true) {
			chooseCategory();
			while (numberOfCategory != 0) {
				if (currentCategory.getAll().size() == 0) {
					System.out.println("No projects in this categories.");
					break;
				} else {
					chooseProject();
					if (numberOfProject != 0) {
						viewProject();
					} else {
						break;
					}
				}
			}
		}
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
		if (numberOfCategory == 0) {
			System.out.println("See you soon!");
			consoleScanner.close();
			System.exit(0);
		}
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
		categoryPrinter.printProjects(currentCategory.getAll());
		System.out.println("\nChoose a project by number ('0' to choose another category): ");
	}

	public void setCurrentProject() {
		numberOfProject = consoleScanner.getInt(NUMBER_OF_FIRST_PROJECT, currentCategory.size());
		if(numberOfProject == 0) return;
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
		System.out.println("\nEnter your name:");
		String name = consoleScanner.getName();
		System.out.println("\nEnter your card's number:");
		String card = consoleScanner.getCreditCard();
		int minDonation = 1;
		int maxDonation = currentProject.getGoal() - currentProject.getPledged();
		System.out.println("\nEnter amount from " + minDonation + " to " + maxDonation + " :");
		int amount = consoleScanner.getInt(minDonation, maxDonation);
		System.out.println("\nIt was collected before:" + currentProject.getPledged());
		currentProject.addToPledged(amount);
		System.out.println("\nNow collected:" + currentProject.getPledged());
	}

	public void ask() {
		System.out.println("Ask your qouestion about project: ");
		currentProject.addQuestion(consoleScanner.getString());
	}

	public void shutdown() {
		consoleScanner.close();
	}

}
