package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;

public class DetailedProjectModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			modelValues = getImodel().getModelValues();
			getImodel().nextWithValues(IndexOfPage.PROJECTS.ordinal(), modelValues);
			return;
		}
		if (message.equals("c")) {
			getImodel().next(IndexOfPage.COMMENT_PAGE.ordinal());
			return;
		}
		if (message.equals("i")) {
			modelValues = getImodel().getModelValues();
			getImodel().nextWithValues(IndexOfPage.INVEST_PAGE.ordinal(),
					modelValues);
			return;
		}
		if (message.equals("d")) {
			modelValues = getImodel().getModelValues();
			getImodel().nextWithValues(IndexOfPage.DONATE_PAGE.ordinal(),
					modelValues);
			return;
		}
		getImodel().goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.DETAILED_PROJECT.ordinal());
	}
}
