package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.mvc.options.ViewOptions;

public class ProjectsModel extends PageModel {
	public ProjectsModel(iModel imodel) {
		super(imodel);
	}
	@Override
	public void update(String message) {

		if (message.equals("p")) {
			imodel.next(CATEGORIES);
			return;
		}
		ViewOptions in = imodel.getViewOptions();

		if (in.intProjects != null) {
			for (int index = 0; index < in.intProjects.length; index++) {
				if (message.equals(in.strProjects[index])) {
					ModelOptions o = imodel.getModelOptions();
					o.intSelectedProject = in.intProjects[index];
					o.strSelectedProject = in.strProjects[index];
					imodel.nextWithOptions(DETAILED_PROJECT, o);
					return;
				}
			}
		}
		imodel.goToAndBack(ERROR_PAGE, PROJECTS);
	}
}
