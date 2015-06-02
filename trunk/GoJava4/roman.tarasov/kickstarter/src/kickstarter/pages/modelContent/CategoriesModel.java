package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.viewState.ViewValues;

public class CategoriesModel extends PageModel {

	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("e")) {
			imodel.next(IndexOfPage.END_PAGE.ordinal());
			return;
		}
		if (message.equals("d")) {
			imodel.next(IndexOfPage.DAO_MENU_PAGE.ordinal());
			return;
		}
		ViewValues ViewValues = iview.getViewValues();
		if (ViewValues.getRepositoryError()) {
			imodel.next(IndexOfPage.DAO_MENU_PAGE.ordinal());
			return;
		}
		strValues = ViewValues.getStrCategories();
		intValues = ViewValues.getIntCategories();

		if (strValues != null) {

			for (int index = 0; index < strValues.length; index++) {
				if (message.equals(strValues[index])) {
					modelValues = imodel.getModelValues();
					modelValues.setIntSelectedCategory(intValues[index]);
					imodel.next(IndexOfPage.PROJECTS.ordinal());
					return;
				}
			}
		}
		imodel.goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.CATEGORIES.ordinal());
	}

}
