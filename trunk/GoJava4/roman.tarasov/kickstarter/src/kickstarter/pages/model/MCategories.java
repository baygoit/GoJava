package kickstarter.pages.model;

import kickstarter.mvc.iModel;

public class MCategories extends PageModel {
	public MCategories(iModel imodel) {
		super(imodel);
	}

	public void execute(String message) {
		if (message.equals("e")) {
			imodel.next(END_PAGE);
			return;
		}
		ViewOptions options = imodel.getViewOptions();
		strOptions = options.strCategories;
		intOptions = options.intCategories;

		if (strOptions != null) {
			for (int index = 0; index < strOptions.length; index++) {
				if (message.equals(strOptions[index])) {
					ModelOptions o = imodel.getModelOptions();
					o.intOption = intOptions[index];
					o.intSelectedCategory = intOptions[index];
					o.strSelectedCategory = strOptions[index];
					imodel.nextWithOptions(PROJECTS, o);
					return;
				}
			}
		}
		imodel.goToAndBack(ERROR_PAGE, CATEGORIES);
	}
}
