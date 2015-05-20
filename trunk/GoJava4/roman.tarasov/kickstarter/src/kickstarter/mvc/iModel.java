package kickstarter.mvc;

import kickstarter.pages.PageView;
import kickstarter.pages.model.PageModel;
import kickstarter.pages.model.ModelOptions;
import kickstarter.pages.model.ViewOptions;

public interface iModel {
	public void update(String command);

	ModelOptions getModelOptions();

	void setModelOptions(ModelOptions options);

	void add(PageView page, PageModel modelPage);

	public void setPage(int page);

	PageView getPage();

	void next(int page);



	void savePageBeforeError(int page);

	int getSavedPage();

	void goToAndBack(int toPage, int back);

	public void nextWithOptions(int next, ModelOptions o);

	void setViewOptions(ViewOptions vo);

	ViewOptions getViewOptions();

}
