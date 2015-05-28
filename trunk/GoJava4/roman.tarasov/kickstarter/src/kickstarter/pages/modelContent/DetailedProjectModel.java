package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;

public class DetailedProjectModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			modelValues = imodel.getModelValues();
			imodel.nextWithValues(IndexOfPage.PROJECTS.ordinal(), modelValues);
			return;
		}
		if (message.equals("c")) {
			imodel.next(IndexOfPage.COMMENT_PAGE.ordinal());
			return;
		}
		if (message.equals("i")) {
			modelValues = imodel.getModelValues();
			modelValues.intValue = intValue;
			imodel.nextWithValues(IndexOfPage.INVEST_PAGE.ordinal(),
					modelValues);
			return;
		}
		if (message.equals("d")) {
			modelValues = imodel.getModelValues();
			modelValues.intValue = intValue;
			imodel.nextWithValues(IndexOfPage.DONATE_PAGE.ordinal(),
					modelValues);
			return;
		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.DETAILED_PROJECT.ordinal());
	}
}
