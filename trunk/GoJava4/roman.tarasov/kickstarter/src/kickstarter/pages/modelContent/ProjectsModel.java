package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.viewState.ViewValues;

public class ProjectsModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			imodel.next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		ViewValues ViewValues = iview.getViewValues();

		if (ViewValues.intProjects != null) {
			for (int index = 0; index < ViewValues.intProjects.length; index++) {
				if (message.equals(ViewValues.strProjects[index])) {
					modelValues = imodel.getModelValues();
					modelValues.intSelectedProject = ViewValues.intProjects[index];
					modelValues.strSelectedProject = ViewValues.strProjects[index];
					imodel.nextWithValues(
							IndexOfPage.DETAILED_PROJECT.ordinal(), modelValues);
					return;
				}
			}
		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.PROJECTS.ordinal());
	}
}
