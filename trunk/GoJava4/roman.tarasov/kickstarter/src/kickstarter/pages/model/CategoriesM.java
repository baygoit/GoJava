package kickstarter.pages.model;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.mvc.options.ViewOptions;

public class CategoriesM extends PageModel {
	public CategoriesM(iModel imodel) {
		super(imodel);
	}
	@Override
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
