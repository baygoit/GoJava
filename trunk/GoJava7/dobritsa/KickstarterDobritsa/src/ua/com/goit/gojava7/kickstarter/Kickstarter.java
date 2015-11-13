package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.CategoryPrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.ProjectPrinter;
import ua.com.goit.gojava7.kickstarter.console.QuotePrinter;

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
	private int FIRST = 1;

	public Kickstarter(ConsoleScanner consoleScanner, QuotePrinter quotePrinter, 
			ProjectPrinter projectPrinter, CategoryPrinter categoryPrinter, 
			QuoteStorage quoteStorage, CategoryStorage categoryStorage) {	
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
				Integer selectedProject = chooseProject(selectedCategory);
				if (selectedProject != null) {				
					viewProject(selectedCategory, selectedProject);
				} else {
					break;
				}
			}
		}
	}
	
	public Integer chooseCategory() {
		System.out.println(BORDER);
		System.out.println("\nList of categories:");
		categoryPrinter.printCategories(categoryStorage.getAll());
		System.out.println("\nChoose a category by number (0 for exit): ");
		
		Integer selectedCategory = consoleScanner.getInteger(FIRST, categoryStorage.size());
		if (selectedCategory == null) {
			consoleScanner.close();
			System.out.println("See you soon!");
			System.exit(0);
		}
		return selectedCategory;
	}

	public Integer chooseProject(Integer selectedCategory) {
		System.out.println(BORDER);
		System.out.println("Current category N: " + selectedCategory + "("
				+ categoryStorage.get(selectedCategory - SHIFT_ONE).getName() + ")");
		System.out.println("List of projects:");
		categoryPrinter.printProjects(categoryStorage.get(selectedCategory - SHIFT_ONE).getAll());
		System.out.println("\nChoose a project by number (first to choose another category): ");
		Integer selectedProject = consoleScanner.getInteger(FIRST,
				categoryStorage.get(selectedCategory - SHIFT_ONE).size());
		if (selectedProject == null) {
			return null;
		}
		return selectedProject;
	}

	public void viewProject(Integer selectedCategory, Integer selectedProject) {
		
		System.out.println(BORDER);
		System.out.println("Current project: #" + (selectedProject));
		System.out.println("Current category: " + categoryStorage.get(selectedCategory - 1).getName() + "\n");
		//ProjectPrinter projectPrinter = new ProjectPrinter(
		//		categoryStorage.get(selectedCategory - 1).get(selectedProject - 1));
		projectPrinter.printFull(categoryStorage.get(selectedCategory - 1).get(selectedProject - 1));		
		String text = consoleScanner.getBackOrZero();
		if(text.equals("b")) {
			System.out.println("\nEnter your name:");
			String name = consoleScanner.getString();
			System.out.println("\nEnter your card's number:");
			String card = consoleScanner.getString();
			System.out.println("\nEnter amount:");
			int amount = consoleScanner.getInteger(0, 
					categoryStorage.get(selectedCategory - 1).get(selectedProject - 1).getGoal() - 
					categoryStorage.get(selectedCategory - 1).get(selectedProject - 1).getPledged());
			System.out.println("\nOld amount:" + categoryStorage.get(selectedCategory - 1).get(selectedProject - 1).getPledged());
			categoryStorage.get(selectedCategory - 1).get(selectedProject - 1).addToPledged(amount);
			System.out.println("\nOld amount:" + categoryStorage.get(selectedCategory - 1).get(selectedProject - 1).getPledged());
			
		}
	}

	public void shutdown() {
		consoleScanner.close();
	}

}
