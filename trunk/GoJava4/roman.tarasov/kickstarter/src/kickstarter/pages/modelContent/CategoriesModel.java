package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.viewState.ViewValues;

public class CategoriesModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("e")) {
			getImodel().next(IndexOfPage.END_PAGE.ordinal());
			return;
		}
		if (message.equals("r")) {
			getImodel().next(IndexOfPage.REPOSITORY_MENU_PAGE.ordinal());
			return;
		}
		ViewValues ViewValues = getIview().getViewValues();
		if (ViewValues.getRepositoryError()) {
			getImodel().next(IndexOfPage.REPOSITORY_MENU_PAGE.ordinal());
			return;
		}
		strValues = ViewValues.getStrCategories();
		intValues = ViewValues.getIntCategories();

		if (strValues != null) {

			for (int index = 0; index < strValues.length; index++) {
				if (message.equals(strValues[index])) {
					modelValues = getImodel().getModelValues();
					modelValues.setIntSelectedCategory(intValues[index]);
					getImodel().nextWithValues(IndexOfPage.PROJECTS.ordinal(),
							modelValues);
					return;
				}
			}
		}
		getImodel().goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.CATEGORIES.ordinal());
	}

}
