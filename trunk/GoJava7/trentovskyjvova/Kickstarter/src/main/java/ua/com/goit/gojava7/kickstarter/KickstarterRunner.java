package ua.com.goit.gojava7.kickstarter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		
		//ApplicationContext context = 
	    //		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	 
		//DaoProvider daoProvider = (DaoProvider) context.getBean("daoProvider");
		//DaoProvider daoProvider = new DaoProvider(daoType);
		//daoProvider.open();
		
		Kickstarter kickstarter = new Kickstarter(consolePrinter,
				consoleReader);
		kickstarter.runKickstarter();
		kickstarter.shutdown();
		
		//daoProvider.close();
	}

	
}
