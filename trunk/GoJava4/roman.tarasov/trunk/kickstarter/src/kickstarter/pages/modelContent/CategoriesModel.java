package kickstarter.pages.modelContent;


import kickstarter.mvc.options.ViewOptions;

public class CategoriesModel extends PageModel {
	
	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("e")) {
			imodel.next(END_PAGE);
			return;
		}
		if (message.equals("r")) {
			imodel.next(REPOSITORY_MENU_PAGE);
			return;
		}
		ViewOptions viewOptions = imodel.getViewOptions();
		if(viewOptions.repositoryError){
		imodel.next(REPOSITORY_MENU_PAGE);
			return;
		}
		strOptions = viewOptions.strCategories;
		intOptions = viewOptions.intCategories;

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
