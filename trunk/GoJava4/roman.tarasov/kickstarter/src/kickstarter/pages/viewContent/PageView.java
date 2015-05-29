package kickstarter.pages.viewContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.modelState.ModelValues;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;

public abstract class PageView {
	protected iModel imodel;
	protected iView iview;
	protected String[] strValues;
	protected int[] intValues;
	protected iRepository repository;
	protected ModelValues modelValues;

	public abstract String getHeader() throws RepositoryException;

	public void setRepository(iRepository repository) {
		this.repository = repository;
	}

	public void setImodel(iModel imodel) {
		this.imodel = imodel;
	}

	public void setIview(iView iview) {
		this.iview = iview;
	}

}
