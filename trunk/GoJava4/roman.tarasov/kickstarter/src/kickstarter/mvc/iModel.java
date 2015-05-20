package kickstarter.mvc;

import kickstarter.pages.PageView;
import kickstarter.pages.model.PageModel;
import kickstarter.pages.model.ModelOptions;
import kickstarter.pages.model.ViewOptions;



public interface iModel {
	public void update(String command);
	ModelOptions getOptions();
	void setOptions(ModelOptions options);
	void add(PageView page, PageModel modelPage);
	public void setPage(int page);
	PageView getPage();
	
	void next(int page);

	void saveCategory(int selectedCategory);

	int getSavedCategory();

	void savePageBeforeError(int page);

	int getSavedPage();

	void goToAndBack(int toPage, int back);

	public void nextWithOptions(int next, ModelOptions o);
	//public void setModelOptions(Options o);
	void setViewOptions(ViewOptions vo);
	
	
}
