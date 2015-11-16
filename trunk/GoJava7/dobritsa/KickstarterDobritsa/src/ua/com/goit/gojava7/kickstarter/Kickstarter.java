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
			indexOfCategory = numberOfCategory - 1;
			while (numberOfCategory != 0) {
				//currentCategory = categoryStorage.get(indexOfCategory);				
				if (currentCategory.getAll().size() == 0) {
					System.out.println("No projects in this categories.");
					break;
				} else {
					chooseProject();					
					if (numberOfProject != 0) {
						indexOfProject = numberOfProject - 1;
						//currentProject = currentCategory.get(indexOfProject);
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
		System.out.println(BORDER +
				"\nList of categories:");	
		categoryPrinter.printCategories(categoryStorage.getAll());
		System.out.println("\nChoose a category by number ('0' for exit): ");
	}
	
	public void setCurrentCategory() {
		numberOfCategory = consoleScanner.getInt(ZERO, categoryStorage.size());
		if (numberOfCategory == 0) {
			System.out.println("See you soon!");
			consoleScanner.close();
			System.exit(0);
		}
		currentCategory = categoryStorage.get(numberOfCategory);
	}

	public void chooseProject() {
		printAboutProjects();
		setCurrentProject();	
	}
	
	public void printAboutProjects() {
		System.out.println(BORDER
				+ "\nCurrent category: #" + numberOfCategory + "(" + currentCategory.getName() + ")"
				+ "List of projects:");	
		categoryPrinter.printProjects(currentCategory.getAll());
		System.out.println("\nChoose a project by number ('0' to choose another category): ");
	}
	
	public void setCurrentProject() {
		numberOfProject = consoleScanner.getInt(ZERO, currentCategory.size());
		currentProject = categoryStorage.get(numberOfCategory).get(numberOfProject);
	}
	

	public void viewProject() {
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
