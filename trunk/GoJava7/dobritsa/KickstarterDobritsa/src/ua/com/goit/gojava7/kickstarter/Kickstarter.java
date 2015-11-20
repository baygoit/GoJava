package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
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

	private String BORDER = "\n________________________________________________________";

	public Kickstarter(QuoteStorage quoteStorage, CategoryStorage categoryStorage) {
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	public void run() {
		quotePrinter.printRandomQuote(quoteStorage);
		do {
			currentCategory = chooseCategory(categoryStorage);
			if (currentCategory == null) {
				printer.print("See you soon!");
				break;
			}
			do {
				currentProject = chooseProject(currentCategory);
				if (currentProject != null) {
					printer.print(BORDER + "\nCurrent category: " + currentCategory.getName() + "\nCurrent project: #"
							+ (currentCategory.getAll().indexOf(currentProject) + 1) + "\n");
					viewProject(currentProject);
				}
			} while (currentProject != null);

		} while (currentCategory != null);
	}

	public Category chooseCategory(CategoryStorage categoryStorage) {
		printAboutCategories(categoryStorage);
		return setCurrentCategory(categoryStorage);
	}

	public void printAboutCategories(CategoryStorage categoryStorage) {
		printer.print(BORDER + "\nList of categories:\n");
		categoryPrinter.printCategories(categoryStorage.getAll());
		printer.print("\nChoose a category by number ('0' for exit): ");
	}

	public Category setCurrentCategory(CategoryStorage categoryStorage) {
		int numberOfCategory = consoleScanner.getInt(0, categoryStorage.size());
		if (numberOfCategory == 0)
			return null;	
		return categoryStorage.get(numberOfCategory - 1);
	}

	public Project chooseProject(Category category) {	
		printAboutProjects(category);		
		return setCurrentProject(category);
	}

	public void printAboutProjects(Category category) {
		printer.print(BORDER + "\nCurrent category: " + category.getName() + "\nList of projects:");
		projectPrinter.printProjects(category.getAll());
		printer.print("\nChoose a project by number ('0' to choose another category): ");
	}

	public Project setCurrentProject(Category category) {
		int numberOfProject = consoleScanner.getInt(0, category.size());
		if (numberOfProject == 0)
			return null;		
		return category.get(numberOfProject - 1);
	}

	public void viewProject(Project project) { 
		boolean exit = false;
		while (!exit) {	
			projectPrinter.printFull(project);
			exit = chooseOptionOfProject(project);
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
		consoleScanner.getString();
		printer.print("\nEnter your card's number:");
		consoleScanner.getString();
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
			printer.print(BORDER + "\n");
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
