package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;

public class KickstarterRun {
	public static void main(String[] args) {
		ConsoleScanner consoleScanner = new ConsoleScanner();

		Kickstarter kickstarter = new Kickstarter(consoleScanner);
		kickstarter.run();
		kickstarter.shutdown();
	}
}
