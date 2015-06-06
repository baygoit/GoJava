package kickstarter.mvc.interfaces;

import kickstarter.dao.databaseServices.iDatabaseService;
import kickstarter.dao.interfaces.iDAO;

public interface iController {

	void setInterfaces(iView iview, iModel imodel);

	iDAO getDao();

	void setDaoInterfaces(iDAO defaultDAO,iDAO databaseDAO);

	void setDefaultDAO();

	void setDatabaseDAO();

	iDatabaseService getDatabaseService();

	iDAO getDefaultDao();

	iDAO getDatabaseDao();
}
