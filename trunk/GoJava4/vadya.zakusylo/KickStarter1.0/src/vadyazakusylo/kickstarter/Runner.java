package vadyazakusylo.kickstarter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import vadyazakusylo.kickstarter.controller.Controller;
import vadyazakusylo.kickstarter.controller.KickStarter;
import vadyazakusylo.kickstarter.model.Model;
import vadyazakusylo.kickstarter.model.dao.CategoriesDao;
import vadyazakusylo.kickstarter.model.dao.ProjectDao;
import vadyazakusylo.kickstarter.model.dao.ProjectsDao;
import vadyazakusylo.kickstarter.model.dao.QuotesDao;
import vadyazakusylo.kickstarter.mysql.CategoriesDaoMySql;
import vadyazakusylo.kickstarter.mysql.ProjectDaoMySql;
import vadyazakusylo.kickstarter.mysql.ProjectsDaoMySql;
import vadyazakusylo.kickstarter.mysql.QuotesDaoMySql;
import vadyazakusylo.kickstarter.view.factory.ViewFactory;
import vadyazakusylo.kickstarter.view.input.ConsoleInput;
import vadyazakusylo.kickstarter.view.input.Input;
import vadyazakusylo.kickstarter.view.output.ConsoleOutput;
import vadyazakusylo.kickstarter.view.output.Output;

public class Runner {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/kickstarter";
	private String user = "root";
	private String password = "root";

	private QuotesDao quotesDao;
	private CategoriesDao categoriesDao;
	private ProjectsDao projectsDao;
	private ProjectDao projectDao;

	private Model model;
	private Controller controller;
	private ViewFactory viewFactory;

	private Input input = new ConsoleInput();
	private Output output = new ConsoleOutput();

	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.go();
	}

	private void go() {
		try {
			Class.forName(driver);
			try (Connection connection = DriverManager.getConnection(url, user, password)) {
				quotesDao = new QuotesDaoMySql(connection);
				categoriesDao = new CategoriesDaoMySql(connection);
				projectsDao = new ProjectsDaoMySql(connection);
				projectDao = new ProjectDaoMySql(connection);
				model = new Model(quotesDao, categoriesDao, projectsDao, projectDao);
				controller = new Controller(model);
				viewFactory = new ViewFactory(model, controller, input, output);
				KickStarter kickStarter = new KickStarter(controller, viewFactory);
				kickStarter.go();
			} catch (SQLException e) {
				output.write("Can't create a connection.");
			}
		} catch (ClassNotFoundException e) {
			output.write("Can't download a driver.");
		}
	}
}