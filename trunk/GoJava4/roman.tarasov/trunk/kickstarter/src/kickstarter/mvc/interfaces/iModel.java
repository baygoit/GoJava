package kickstarter.mvc.interfaces;

import kickstarter.mvc.options.ModelOptions;
import kickstarter.mvc.options.ViewOptions;
import kickstarter.pages.modelContent.PageModel;
import kickstarter.repository.facade.iRepository;

public interface iModel {

	public void updateStateOfModel(String command) ;

	ModelOptions getModelOptions();

	void setModelOptions(ModelOptions options);

	public void setPage(int page);

	void next(int page);

	void savePageBeforeError(int page);

	int getSavedPage();

	void goToAndBack(int toPage, int back);

	public void nextWithOptions(int next, ModelOptions o);

	void setViewOptions(ViewOptions vo);

	ViewOptions getViewOptions();

	void addPageModel(PageModel pageModel);

	public int getCurrentPage();

	public void setRepository(iRepository fileSystemRepository);

	public void setModel(iModel setModel);

	public int getRepositoryErrorPageIndex();

}
