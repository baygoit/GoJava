package vadya_zakusylo.kickstarter;

import java.sql.Connection;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.controller.ControllerImpl;
import vadya_zakusylo.kickstarter.controller.KickStarter;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.model.ModelImpl;
import vadya_zakusylo.kickstarter.model.dao.CategoriesDao;
import vadya_zakusylo.kickstarter.model.dao.Dao;
import vadya_zakusylo.kickstarter.model.dao.ProjectsDao;
import vadya_zakusylo.kickstarter.model.dao.QuotesDao;
import vadya_zakusylo.kickstarter.my_sql.CategoriesDaoImpl;
import vadya_zakusylo.kickstarter.my_sql.ConnectionPoolSingltone;
import vadya_zakusylo.kickstarter.my_sql.DaoImpl;
import vadya_zakusylo.kickstarter.my_sql.ProjectsDaoImpl;
import vadya_zakusylo.kickstarter.my_sql.QuotesDaoImpl;
import vadya_zakusylo.kickstarter.my_sql.exception.NotAvailableConnectionException;
import vadya_zakusylo.kickstarter.view.factory.ViewFactory;
import vadya_zakusylo.kickstarter.view.factory.ViewFactoryImpl;
import vadya_zakusylo.kickstarter.view.input.ConsoleInput;
import vadya_zakusylo.kickstarter.view.input.Input;
import vadya_zakusylo.kickstarter.view.output.ConsoleOutput;
import vadya_zakusylo.kickstarter.view.output.Output;

public class Runner {
	private ConnectionPoolSingltone connectionPool;
	private Connection connection;

	private QuotesDao quotesDao;
	private CategoriesDao categoriesDao;
	private ProjectsDao projectsDao;
	private Dao dao;

	private Model model;
	private Controller controller;
	private ViewFactory viewFactory;

	private Input input = new ConsoleInput();
	private Output output = new ConsoleOutput();

	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.init();
		runner.go();
	}

	private void init() {
		try {
			connectionPool = ConnectionPoolSingltone.getConnectionPool();
			connection = connectionPool.getConnection();

			quotesDao = new QuotesDaoImpl(connection);
			categoriesDao = new CategoriesDaoImpl(connection);
			projectsDao = new ProjectsDaoImpl(connection);
			dao = new DaoImpl(quotesDao, categoriesDao, projectsDao);

			model = new ModelImpl(connection, dao); // to delete
			// model = new ModelImpl(dao);
			controller = new ControllerImpl(model);
			viewFactory = new ViewFactoryImpl(model, controller, input, output);
		} catch (NotAvailableConnectionException e) {
			System.out.println("All connections are not available!");
		} finally {
			connectionPool.closeConnection(connection);
		}
	}

	private void go() {
		KickStarter kickStarter = new KickStarter(controller, viewFactory);
		kickStarter.go();
	}
}