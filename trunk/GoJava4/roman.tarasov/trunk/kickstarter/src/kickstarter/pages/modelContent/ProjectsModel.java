package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ViewOptions;

public class ProjectsModel extends PageModel {
	public ProjectsModel(iModel imodel) {
		super(imodel);
	}
	@Override
	public void updateStateOfPageModel(String message) {

		if (message.equals("p")) {
			imodel.next(CATEGORIES);
			return;
		}
		ViewOptions viewOptions = imodel.getViewOptions();

		if (viewOptions.intProjects != null) {
			for (int index = 0; index < viewOptions.intProjects.length; index++) {
				if (message.equals(viewOptions.strProjects[index])) {
					modelOptions = imodel.getModelOptions();
					modelOptions.intSelectedProject = viewOptions.intProjects[index];
					modelOptions.strSelectedProject = viewOptions.strProjects[index];
					imodel.nextWithOptions(DETAILED_PROJECT, modelOptions);
					return;
				}
			}
		}
		imodel.goToAndBack(ERROR_PAGE, PROJECTS);
	}
}
