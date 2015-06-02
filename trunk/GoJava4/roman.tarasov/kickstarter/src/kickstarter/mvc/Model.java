package kickstarter.mvc;

import java.util.ArrayList;
import java.util.List;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.modelState.ModelValues;
import kickstarter.pages.modelContent.PageModel;

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
	public void setIDAO(iDAO idao) {
		for (PageModel pageModel : pagesModel) {
			pageModel.setIDAO(idao);
		}
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
		} catch (ServiceException e) {
			// TODO throw new ModelException
			e.printStackTrace();
		}
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
	public void setModel(iModel setModel) {
		for (PageModel pageModel : pagesModel) {
			pageModel.setImodel(setModel);
		}
	}

	@Override
	public void setView(iView setView) {
		for (PageModel pageModel : pagesModel) {
			pageModel.setIview(setView);
		}
	}

}
