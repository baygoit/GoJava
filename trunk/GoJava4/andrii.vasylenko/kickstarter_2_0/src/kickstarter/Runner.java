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
import kickstarter.model.dao.PaymentsDAO;
import kickstarter.model.dao.PaymentsDAOImpl;
import kickstarter.model.dao.ProjectsDAO;
import kickstarter.model.dao.ProjectsDAOImpl;
import kickstarter.model.dao.QuestionsDAO;
import kickstarter.model.dao.QuestionsDAOImpl;
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
	private static final String SQL_URL = "jdbc:postgresql://localhost:5433/kickstarter";
	private static final String SQL_USER = "postgres";
	private static final String SQL_PASSWORD = "111";

	public static void main(String... args) {
		Runner runner = new Runner();
		runner.run();
	}

	public void run() {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			AbstractModelFactory models = initModelFactory(connection);
			AbstractViewFactory views = initConsoleViewFactory();

			Control control = initKickstarter(models, views);
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
		QuotesDAO quotes = new QuotesDAOImpl(connection);
		CategoriesDAO categories = new CategoriesDAOImpl(connection);
		ProjectsDAO projects = new ProjectsDAOImpl(connection);
		QuestionsDAO questions = new QuestionsDAOImpl(connection);
		PaymentsDAO payments = new PaymentsDAOImpl(connection);

		initDAO(quotes, categories, projects, questions, payments);

		return new ModelFactory(quotes, categories, projects, questions, payments);
	}

	public void initDAO(QuotesDAO quotes, CategoriesDAO categories, ProjectsDAO projects, QuestionsDAO questions,
			PaymentsDAO payments) {
		try {
			quotes.createTableQuotes();
			categories.createTableCategories();
			projects.createTableProjects();
			questions.createTableQuestions();
			payments.createTablePayments();

			setDefaultsData(quotes, categories, projects, questions, payments);
		} catch (CannotCreateTableException | CannotAddDataException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void setDefaultsData(QuotesDAO quotes, CategoriesDAO categories, ProjectsDAO projects,
			QuestionsDAO questions, PaymentsDAO payments) throws CannotAddDataException {
		quotes.addQuote("Don't cry because it's over, smile because it happened");
		quotes.addQuote("Be yourself; everyone else is already taken.");
		quotes.addQuote("A room without books is like a body without a soul.");

		categories.addCategory("Sport");
		categories.addCategory("Business");

		projects.addProject(1, "velo parking", "velo parking in Kiev", 10000, 100, "History1", "www.project1.com");
		projects.addProject(1, "velo track", "velo track in Kiev", 100000, 200, "History2", "www.project2.com");
		projects.addProject(2, "IT-school", "IT - future of Ukraine", 1000000, 1000, "History3", "www.project3.com");

		payments.donate(1, 500);
		payments.donate(2, 5000);
		payments.donate(3, 50000);

		payments.addPaymentVariant(1, 10, "minimum");
		payments.addPaymentVariant(1, 100, "medium");
		payments.addPaymentVariant(1, 500, "high");
		payments.addPaymentVariant(2, 10000, "standart");
		payments.addPaymentVariant(3, 50000, "standart");

		questions.addQuestion(1, "WTF ¹1?");
		questions.addQuestion(2, "WTF ¹2?");
		questions.addQuestion(3, "WTF ¹3?");
	}
}
