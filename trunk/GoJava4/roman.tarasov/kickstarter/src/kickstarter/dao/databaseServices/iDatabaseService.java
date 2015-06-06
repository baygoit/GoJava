package kickstarter.dao.databaseServices;

import java.sql.Connection;
import java.sql.SQLException;

import kickstarter.dao.interfaces.iDAO;

public interface iDatabaseService {

	void createDefaultDatabase( iDAO sourceDAO,
			iDAO destinationDAO) throws SQLException;

	void createConnection(DatabaseSettings settings) throws SQLException;

	Connection getConnection();
}
