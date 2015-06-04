package kickstarter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import kickstarter.control.Control;
import kickstarter.control.Kickstarter;
import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotCreateTableException;
import kickstarter.exception.IncorrectLogicException;
import kickstarter.model.dao.CategoriesDAO;
import kickstarter.model.dao.CategoriesDAOImpl;
import kickstarter.model.dao.ProjectsDAO;
import kickstarter.model.dao.ProjectsDAOImpl;
import kickstarter.model.dao.QuotesDAO;
import kickstarter.model.dao.QuotesDAOImpl;
import kickstarter.model.factory.AbstractModelFactory;
import kickstarter.model.factory.ModelFactory;
import kickstarter.view.factory.AbstractViewFactory;
import kickstarter.view.factory.ViewFactory;
import kickstarter.view.printer.ConsolePrinter;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.ConsoleReader;
import kickstarter.view.reader.Reader;

public class Runner {
	public static final String SQL_URL = "jdbc:postgresql://localhost:5433/kickstarter";
	public static final String SQL_USER = "postgres";
	public static final String SQL_PASSWORD = "111";

	public static void main(String... args) {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			Runner runner = new Runner();

			AbstractModelFactory models = runner.initModelFactory(connection);
			AbstractViewFactory views = runner.initConsoleViewFactory();

			Control control = runner.initKickstarter(models, views);
			control.exequte();

		} catch (IncorrectLogicException | SQLException e) {
			e.printStackTrace();
		}
	}

	public Control initKickstarter(AbstractModelFactory models, AbstractViewFactory views)
			throws IncorrectLogicException {
		Control kickstarter = new Kickstarter(models, views);
		return kickstarter;
	}

	public AbstractViewFactory initConsoleViewFactory() {
		Printer printer = new ConsolePrinter();
		Reader reader = new ConsoleReader();
		AbstractViewFactory views = new ViewFactory(printer, reader);
		return views;
	}

	public AbstractModelFactory initModelFactory(Connection connection) {
		QuotesDAO quotesDAO = new QuotesDAOImpl(connection);
		CategoriesDAO categoriesDAO = new CategoriesDAOImpl(connection);
		ProjectsDAO projectsDAO = new ProjectsDAOImpl(connection);

		initDAO(quotesDAO, categoriesDAO, projectsDAO);

		return new ModelFactory(quotesDAO, categoriesDAO, projectsDAO);
	}

	public void initDAO(QuotesDAO quotesDAO, CategoriesDAO categoriesDAO, ProjectsDAO projectsDAO) {
		try {
			quotesDAO.createTableQuotes();
			categoriesDAO.createTableCategories();
			projectsDAO.createTableProjects();

			addDataInStorage(quotesDAO, categoriesDAO, projectsDAO);
		} catch (CannotCreateTableException | CannotAddDataException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void addDataInStorage(QuotesDAO quotesDAO, CategoriesDAO categoriesDAO, ProjectsDAO projectsDAO)
			throws CannotAddDataException {
		quotesDAO.addQuote("Don't cry because it's over, smile because it happened");
		quotesDAO.addQuote("Be yourself; everyone else is already taken.");
		quotesDAO.addQuote("A room without books is like a body without a soul.");

		categoriesDAO.addCategory("Sport");
		categoriesDAO.addCategory("Business");

		projectsDAO.addProject(1, "velo parking", "velo parking in Kiev", 10000, 100, "History1", "www.project1.com");
		projectsDAO.addProject(1, "velo track", "velo track in Kiev", 100000, 200, "History2", "www.project2.com");
		projectsDAO.addProject(2, "IT-school", "IT - future of Ukraine", 1000000, 1000, "History3", "www.project3.com");
	}
}
