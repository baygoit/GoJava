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
	private int SHIFT_ONE = 1;
	private int ZERO = 1;
	private Project currentProject = null;
	private Category currentCategory = null;
	private int numberOgCategory;

	public Kickstarter(QuoteStorage quoteStorage, CategoryStorage categoryStorage) {
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	public void run() {
		quotePrinter.printRandomQuote(quoteStorage);
		while (true) {
			int numberOfCategory = chooseCategory();
			Integer indexOfSelectedCategory = numberOfCategory - 1;
			while (numberOfCategory != 0) {
				currentCategory = categoryStorage.get(indexOfSelectedCategory);
				if (currentCategory.getAll().size() == 0) {
					System.out.println("No projects in this categories.");
					break;
				} else {
					Integer selectedProject = chooseProject(numberOfCategory);
					// Integer indexOfSelectedProject = selectedProject - 1;
					if (selectedProject != 0) {
						currentProject = currentCategory.get(selectedProject - SHIFT_ONE);
						viewProject(numberOfCategory, selectedProject);
					} else {
						break;
					}
				}
			}
		}
	}

	public Integer chooseCategory() {
		System.out.println(BORDER);
		System.out.println("\nList of categories:");
		categoryPrinter.printCategories(categoryStorage.getAll());
		System.out.println("\nChoose a category by number ('0' for exit): ");

		int numberOfCategory = consoleScanner.getInt(ZERO, categoryStorage.size());
		if (numberOfCategory == 0) {
			System.out.println("See you soon!");
			consoleScanner.close();
			System.exit(0);
		}
		return numberOfCategory;
	}

	public Integer chooseProject(Integer numberOfCategory) {
		System.out.println(BORDER);
		System.out.println("Current category: #" + numberOfCategory + "("
				+ categoryStorage.get(numberOfCategory - SHIFT_ONE).getName() + ")");
		System.out.println("List of projects:");
		categoryPrinter.printProjects(currentCategory.getAll());
		System.out.println("\nChoose a project by number ('0' to choose another category): ");
		int numberOfProject = consoleScanner.getInt(ZERO, currentCategory.size());
		if (numberOfProject == 0) {
			return 0;
		}
		return numberOfProject;
	}

	public void viewProject(int selectedCategory, int numberOfProject) {
		printAboutProject(currentCategory.getName(), numberOfProject);
		chooseOptionOfProject();
	}

	public void printAboutProject(String categoryName, int numberProject) {
		System.out.println(BORDER
				+ "\nCurrent category: " + categoryName
				+ "\nCurrent project: #" + (numberProject) + "\n");
		projectPrinter.printFull(currentProject);
	}

	public void chooseOptionOfProject() {
		String text = consoleScanner.getMenu();
		if (text.equals("b")) {
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
		if (text.equals("a")) {
			currentProject.addQuestion(getQuestion());
		}
	}

	public String getQuestion() {
		System.out.println("Ask your qouestion about project: ");
		return consoleScanner.getString();
	}

	public void shutdown() {
		consoleScanner.close();
	}

}
