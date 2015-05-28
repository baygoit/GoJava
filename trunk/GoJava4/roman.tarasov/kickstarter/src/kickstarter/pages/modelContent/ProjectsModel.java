package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.viewState.ViewOptions;

public class ProjectsModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			imodel.next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		ViewOptions ViewOptions = iview.getViewOptions();

		if (ViewOptions.intProjects != null) {
			for (int index = 0; index < ViewOptions.intProjects.length; index++) {
				if (message.equals(ViewOptions.strProjects[index])) {
					modelOptions = imodel.getModelOptions();
					modelOptions.intSelectedProject = ViewOptions.intProjects[index];
					modelOptions.strSelectedProject = ViewOptions.strProjects[index];
					imodel.nextWithOptions(IndexOfPage.DETAILED_PROJECT.ordinal(), modelOptions);
					return;
				}
			}
		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(), IndexOfPage.PROJECTS.ordinal());
	}
}
