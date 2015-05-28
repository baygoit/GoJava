package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.options.ViewOptions;

public class ProjectsModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			imodel.next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		ViewOptions viewOptions = imodel.getViewOptions();

		if (viewOptions.intProjects != null) {
			for (int index = 0; index < viewOptions.intProjects.length; index++) {
				if (message.equals(viewOptions.strProjects[index])) {
					modelOptions = imodel.getModelOptions();
					modelOptions.intSelectedProject = viewOptions.intProjects[index];
					modelOptions.strSelectedProject = viewOptions.strProjects[index];
					imodel.nextWithOptions(IndexOfPage.DETAILED_PROJECT.ordinal(), modelOptions);
					return;
				}
			}
		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(), IndexOfPage.PROJECTS.ordinal());
	}
}
