package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ViewOptions;

public class CategoriesModel extends PageModel {
	public CategoriesModel(iModel imodel) {
		super(imodel);
	}
	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("e")) {
			imodel.next(END_PAGE);
			return;
		}
		ViewOptions vieOptions = imodel.getViewOptions();
		strOptions = vieOptions.strCategories;
		intOptions = vieOptions.intCategories;

		if (strOptions != null) {
			
			for (int index = 0; index < strOptions.length; index++) {
				if (message.equals(strOptions[index])) {
					modelOptions = imodel.getModelOptions();
					modelOptions.intOption = intOptions[index];
					modelOptions.intSelectedCategory = intOptions[index];
					modelOptions.strSelectedCategory = strOptions[index];
					imodel.nextWithOptions(PROJECTS, modelOptions);
					return;
				}
			}
		}
		imodel.goToAndBack(ERROR_PAGE, CATEGORIES);
	}

}
