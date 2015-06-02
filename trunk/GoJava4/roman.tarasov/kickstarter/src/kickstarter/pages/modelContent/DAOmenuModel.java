package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.interfaces.iController;

public class DAOmenuModel extends PageModel {
	private iController icontroller;

	public DAOmenuModel(iController icontroller) {
		this.icontroller = icontroller;
	}

	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("p")) {
			imodel.next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		if (message.equals("d")) {
			icontroller.setDatabaseDAO();
			imodel.next(IndexOfPage.CATEGORIES.ordinal());
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

		if (message.equals("i")) {
			imodel.next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.DAO_MENU_PAGE.ordinal());
	}
}