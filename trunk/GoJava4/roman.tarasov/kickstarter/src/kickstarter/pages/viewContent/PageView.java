package kickstarter.pages.viewContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.modelState.ModelValues;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;

public abstract class PageView {
	private  iModel imodel;
	private  iView iview;
	protected String[] strValues;
	protected int[] intValues;
	private  iRepository repository;
	protected ModelValues modelValues;

	public abstract String getHeader() throws RepositoryException;

	public iRepository getRepository() {
		return repository;
	}

	public void setRepository(iRepository repository) {
		this.repository = repository;
	}

	public iModel getImodel() {
		return imodel;
	}

	public void setImodel(iModel imodel) {
		this.imodel = imodel;
	}

	public iView getIview() {
		return iview;
	}

	public void setIview(iView iview) {
		this.iview = iview;
	}

}
