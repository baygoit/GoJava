package ua.home.kickstarter.main;

import ua.home.kickstarter.controller.CategoriesController;
import ua.home.kickstarter.controller.ProjectsController;
import ua.home.kickstarter.controller.QuotationsController;
import ua.home.kickstarter.engine.Kickstarter;
import ua.home.kickstarter.view.ConsoleInput;
import ua.home.kickstarter.view.ConsoleOutput;
import ua.home.kickstarter.view.Display;

public class Main {

	public static void main(String[] args) {
		QuotationsController quotationsController = new QuotationsController();
		ConsoleInput consoleInput = new ConsoleInput();
		ProjectsController projectsController = new ProjectsController();
		CategoriesController categoriesController = new CategoriesController();
		ConsoleOutput consoleOutput = new ConsoleOutput();
		Display display = new Display(quotationsController, categoriesController, projectsController, consoleOutput);
		Kickstarter kickstarter = new Kickstarter(quotationsController, categoriesController, projectsController,
				consoleOutput, consoleInput, display);
		kickstarter.run();
	}
}