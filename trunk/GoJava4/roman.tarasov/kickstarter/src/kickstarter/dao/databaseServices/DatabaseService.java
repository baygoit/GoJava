package kickstarter.dao.databaseServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kickstarter.dao.interfaces.iDAO;
import kickstarter.entity.Category;
import kickstarter.entity.Project;
import kickstarter.entity.ProjectComment;
import kickstarter.entity.Quote;

public class DatabaseService implements iDatabaseService {

	@Override
	public void createDefaultDatabase(DatabaseSettings settings,
			iDAO interfaceDAO) {
		List<Quote> quotes = interfaceDAO.getQuoteService().getAll();
		List<Category> categories = interfaceDAO.getCategoryService().getAll();
		List<Project> projects = interfaceDAO.getProjectService().getAll();
		Map<Integer, ArrayList<ProjectComment>> comments = interfaceDAO
				.getCommentService().getAll();

		try (Connection connection = DriverManager.getConnection(
				settings.getUrl(), settings.getUser(), settings.getPassword())) {
			Statement statement = connection.createStatement();

			createQuotes(statement, quotes);
			createCategories(statement, categories);
			createProjects(statement, projects);
			createComments(statement, comments);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	private void createCategories(Statement statement, List<Category> categories) throws SQLException {
		statement.executeUpdate("DROP TABLE IF EXISTS  categories ");
		statement
		.executeUpdate("CREATE TABLE categories (id SERIAL not null PRIMARY KEY, category varchar(255))");
		for (Category category : categories) {
			statement.executeUpdate("INSERT INTO categories VALUES ("+category.getID()+","+"'"+category.getName()+"')");
		}
	}
	private void createQuotes(Statement statement, List<Quote> quotes)
			throws SQLException {
			statement.executeUpdate("DROP TABLE IF EXISTS  quotes ");
			statement
					.executeUpdate("CREATE TABLE quotes (id SERIAL not null PRIMARY KEY, quote varchar(255))");
			for (Quote quote : quotes) {
				statement.executeUpdate("INSERT INTO quotes VALUES ("+quote.getID()+","+"'"+quote.getQuote()+"')");
			}
	}

	private void createComments(Statement statement,
			Map<Integer, ArrayList<ProjectComment>> comments) {
		// TODO Auto-generated method stub

	}

	private void createProjects(Statement statement, List<Project> projects) {
		// TODO Auto-generated method stub

	}



}
