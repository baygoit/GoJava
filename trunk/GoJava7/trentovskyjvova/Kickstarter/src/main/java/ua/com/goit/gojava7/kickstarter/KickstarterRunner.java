package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSourceTypes;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;

public class KickstarterRunner {
	
	public static void main(String[] args) {
		
		DataSourceTypes daoType = DataSourceTypes.MEMORY;
		if (args.length != 0) {
			if(args[0].equals("file")){
				daoType = DataSourceTypes.FILE;
			} else if (args[0].equals("mysql")) {
				daoType = DataSourceTypes.MYSQL;
			} else if (args[0].equals("postgres")) {
				daoType = DataSourceTypes.POSTGRES;
			}
		}

		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleScanner consoleReader = new ConsoleScanner();
		
		DaoProvider daoProvider = new DaoProvider(daoType);
		
		Kickstarter kickstarter = new Kickstarter(consolePrinter,
				consoleReader, daoProvider);
		kickstarter.runKickstarter();
		kickstarter.shutdown();
		
	}

	
}
