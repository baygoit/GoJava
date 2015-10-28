package kickstarter;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.engine.Quote;
import kickstarter.interfaces.Preparer;
import kickstarter.interfaces.display.CategoriesDisplay;
import kickstarter.interfaces.display.ProjectDisplay;
import kickstarter.interfaces.display.ProjectsDisplay;
import kickstarter.interfaces.display.QuotesDisplay;
import kickstarter.interfaces.printers.ConsolePrinter;
import kickstarter.interfaces.readers.ConsoleReader;
import kickstarter.storages.CategoriesStorage;
import kickstarter.storages.ProjectsStorage;
import kickstarter.storages.QuotesStorage;
import kickstarter.storages.relations.ProjectsInCategory;

public class Runner {

	public static void main(String[] args) {
		new Runner().run();
	}

	public void run() {
		Kickstarter kickstarter = new Kickstarter(initModel(), initView(), initPreparer());
		kickstarter.run();
	}

	public View initView() {
		return new View(new ConsolePrinter(), new ConsoleReader());
	}

	public Preparer initPreparer() {
		return new Preparer(new QuotesDisplay(), new CategoriesDisplay(), new ProjectsDisplay(), new ProjectDisplay());
	}

	public Model initModel() {
		Model model = new Model(new QuotesStorage(), new CategoriesStorage(), new ProjectsStorage(),
				new ProjectsInCategory());

		model.addQuote(new Quote("Don't cry because it's over, smile because it happened"));
		model.addQuote(new Quote("Be yourself; everyone else is already taken."));
		model.addQuote(new Quote("A room without books is like a body without a soul."));

		Category sport = new Category("Sport");
		Category business = new Category("Business");
		model.addCategory(sport);
		model.addCategory(business);

		Project project1 = new Project("velo parking", "velo parking in Kiev", 10000, 100);
		project1.donate(7000);
		project1.setHistory("History1");
		project1.setLink("www.project1.com");
		project1.setQuestionsAndAnswers("why1");

		Project project2 = new Project("velo track", "velo track in Kiev", 100000, 200);
		project2.donate(50000);
		project2.setHistory("History2");
		project2.setLink("www.project2.com");
		project2.setQuestionsAndAnswers("why2");

		Project project3 = new Project("IT-school", "IT - future of Ukraine", 1000000, 1000);
		project3.donate(700000);
		project3.setHistory("History3");
		project3.setLink("www.project3.com");
		project3.setQuestionsAndAnswers("why3");

		model.addProject(project1, sport);
		model.addProject(project2, sport);
		model.addProject(project3, business);

		return model;
	}
}
