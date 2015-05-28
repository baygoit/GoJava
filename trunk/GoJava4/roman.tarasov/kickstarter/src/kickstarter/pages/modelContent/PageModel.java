package kickstarter.pages.modelContent;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.pages.viewContent.PageView;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;

public abstract class PageModel {

	protected String[] strOptions;
	protected int[] intOptions;
	protected int intOption;
	protected String strOption;
	protected int pageId;
	protected int nextPage;
	protected Project project;
	protected Bank bank;
	public iRepository repository;
	protected ProjectComments projectComments;
	protected ModelOptions modelOptions;
	public iModel imodel;
	public iView iview;
	protected PageView page;

	public abstract void updateStateOfPageModel(String message)
			throws RepositoryException;
}
