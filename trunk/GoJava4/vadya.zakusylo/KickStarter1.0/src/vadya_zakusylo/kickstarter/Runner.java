package vadya_zakusylo.kickstarter;

import java.sql.DriverManager;
import java.sql.SQLException;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.controller.KickStarter;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.model.dao.CategoriesDao;
import vadya_zakusylo.kickstarter.model.dao.ProjectDao;
import vadya_zakusylo.kickstarter.model.dao.ProjectsDao;
import vadya_zakusylo.kickstarter.model.dao.QuotesDao;
import vadya_zakusylo.kickstarter.my_sql.CategoriesDaoMySql;
import vadya_zakusylo.kickstarter.my_sql.ProjectDaoMySql;
import vadya_zakusylo.kickstarter.my_sql.ProjectsDaoMySql;
import vadya_zakusylo.kickstarter.my_sql.QuotesDaoMySql;
import vadya_zakusylo.kickstarter.view.factory.ViewFactory;
import vadya_zakusylo.kickstarter.view.input.ConsoleInput;
import vadya_zakusylo.kickstarter.view.input.Input;
import vadya_zakusylo.kickstarter.view.output.ConsoleOutput;
import vadya_zakusylo.kickstarter.view.output.Output;

import com.mysql.jdbc.Connection;

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
			try (Connection connection = (Connection) DriverManager.getConnection(url, user,
					password)) {
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