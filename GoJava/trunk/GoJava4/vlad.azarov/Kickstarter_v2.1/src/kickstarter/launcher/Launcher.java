package kickstarter.launcher;

import java.io.IOException;

import kickstarter.control.Kickstarter;
import kickstarter.page.PageDispatcher;
import kickstarter.printer.ConsolePrinter;
import kickstarter.reader.ConsoleReader;

public class Launcher {

	public static void main(String[] args) throws IOException {

		Kickstarter application = new Kickstarter(new ConsoleReader(), new ConsolePrinter());
		PageDispatcher application2 = new PageDispatcher(new ConsolePrinter(), new ConsoleReader());
		// application.run();
		application2.run();
	}
}
