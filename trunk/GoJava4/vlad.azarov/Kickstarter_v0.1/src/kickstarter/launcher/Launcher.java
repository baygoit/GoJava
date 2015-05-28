package kickstarter.launcher;

import kickstarter.control.Kickstarter;
import kickstarter.printer.ConsolePrinter;
import kickstarter.reader.ConsoleReader;

public class Launcher {

	public static void main(String[] args) {

		Kickstarter application = new Kickstarter(new ConsoleReader(), new ConsolePrinter());

		application.run();
	}
}
