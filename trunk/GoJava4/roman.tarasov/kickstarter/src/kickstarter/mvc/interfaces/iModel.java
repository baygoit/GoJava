package kickstarter.mvc.interfaces;


import kickstarter.mvc.modelState.ModelValues;
import kickstarter.pages.modelContent.PageModel;
import kickstarter.repository.facade.iRepository;

public interface iModel {

	public void updateStateOfModel(String command);

	ModelValues getModelValues();

	void setModelValues(ModelValues values);

	public void setPage(int page);

	void next(int page);

	void savePageBeforeError(int page);

	int getSavedPage();

	void goToAndBack(int toPage, int back);

	public void nextWithValues(int next, ModelValues modelValues);

	void addPageModel(PageModel pageModel);

	public int getCurrentPage();

	public void setRepository(iRepository fileSystemRepository);

	public void setModel(iModel setModel);

	public void setView(iView setView);
	

}
