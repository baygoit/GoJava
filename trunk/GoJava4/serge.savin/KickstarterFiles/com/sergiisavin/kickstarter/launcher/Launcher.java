package com.sergiisavin.kickstarter.launcher;

import java.util.logging.ConsoleHandler;

import javax.naming.OperationNotSupportedException;

import com.sergiisavin.kickstarter.Kickstarter;
import com.sergiisavin.kickstarter.category.container.Categories;
import com.sergiisavin.kickstarter.category.container.file.CategoriesContainerFile;
import com.sergiisavin.kickstarter.category.container.memory.CategoriesContainer;
import com.sergiisavin.kickstarter.project.Project;
import com.sergiisavin.kickstarter.project.container.Projects;
import com.sergiisavin.kickstarter.project.container.memory.ProjectsContainer;
import com.sergiisavin.kickstarter.quote.container.Quotes;
import com.sergiisavin.kickstarter.quote.container.file.QuotesContainerFile;
import com.sergiisavin.kickstarter.quote.container.memory.QuotesContainer;
import com.sergiisavin.kickstarter.userinterface.dispatcher.PageDispatcher;
import com.sergiisavin.kickstarter.userinterface.pagefactory.PageFactory;
import com.sergiisavin.kickstarter.userinterface.pages.PageType;
import com.sergiisavin.kickstarter.userinterface.printer.ConsolePrinter;
import com.sergiisavin.kickstarter.userinterface.printer.Printer;
import com.sergiisavin.kickstarter.userinterface.printer.UpperCaseConsolePrinter;

public class Launcher {
    
	static PageDispatcher pageDispatcher;
    static Kickstarter kickstarter;
    static Quotes quotes;
    static Categories categories;
    static Projects projects;
    static Printer printer;
    static PageFactory pageFactory;
    
	public static void main(String[] args) {
		
		CreateAndInitializeClasses();
		
		injectDependencies();

		launch();

	}


	private static void CreateAndInitializeClasses() {
		pageDispatcher = new PageDispatcher();
		pageFactory = new PageFactory();
		kickstarter = new Kickstarter();
		quotes = new QuotesContainerFile("Easy come - easy go", "An apple a day keeps doctors away", "A good speach"
				+ " must be as girls skirt: short enaugh to be interesting and long enaugh to cover the subject");
		categories = new CategoriesContainerFile("Toys", "Software", "Gadgets");
		projects = new ProjectsContainer();
		Project project = new Project("Jumping Frog Toy", "01.05.2015", "01.11.2015", 20000.0, 0.0, "Toys",
				"DESCRIPTION", "PROJECT HISTORY", "VIDEO URL", "QUESTIONS AND ANSWERS");
		try {
			projects.add(project);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project = new Project("Boomba toy", "01.05.2015", "01.11.2015", 20000.0, 0.0, "Toys",
				"DESCRIPTION", "PROJECT HISTORY", "VIDEO URL", "QUESTIONS AND ANSWERS");
		try {
			projects.add(project);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project = new Project("ROBO GADGET", "01.05.2015", "01.11.2015", 20000.0, 0.0, "Gadgets",
				"DESCRIPTION", "PROJECT HISTORY", "VIDEO URL", "QUESTIONS AND ANSWERS");
		try {
			projects.add(project);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project = new Project("KICKSTARTER", "01.05.2015", "01.11.2015", 20000.0, 0.0, "Software",
				"DESCRIPTION", "PROJECT HISTORY", "VIDEO URL", "QUESTIONS AND ANSWERS");
		try {
			projects.add(project);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//printer = new ConsolePrinter();
		printer = new UpperCaseConsolePrinter();
	}

	private static void injectDependencies() {
		kickstarter.setQuotes(quotes);
		kickstarter.setCategories(categories);
		pageDispatcher.setKickstarter(kickstarter);
		kickstarter.injectProjects(projects);
		pageFactory.setPrinter(printer);
		pageDispatcher.injectPrinter(printer);
		pageDispatcher.setPageFactory(pageFactory);
	}
	
	private static void launch() {
		pageDispatcher.requestPage(PageType.MAIN_MENU_PAGE, null);
	}

}
