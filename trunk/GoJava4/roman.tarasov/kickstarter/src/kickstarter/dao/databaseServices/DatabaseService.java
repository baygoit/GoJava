package kickstarter.dao.databaseServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import kickstarter.dao.interfaces.iDAO;

public class DatabaseService implements iDatabaseService {
	Connection connection;

	@Override
	public void createDefaultDatabase(iDAO sourceDAO, iDAO destinationDAO)
			throws SQLException {
		destinationDAO.getProjectService().createProjects(sourceDAO);
		destinationDAO.getQuoteService().createQuotes(sourceDAO);
		destinationDAO.getCategoryService().createCategories(sourceDAO);
		destinationDAO.getCommentService().createComments(sourceDAO);
		destinationDAO.getUserService().createAccounts(sourceDAO);
	}

	@Override
	public void createConnection(DatabaseSettings settings) throws SQLException {
		connection = DriverManager.getConnection(settings.getUrl(),
				settings.getUser(), settings.getPassword());
	}

	@Override
	public Connection getConnection() {
		return connection;
	}
}
