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
	public iRepository repository;
	protected ModelValues modelValues;
	public iModel imodel;
	public iView iview;
	protected PageView page;

	public abstract void updateStateOfPageModel(String message)
			throws RepositoryException;
}
