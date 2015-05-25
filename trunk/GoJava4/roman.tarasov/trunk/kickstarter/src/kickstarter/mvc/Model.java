package kickstarter.mvc;

import java.util.ArrayList;
import java.util.List;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.mvc.options.ViewOptions;
import kickstarter.pages.modelContent.PageModel;

public class Model implements iModel {

	private int currentPage;
	private ModelOptions modelOptions;
	private ViewOptions viewOptions;

	private List<PageModel> pagesModel;
	private PageModel pageModel;
	private int savePage;

	public Model() {
		modelOptions = new ModelOptions();
		viewOptions = new ViewOptions();
		pagesModel = new ArrayList<PageModel>();
	}

	@Override
	public void addPageModel(PageModel pageModel) {
		pagesModel.add(pageModel);
	}

	@Override
	public void updateStateOfModel(String message) {
		pageModel = pagesModel.get(currentPage);
		pageModel.updateStateOfPageModel(message);
	}

	@Override
	public void setModelOptions(ModelOptions setO) {
		this.modelOptions = setO;
	}

	@Override
	public void setPage(int setPage) {
		this.currentPage = setPage;
	}

	@Override
	public int getCurrentPage() {
		return currentPage;
	}

	@Override
	public void next(int nextPage) {
		this.currentPage = nextPage;
	}

	@Override
	public void savePageBeforeError(int saved) {
		this.savePage = saved;
	}

	@Override
	public int getSavedPage() {
		return savePage;
	}

	@Override
	public void goToAndBack(int toPage, int back) {
		this.savePage = back;
		this.currentPage = toPage;
	}

	@Override
	public ModelOptions getModelOptions() {
		return modelOptions;
	}

	@Override
	public void nextWithOptions(int next, ModelOptions o) {
		this.currentPage = next;
		this.modelOptions = o;
	}

	@Override
	public void setViewOptions(ViewOptions vo) {
		this.viewOptions = vo;
	}

	@Override
	public ViewOptions getViewOptions() {
		return viewOptions;
	}
}
