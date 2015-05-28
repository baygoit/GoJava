package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;



public class DetailedProjectModel extends PageModel {


	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			modelOptions = imodel.getModelOptions();
			imodel.nextWithOptions(IndexOfPage.PROJECTS.ordinal(), modelOptions);
			return;
		}
		if (message.equals("c")) {
			imodel.next(IndexOfPage.COMMENT_PAGE.ordinal());
			return;
		}
		if (message.equals("i")) {
			modelOptions = imodel.getModelOptions();
			modelOptions.intOption = intOption;
			imodel.nextWithOptions(IndexOfPage.INVEST_PAGE.ordinal(), modelOptions);
			return;
		}
		if (message.equals("d")) {
			modelOptions = imodel.getModelOptions();
			modelOptions.intOption = intOption;
			imodel.nextWithOptions(IndexOfPage.DONATE_PAGE.ordinal(), modelOptions);
			return;
		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(), IndexOfPage.DETAILED_PROJECT.ordinal());
	}
}
