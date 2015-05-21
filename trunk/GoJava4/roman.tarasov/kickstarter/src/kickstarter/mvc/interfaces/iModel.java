package kickstarter.mvc.interfaces;

import kickstarter.mvc.options.ModelOptions;
import kickstarter.mvc.options.ViewOptions;
import kickstarter.pages.model.PageModel;
import kickstarter.pages.view.PageView;

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

	void addPageModel(PageModel pageModel);

}
