package ua.com.goit.gojava.kickstarter.launcher;

import ua.com.goit.gojava.kickstarter.control.Kickstarter;
import ua.com.goit.gojava.kickstarter.view.ConsoleInputReader;
import ua.com.goit.gojava.kickstarter.view.ConsolePrinter;

public class RunKickstarter {

	public static void main(String[] args) {

		Kickstarter application = new Kickstarter(new ConsoleInputReader(), new ConsolePrinter());

		application.run();
	}
}
