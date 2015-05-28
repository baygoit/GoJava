package kickstarter.pages.modelContent;


import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.viewState.ViewOptions;

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
		ViewOptions ViewOptions = iview.getViewOptions();
		if(ViewOptions.repositoryError){
		imodel.next(IndexOfPage.REPOSITORY_MENU_PAGE.ordinal());
			return;
		}
		strOptions = ViewOptions.strCategories;
		intOptions = ViewOptions.intCategories;

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
