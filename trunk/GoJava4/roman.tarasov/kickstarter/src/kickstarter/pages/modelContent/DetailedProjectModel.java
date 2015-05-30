package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;

public class DetailedProjectModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			imodel.next(IndexOfPage.PROJECTS.ordinal());
			return;
		}
		if (message.equals("c")) {
			imodel.next(IndexOfPage.COMMENT_PAGE.ordinal());
			return;
		}
		if (message.equals("i")) {
			imodel.next(IndexOfPage.INVEST_PAGE.ordinal());
			return;
		}
		if (message.equals("d")) {
			modelValues = imodel.getModelValues();
			imodel.next(IndexOfPage.DONATE_PAGE.ordinal());
			return;
		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.DETAILED_PROJECT.ordinal());
	}
}
