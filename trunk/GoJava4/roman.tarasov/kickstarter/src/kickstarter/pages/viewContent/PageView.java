package kickstarter.pages.viewContent;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.modelState.ModelValues;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;

public abstract class PageView {
	public iModel imodel;
	public iView iview;
	protected String[] strValues;
	protected int[] intValues;
	public iRepository repository;
	protected ModelValues modelValues;

	public abstract String getHeader() throws RepositoryException;

}
