package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.interfaces.iController;

public class RepositoryMenuModel extends PageModel {

	private iController icontroller;

	public RepositoryMenuModel(iController icontroller) {

		this.icontroller = icontroller;
	}

	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("p")) {
			imodel.next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		if (message.equals("d")) {
			imodel.next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		if (message.equals("e")) {
			imodel.next(IndexOfPage.END_PAGE.ordinal());
			return;
		}
		if (message.equals("c")) {
			imodel.next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		if (message.equals("i")) {

			imodel.next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.REPOSITORY_MENU_PAGE.ordinal());
	}
}