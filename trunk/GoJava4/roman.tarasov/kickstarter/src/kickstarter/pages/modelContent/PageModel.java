package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.modelState.ModelValues;
import kickstarter.pages.viewContent.PageView;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;

public abstract class PageModel {

	protected String[] strValues;
	protected int[] intValues;
	protected int intValue;
	protected String strValue;
	protected int pageId;
	protected int nextPage;
	protected  iRepository repository;
	protected ModelValues modelValues;
	private  iModel imodel;
	private  iView iview;
	protected PageView page;

	public abstract void updateStateOfPageModel(String message)
			throws RepositoryException;

	public iRepository getRepository() {
		return repository;
	}

	public void setRepository(iRepository repository) {
		this.repository = repository;
	}

	public iView getIview() {
		return iview;
	}

	public void setIview(iView iview) {
		this.iview = iview;
	}

	public iModel getImodel() {
		return imodel;
	}

	public void setImodel(iModel imodel) {
		this.imodel = imodel;
	}
}
