package kickstarter;

import kickstarter.control.Control;
import kickstarter.control.Kickstarter;
import kickstarter.model.dao.ConnectionPool;
import kickstarter.model.dao.ConnectionPoolImpl;
import kickstarter.model.dao.DAO;
import kickstarter.model.dao.DAOImpl;
import kickstarter.model.factory.AbstractModelFactory;
import kickstarter.model.factory.ModelFactory;
import kickstarter.view.factory.AbstractViewFactory;
import kickstarter.view.factory.ViewFactory;
import kickstarter.view.printer.ConsolePrinter;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.ConsoleReader;
import kickstarter.view.reader.Reader;

public class Runner {
	public static void main(String... args) {
		Runner runner = new Runner();
		runner.run();
	}

	public void run() {
		try (ConnectionPool connectionPool = new ConnectionPoolImpl()) {
			DAO dao = initDAO(connectionPool);
			dao.initData();

			AbstractModelFactory models = initModelFactory(dao);
			AbstractViewFactory views = initConsoleViewFactory();

			Control control = initKickstarter(models, views);
			control.exequte();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DAO initDAO(ConnectionPool connectionPool) {
		return new DAOImpl(connectionPool);
	}

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

	public AbstractModelFactory initModelFactory(DAO dao) {
		return new ModelFactory(dao);
	}
}
