package kickstarter.dao.databaseServices;

import kickstarter.dao.interfaces.iDAO;

public interface iDatabaseService {
	
	void createDefaultDatabase(DatabaseSettings databaseSettings,
			iDAO interfaceDAO);

}
