package kickstarter;

import kickstarter.control.Control;
import kickstarter.control.Kickstarter;
import kickstarter.model.engine.Category;
import kickstarter.model.engine.Project;
import kickstarter.model.engine.Quote;
import kickstarter.model.factory.AbstractModelFactory;
import kickstarter.model.factory.ModelFactory;
import kickstarter.model.storage.CollectionsStorage;
import kickstarter.model.storage.CsvFileStorage;
import kickstarter.model.storage.Storage;
import kickstarter.view.factory.AbstractViewFactory;
import kickstarter.view.factory.ViewFactory;
import kickstarter.view.printer.ConsolePrinter;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.ConsoleReader;
import kickstarter.view.reader.Reader;

public class Runner {
	public Control initKickstarter(AbstractModelFactory models, AbstractViewFactory views) {
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
		addDataInStorage(storage);
		return storage;
	}

	public Storage initCsvFileStorage() {
		Storage storage = new CsvFileStorage();
		return storage;
	}

	public void addDataInStorage(Storage storage) {
		storage.addQuote(new Quote(0, "Don't cry because it's over, smile because it happened"));
		storage.addQuote(new Quote(1, "Be yourself; everyone else is already taken."));
		storage.addQuote(new Quote(2, "A room without books is like a body without a soul."));

		Category sport = new Category(0, "Sport");
		Category business = new Category(1, "Business");
		storage.addCategory(sport);
		storage.addCategory(business);

		Project project1 = new Project(0, "velo parking", "velo parking in Kiev", 10000, 100, "History1",
				"www.project1.com", "why1", 7000);
		Project project2 = new Project(1, "velo track", "velo track in Kiev", 100000, 200, "History2",
				"www.project2.com", "why2", 50000);
		Project project3 = new Project(2, "IT-school", "IT - future of Ukraine", 1000000, 1000, "History3",
				"www.project3.com", "why3", 700000);

		storage.addProject(project1, sport);
		storage.addProject(project2, sport);
		storage.addProject(project3, business);
	}
}
