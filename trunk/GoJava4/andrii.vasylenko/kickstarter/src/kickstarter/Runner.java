package kickstarter;

import interfaces.ConsolePrinter;
import interfaces.Printer;
import storages.CategoriesStorage;
import storages.ProjectsStorage;
import storages.QuotesStorage;
import data_types.Category;
import data_types.Project;
import data_types.Quote;

public class Runner {

	public static void main(String[] args) {
		Printer printer = new ConsolePrinter();
		
		QuotesStorage quotesStorage = new QuotesStorage();
		quotesStorage.add(new Quote("Don't cry because it's over, smile because it happened"));
		quotesStorage.add(new Quote("Be yourself; everyone else is already taken."));
		quotesStorage.add(new Quote("A room without books is like a body without a soul."));
		
		Category sport = new Category("Sport");
		Category business = new Category("Business");
		CategoriesStorage categoriesStorage = new CategoriesStorage();
		categoriesStorage.add(sport);
		categoriesStorage.add(business);
		
		Project project1 = new Project("velo parking", "velo parking in Kiev", 10000, 7000, 100, sport);
		project1.setHistory("History1");
		project1.setLink("www.project1.com");
		project1.setQuestionsAndAnswers("why1");
		Project project2 = new Project("velo track", "velo track in Kiev", 100000, 50000, 200, sport);
		project2.setHistory("History2");
		project2.setLink("www.project2.com");
		project2.setQuestionsAndAnswers("why2");
		Project project3 = new Project("IT-school", "IT - future of Ukraine", 1000000, 700000, 1000, business);
		project3.setHistory("History3");
		project3.setLink("www.project3.com");
		project3.setQuestionsAndAnswers("why3");
		ProjectsStorage projectsStorage = new ProjectsStorage();
		projectsStorage.add(project1);
		projectsStorage.add(project2);
		projectsStorage.add(project3);
		
		Kickstarter kickstarter = new Kickstarter(printer, quotesStorage, categoriesStorage, projectsStorage);
		kickstarter.run();
	}

}
