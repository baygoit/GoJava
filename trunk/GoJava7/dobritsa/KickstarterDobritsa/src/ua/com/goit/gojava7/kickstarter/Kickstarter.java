package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.CategoryPrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.Printer;
import ua.com.goit.gojava7.kickstarter.console.ProjectPrinter;
import ua.com.goit.gojava7.kickstarter.console.QuotePrinter;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.RewardStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class Kickstarter {
	private ConsoleScanner consoleScanner = new ConsoleScanner();
	private Printer printer = new Printer();

	private CategoryPrinter categoryPrinter = new CategoryPrinter();
	private ProjectPrinter projectPrinter = new ProjectPrinter();
	private QuotePrinter quotePrinter = new QuotePrinter();

	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;
	private ProjectStorage projectStorage;
	private QuestionStorage questionsStorage;
	private RewardStorage rewardStorage;

	private Project currentProject = null;
	private Category currentCategory = null;

	private String BORDER = "\n________________________________________________________";

	public Kickstarter(QuoteStorage quoteStorage, CategoryStorage categoryStorage, ProjectStorage projectStorage,
			QuestionStorage questionsStorage, RewardStorage rewardStorage) {
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
		this.projectStorage = projectStorage;
		this.questionsStorage = questionsStorage;
		this.rewardStorage = rewardStorage;
	}

	public void run() {
		// TODO random
		// quotePrinter.print(quoteStorage.getRandomQuote());
		quotePrinter.print(quoteStorage.get(1));
		do {
			currentCategory = chooseCategory(categoryStorage);
			if (currentCategory == null) {
				printer.print("See you soon!");
				break;
			}
			do {
				currentProject = chooseProject(currentCategory, projectStorage);
				if (currentProject != null) {
					printer.print(BORDER + "\nCurrent category: " + currentCategory.getName()
							+ "\nCurrent project: #_____\n");
					viewProject(currentProject);
				}
			} while (currentProject != null);

		} while (currentCategory != null);
	}

	public Category chooseCategory(CategoryStorage categoryStorage) {		
		printer.print(BORDER + "\nList of categories:\n");
		categoryPrinter.printCategories(categoryStorage.getAll());
		printer.print("\nChoose a category by number ('0' for exit): ");
		return setCurrentCategory(categoryStorage);
	}
	
	public Category setCurrentCategory(CategoryStorage categoryStorage) {
		int numberOfCategory = consoleScanner.getInt(0, categoryStorage.size());
		if (numberOfCategory == 0)
			return null;
		return categoryStorage.getByNumber(numberOfCategory);
	}

	public Project chooseProject(Category category, ProjectStorage projectStorage) {
		List<Project> projectsInCategory = new ArrayList<>();
		projectsInCategory = projectStorage.getByCategory(category.getName());
		printer.print(BORDER + "\nCurrent category: " + category.getName() + "\nList of projects:");		
		projectPrinter.printProjects(projectsInCategory);
		printer.print("\nChoose a project by number ('0' to choose another category): ");
		return setCurrentProject(projectsInCategory);
	}


	public Project setCurrentProject(List<Project> projects) {
		int numberOfProject = consoleScanner.getInt(0, projects.size());
		if (numberOfProject == 0)
			return null;
		return projects.get(numberOfProject - 1);
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
		if (text.equals("p")) {
			pledge(project);
		}
		if (text.equals("a")) {
			addQuestion(project);
		}
		if (text.equals("0")) {
			return true;
		}
		return false;
	}

	public void pledge(Project project) {
		printer.print(BORDER + "\n\nEnter your name:");
		consoleScanner.getString();
		printer.print("\nEnter your card's number:");
		consoleScanner.getString();
		chooseReward(project);
	}

	public void chooseReward(Project project) {
		printer.print("\nLet's choose your reward!\n");				
		List<Reward> rewardsInProject = new ArrayList<>();				
		rewardsInProject = rewardStorage.getByProject(project.getName());	
		projectPrinter.printRewards(rewardsInProject);
		int numberOfReward = consoleScanner.getInt(0, rewardsInProject.size() + 1);
		if (numberOfReward == 0) {
			printer.print(BORDER);
			return;
		} else if (numberOfReward == (rewardsInProject.size() + 1)) {
			int minDonation = 1;
			int maxDonation = project.getGoal() - project.getPledged();
			printer.print("\nEnter amount from " + minDonation + " to " + maxDonation + " :");
			int amount = consoleScanner.getInt(minDonation, maxDonation);
			printer.print("\nAmount of your donation is $" + amount);
			printer.print("It was collected before: $" + project.getPledged());
			project = pledge(project, amount);
			printer.print("Now collected: $" + project.getPledged());
			printer.print(BORDER);
		} else {
			printer.print("\nAmount of your donation is $" + rewardsInProject.get(numberOfReward - 1).getAmount());
			printer.print("It was collected before: $" + project.getPledged());
			pledge(project, rewardsInProject.get(numberOfReward - 1).getAmount());
			printer.print("Now collected: $" + project.getPledged());
			printer.print(BORDER);
		}
	}

	public Project pledge(Project project, int amount) {
		projectStorage.updatePledged(project, amount);
		project.setPledged(projectStorage.getPledged(project.getName()));
		return project;		
	}

	public void addQuestion(Project project) {
		printer.print("Ask your question about project: ");
		//project.addQuestion(new Question(consoleScanner.getString()));
	}

	public void shutdown() {
		consoleScanner.close();
	}
}
