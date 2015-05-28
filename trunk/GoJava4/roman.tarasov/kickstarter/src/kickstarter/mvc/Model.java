package kickstarter.mvc;

import java.util.ArrayList;
import java.util.List;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.pages.modelContent.PageModel;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;

public class Model implements iModel {
	
	private int currentPage;
	private ModelOptions modelOptions;

	private List<PageModel> pagesModel;
	private PageModel pageModel;
	private int savePage;

	public Model() {
		modelOptions = new ModelOptions();
		pagesModel = new ArrayList<PageModel>();
	}

	@Override
	public void addPageModel(PageModel pageModel) {
		pagesModel.add(pageModel);
	}

	@Override
	public void updateStateOfModel(String message) {

		try {
			pageModel = pagesModel.get(currentPage);
			pageModel.updateStateOfPageModel(message);
		} catch (RepositoryException e) {

			e.printStackTrace();
		}
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
	public void setRepository(iRepository setRepository) {
		for (PageModel pageModel : pagesModel)
			pageModel.repository = setRepository;
	}

	@Override
	public void setModel(iModel setModel) {
		for (PageModel pageModel : pagesModel) {
			pageModel.imodel = setModel;
		}
	}


	@Override
	public void setView(View view) {
		for (PageModel pageModel : pagesModel) {
			pageModel.iview = view;
		}
	}

}
