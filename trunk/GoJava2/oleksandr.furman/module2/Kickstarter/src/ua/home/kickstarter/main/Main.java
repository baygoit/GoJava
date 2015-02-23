package ua.home.kickstarter.main;

import ua.home.kickstarter.controller.ProjectsController;
import ua.home.kickstarter.engine.Kickstarter;
import ua.home.kickstarter.view.ConsoleInput;
import ua.home.kickstarter.view.ConsoleOutput;
import ua.home.kickstarter.view.Display;

public class Main {

	public static void main(String[] args) {
		ConsoleInput consoleInput = new ConsoleInput();
		ProjectsController projectsController = new ProjectsController();
		ConsoleOutput consoleOutput = new ConsoleOutput();
		Display display = new Display(projectsController, consoleOutput);
		Kickstarter kickstarter = new Kickstarter(projectsController, consoleOutput, consoleInput, display);
		kickstarter.run();
	}
}