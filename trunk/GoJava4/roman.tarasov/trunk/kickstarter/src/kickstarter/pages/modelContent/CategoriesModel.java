package kickstarter.pages.modelContent;


import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.options.ViewOptions;

public class CategoriesModel extends PageModel {
	
	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("e")) {
			imodel.next(IndexOfPage.END_PAGE.ordinal());
			return;
		}
		if (message.equals("r")) {
			imodel.next(IndexOfPage.REPOSITORY_MENU_PAGE.ordinal());
			return;
		}
		ViewOptions viewOptions = imodel.getViewOptions();
		if(viewOptions.repositoryError){
		imodel.next(IndexOfPage.REPOSITORY_MENU_PAGE.ordinal());
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
					imodel.nextWithOptions(IndexOfPage.PROJECTS.ordinal(), modelOptions);
					return;
				}
			}
		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(), IndexOfPage.CATEGORIES.ordinal());
	}

}
