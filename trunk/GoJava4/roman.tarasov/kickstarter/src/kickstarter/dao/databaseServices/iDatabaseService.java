package kickstarter.dao.databaseServices;

import kickstarter.dao.interfaces.iDAO;

public interface iDatabaseService {

	void createDefaultDatabase(DatabaseSettings settings, iDAO sourceDAO,
			iDAO destinationDAO);
	boolean getDatabaseStatus();
}
