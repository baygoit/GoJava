package kickstarter.mvc.interfaces;

import kickstarter.dao.interfaces.iDAO;
import kickstarter.mvc.modelState.ModelValues;
import kickstarter.pages.modelContent.PageModel;

public interface iModel {

	public void updateStateOfModel(String command);

	ModelValues getModelValues();

	public void setPage(int page);

	void next(int page);

	void savePageBeforeError(int page);

	int getSavedPage();

	void goToAndBack(int toPage, int back);

	void addPageModel(PageModel pageModel);

	public int getCurrentPage();

	public void setModel(iModel setModel);

	public void setView(iView setView);

	void setIDAO(iDAO idao);

}
