package kickstarter;

import kickstarter.control.Control;
import kickstarter.control.Kickstarter;
import kickstarter.model.engine.Category;
import kickstarter.model.engine.Project;
import kickstarter.model.engine.Quote;
import kickstarter.model.factory.AbstractModelFactory;
import kickstarter.model.factory.ModelFactory;
import kickstarter.model.storage.CollectionsStorage;
import kickstarter.model.storage.Storage;
import kickstarter.view.factory.AbstractViewFactory;
import kickstarter.view.factory.ViewFactory;
import kickstarter.view.printer.ConsolePrinter;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.ConsoleReader;
import kickstarter.view.reader.Reader;

public class ConsoleRunner {

	public static void main(String[] args) {
		new ConsoleRunner().start();
	}

	private void start() {
		Control control = initKickstarter();
		control.exequte();
	}

	public Control initKickstarter() {
		Storage storage = initCollectionsStorage();
		AbstractModelFactory models = initModelFactory(storage);
		AbstractViewFactory views = initConsoleViewFactory();
		Control kickstarter = new Kickstarter(models, views);
		return kickstarter;
	}

	public AbstractViewFactory initConsoleViewFactory() {
		Printer printer = new ConsolePrinter();
		Reader reader = new ConsoleReader();
		AbstractViewFactory views = new ViewFactory(printer, reader);
		return views;
	}

	public AbstractModelFactory initModelFactory(Storage storage) {
		return new ModelFactory(storage);
	}

	public Storage initCollectionsStorage() {
		Storage storage = new CollectionsStorage();

		storage.addQuote(new Quote("Don't cry because it's over, smile because it happened"));
		storage.addQuote(new Quote("Be yourself; everyone else is already taken."));
		storage.addQuote(new Quote("A room without books is like a body without a soul."));

		Category sport = new Category("Sport");
		Category business = new Category("Business");
		storage.addCategory(sport);
		storage.addCategory(business);

		Project project1 = new Project("velo parking", "velo parking in Kiev", 10000, 100, "History1",
				"www.project1.com", "why1");
		Project project2 = new Project("velo track", "velo track in Kiev", 100000, 200, "History2", "www.project2.com",
				"why2");
		Project project3 = new Project("IT-school", "IT - future of Ukraine", 1000000, 1000, "History3",
				"www.project3.com", "why3");

		project1.donate(7000);
		project2.donate(50000);
		project3.donate(700000);

		storage.addProject(project1, sport);
		storage.addProject(project2, sport);
		storage.addProject(project3, business);

		return storage;
	}
}
