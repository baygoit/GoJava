package kickstarter.dao.databaseServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import kickstarter.dao.interfaces.iDAO;

public class DatabaseService implements iDatabaseService {

	@Override
	public void createDefaultDatabase(DatabaseSettings settings,
			iDAO sourceDAO, iDAO destinationDAO) {

		try (Connection connection = DriverManager.getConnection(
				settings.getUrl(), settings.getUser(), settings.getPassword())) {

			destinationDAO.getProjectService().createProjects(sourceDAO,
					connection);
			destinationDAO.getQuoteService()
					.createQuotes(sourceDAO, connection);
			destinationDAO.getCategoryService().createCategories(sourceDAO,
					connection);
			destinationDAO.getCommentService().createComments(sourceDAO, connection);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
