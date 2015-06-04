package kickstarter.dao.databaseServices;

import java.sql.Connection;
import java.sql.SQLException;

import kickstarter.dao.interfaces.iDAO;

public interface iDatabaseService {

	void createDefaultDatabase(DatabaseSettings settings, iDAO sourceDAO,
			iDAO destinationDAO) throws SQLException;

	Connection getConnection();
}
