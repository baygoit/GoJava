package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.viewState.ViewValues;

public class ProjectsModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			getImodel().next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		ViewValues ViewValues = getIview().getViewValues();

		if (ViewValues.getIntProjects() != null) {
			for (int index = 0; index < ViewValues.getIntProjects().length; index++) {
				if (message.equals(ViewValues.getStrProjects()[index])) {
					modelValues = getImodel().getModelValues();
					modelValues.setIntSelectedProject(ViewValues.getIntProjects()[index]);
					modelValues.setStrSelectedProject(ViewValues.getStrProjects()[index]);
					getImodel().nextWithValues(
							IndexOfPage.DETAILED_PROJECT.ordinal(), modelValues);
					return;
				}
			}
		}
		getImodel().goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.PROJECTS.ordinal());
	}
}
