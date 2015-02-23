package ua.home.kickstarter.controller;

import ua.home.kickstarter.model.DaoFactory;
import ua.home.kickstarter.controller.Kickstarter;
import ua.home.kickstarter.view.ConsoleInput;
import ua.home.kickstarter.view.ConsoleOutput;
import ua.home.kickstarter.view.Display;

public class Main {

	public static void main(String[] args) {
		ConsoleInput consoleInput = new ConsoleInput();
		ConsoleOutput consoleOutput = new ConsoleOutput();
		Display display = new Display(consoleOutput);
		DaoFactory daoFactory = new DaoFactory();
		Kickstarter kickstarter = new Kickstarter(consoleOutput, consoleInput, display, daoFactory);
		kickstarter.run();
	}
}