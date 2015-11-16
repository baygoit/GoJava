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
	private ConsoleScanner consoleScanner;

	private CategoryPrinter categoryPrinter;
	private ProjectPrinter projectPrinter;
	private QuotePrinter quotePrinter;

	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;

	private String BORDER = "\n________________________________________________________";
	private int SHIFT_ONE = 1;
	private int ZERO = 1;
	private Project currentProject = null;
	private Category currentCategory = null;

	public Kickstarter(ConsoleScanner consoleScanner, QuotePrinter quotePrinter, ProjectPrinter projectPrinter,
			CategoryPrinter categoryPrinter, QuoteStorage quoteStorage, CategoryStorage categoryStorage) {
		this.consoleScanner = consoleScanner;
		this.categoryPrinter = categoryPrinter;
		this.projectPrinter = projectPrinter;
		this.quotePrinter = quotePrinter;
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	public void run() {
		quotePrinter.printRandomQuote(quoteStorage);
		while (true) {
			Integer selectedCategory = chooseCategory();
			while (selectedCategory != 0) {
				currentCategory = categoryStorage.get(selectedCategory - SHIFT_ONE);
				if (currentCategory.getAll().size() == 0) {
					System.out.println("No projects in this categories.");
					break;
				} else {
					Integer selectedProject = chooseProject(selectedCategory);
					if (selectedProject != null) {
						currentProject = currentCategory.get(selectedProject - SHIFT_ONE);
						viewProject(selectedCategory, selectedProject);
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

		Integer selectedCategory = consoleScanner.getInteger(ZERO, categoryStorage.size());
		if (selectedCategory == null) {
			consoleScanner.close();
			System.out.println("See you soon!");
			System.exit(0);
		}
		return selectedCategory;
	}

	public Integer chooseProject(Integer selectedCategory) {
		System.out.println(BORDER);
		System.out.println("Current category: #" + selectedCategory + "("
				+ categoryStorage.get(selectedCategory - SHIFT_ONE).getName() + ")");
		System.out.println("List of projects:");
		categoryPrinter.printProjects(currentCategory.getAll());
		System.out.println("\nChoose a project by number ('0' to choose another category): ");
		Integer selectedProject = consoleScanner.getInteger(ZERO, currentCategory.size());
		if (selectedProject == null) {
			return null;
		}
		return selectedProject;
	}

	public void viewProject(Integer selectedCategory, Integer selectedProject) {
		System.out.println(BORDER);
		System.out.println("Current category: " + currentCategory.getName());
		System.out.println("Current project: #" + (selectedProject) + "\n");
		projectPrinter.printFull(currentProject);
		String text = consoleScanner.getBackOrZero();
		if (text.equals("b")) {
			System.out.println("\nEnter your name:");
			String name = consoleScanner.getName();
			System.out.println("\nEnter your card's number:");
			String card = consoleScanner.getCreditCard();
			int minDonation = 1;
			int maxDonation = currentProject.getGoal() - currentProject.getPledged();
			System.out.println("\nEnter amount from " + minDonation + " to " + maxDonation + " :");
			int amount = consoleScanner.getInteger(minDonation, maxDonation);
			System.out.println("\nIt was collected before:" + currentProject.getPledged());
			currentProject.addToPledged(amount);
			System.out.println("\nNow collected:" + currentProject.getPledged());
		}
	}

	public void shutdown() {
		consoleScanner.close();
	}

}
