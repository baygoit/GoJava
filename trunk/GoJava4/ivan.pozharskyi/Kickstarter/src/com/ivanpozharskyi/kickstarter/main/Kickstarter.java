package com.ivanpozharskyi.kickstarter.main;

import com.ivanpozharskyi.kickstarter.datastorage.Category;
import com.ivanpozharskyi.kickstarter.datastorage.CategoryStorage;
import com.ivanpozharskyi.kickstarter.datastorage.Project;
import com.ivanpozharskyi.kickstarter.datastorage.ProjectStorage;
import com.ivanpozharskyi.kickstarter.datastorage.QuotesStorage;
import com.ivanpozharskyi.kickstarter.engine.ConsolePrinter;
import com.ivanpozharskyi.kickstarter.engine.ConsoleReader;
import com.ivanpozharskyi.kickstarter.engine.MenuController;
import com.ivanpozharskyi.kickstarter.engine.Printer;
import com.ivanpozharskyi.kickstarter.engine.Readable;

public class Kickstarter {
	private Printer printer;
	private Readable reader;
	private ConsolePrinter consolePrinter;
	private ConsoleReader consoleReader;
	private MenuController menuController;
	private QuotesStorage quotesStorage;
	private CategoryStorage categoryStorage;
	private ProjectStorage projectStorage;

	Kickstarter() {

		categoryStorage = new CategoryStorage();
		Category category1 = new Category("1cetagory"); // TO DO
														// addAllCategories()
		Category category2 = new Category("2cetagory");
		Category category3 = new Category("3cetagory");
		categoryStorage.addCategory(category1);
		categoryStorage.addCategory(category2);
		categoryStorage.addCategory(category3);

		// Project(String name, int moneyGot, int moneyNeed, int daysLeft)

		projectStorage = new ProjectStorage();
		projectStorage.addProject(new Project("Project1", 1000, 200, 15,
				category1));
		projectStorage.addProject(new Project("Project2", 800, 300, 25,
				category1));
		projectStorage.addProject(new Project("Project3", 700, 100, 35,
				category1));

		projectStorage.addProject(new Project("Project1", 3000, 200, 95,
				category2));
		projectStorage.addProject(new Project("Project2", 4000, 300, 85,
				category2));
		projectStorage.addProject(new Project("Project3", 5000, 400, 75,
				category2));

		projectStorage.addProject(new Project("Project1", 6000, 500, 65,
				category3));
		projectStorage.addProject(new Project("Project2", 7000, 800, 55,
				category3));
		projectStorage.addProject(new Project("Project13", 8000, 900, 45,
				category3));

		menuController = new MenuController(categoryStorage, projectStorage,
				new ConsolePrinter(), new ConsoleReader());
		menuController.chooseMenu();

	}

	public static void main(String[] args) {
		Kickstarter kick = new Kickstarter();

	}

}
