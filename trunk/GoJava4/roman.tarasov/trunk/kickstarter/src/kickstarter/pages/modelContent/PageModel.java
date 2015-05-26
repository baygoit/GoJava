package kickstarter.pages.modelContent;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.pages.viewContent.PageView;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;

public abstract class PageModel {

	protected final int CATEGORIES = 0;
	protected final int PROJECTS = 1;
	protected final int DETAILED_PROJECT = 2;
	protected final int ERROR_PAGE = 3;
	protected final int END_PAGE = 4;
	protected final int COMMENT_PAGE = 5;
	protected final int INVEST_PAGE = 6;
	protected final int DONATE_PAGE = 7;
	protected final int BANK_OPERATION_RESULT_PAGE = 8;
	protected final int APPLY_TRANSACTION_PAGE = 9;
	protected final int REPOSITORY_MENU_PAGE = 10;

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
	protected PageView page;

	public abstract void updateStateOfPageModel(String message)
			throws RepositoryException;
}
