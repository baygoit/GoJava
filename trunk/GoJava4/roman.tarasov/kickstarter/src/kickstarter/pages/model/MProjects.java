package kickstarter.pages.model;

import kickstarter.mvc.iModel;

public class MProjects extends PageModel {
	public MProjects(iModel imodel) {
		super(imodel);
	}

	public void execute(String message) {
		saveCategory(intOption);
		if (message.equals("p")) {
			imodel.next(CATEGORIES);
			return;
		}
		ModelOptions in = imodel.getOptions();

		if (in.strOptions != null) {
			for (int index = 0; index < in.strOptions.length; index++) {
				if (message.equals(in.strOptions[index])) {
					ModelOptions o = new ModelOptions();
					o.intOption = intOptions[index];
					o.strOption = strOptions[index];
					imodel.nextWithOptions(DETAILED_PROJECT, o);
					return;
				}
			}
		}
		imodel.goToAndBack(ERROR_PAGE, PROJECTS);
	}
}
