package kickstarter.mvc;

import java.util.ArrayList;
import java.util.List;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.modelState.ModelValues;
import kickstarter.pages.modelContent.PageModel;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;

public class Model implements iModel {
	
	private int currentPage;
	private ModelValues modelValues;

	private List<PageModel> pagesModel;
	private PageModel pageModel;
	private int savePage;

	public Model() {
		modelValues = new ModelValues();
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
//TODO throw new ModelException
			e.printStackTrace();
		}
	}

	@Override
	public void setModelValues(ModelValues setO) {
		this.modelValues = setO;
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
	public ModelValues getModelValues() {
		return modelValues;
	}

	@Override
	public void nextWithValues(int next, ModelValues o) {
		this.currentPage = next;
		this.modelValues = o;
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
	public void setView(iView setView) {
		for (PageModel pageModel : pagesModel) {
			pageModel.iview = setView;
		}
	}

}
