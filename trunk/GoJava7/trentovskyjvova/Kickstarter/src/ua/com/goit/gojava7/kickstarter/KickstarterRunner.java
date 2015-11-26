package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;

public class KickstarterRunner {
	
	public static void main(String[] args) {
		DataSource daoType = DataSource.MEMORY;
		if (args.length != 0) {
			if(args[0].equals("file")){
				daoType = DataSource.FILE;
			} else if (args[0].equals("mysql")) {
				daoType = DataSource.MYSQL;
			}
		}

		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleScanner consoleReader = new ConsoleScanner();
		
		DaoProvider initializer = new DaoProvider(daoType);
		initializer.open();
		
		Kickstarter kickstarter = new Kickstarter(consolePrinter,
				consoleReader, initializer);
		kickstarter.runKickstarter();
		kickstarter.shutdown();
		
		initializer.close();
	}

	
}
