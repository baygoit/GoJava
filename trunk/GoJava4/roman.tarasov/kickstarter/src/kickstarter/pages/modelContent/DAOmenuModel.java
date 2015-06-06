package kickstarter.pages.modelContent;

import java.sql.SQLException;

import kickstarter.dao.databaseServices.DatabaseSettings;
import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.interfaces.iController;

public class DAOmenuModel extends PageModel {
	private iController icontroller;

	public DAOmenuModel(iController icontroller) {
		this.icontroller = icontroller;
	}

	private void verifyDatabaseConnection() throws SQLException, NullPointerException{
		
		if (icontroller.getDatabaseService().getConnection()==null||icontroller.getDatabaseService().getConnection().isClosed()) {
			icontroller.getDatabaseService().createConnection(
					new DatabaseSettings(
							"jdbc:postgresql://localhost:5432/kickstarter",
							"postgres", "root"));
		}
	}

	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("p")) {
			imodel.next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		if (message.equals("c")) {
			try {
				verifyDatabaseConnection();
				icontroller.getDatabaseService().createDefaultDatabase(icontroller.getDefaultDao(), icontroller.getDatabaseDao());
				imodel.next(IndexOfPage.CATEGORIES.ordinal());

			} catch (SQLException e) {
				imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
						IndexOfPage.DAO_MENU_PAGE.ordinal());
			}
			return;
		}
		if (message.equals("d")) {

			try {
				verifyDatabaseConnection();
				icontroller.setDatabaseDAO();
				imodel.next(IndexOfPage.CATEGORIES.ordinal());
			} catch (SQLException e) {
				imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
						IndexOfPage.DAO_MENU_PAGE.ordinal());
			}
			return;

		}
		if (message.equals("m")) {
			icontroller.setDefaultDAO();
			imodel.next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		if (message.equals("e")) {
			imodel.next(IndexOfPage.END_PAGE.ordinal());
			return;
		}

		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.DAO_MENU_PAGE.ordinal());
	}
}