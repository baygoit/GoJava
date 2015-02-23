package ua.home.kickstarter.main;

import ua.home.kickstarter.engine.Kickstarter;
import ua.home.kickstarter.view.ConsoleInput;
import ua.home.kickstarter.view.ConsoleOutput;
import ua.home.kickstarter.view.Display;

public class Main {

	public static void main(String[] args) {
		ConsoleInput consoleInput = new ConsoleInput();
		ConsoleOutput consoleOutput = new ConsoleOutput();
		Display display = new Display(consoleOutput);
		Kickstarter kickstarter = new Kickstarter(consoleOutput, consoleInput, display);
		kickstarter.run();
	}
}