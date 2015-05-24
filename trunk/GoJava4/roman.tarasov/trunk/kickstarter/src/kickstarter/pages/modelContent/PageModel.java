package kickstarter.pages.modelContent;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.pages.viewContent.PageView;
import kickstarter.payment.Bank;
import kickstarter.repository.facade.Repository;

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
	
	protected String[] strOptions;
	protected int[] intOptions;
	protected int intOption;
	protected String strOption;
	protected int pageId;
	protected int nextPage;
	protected Project project;
	protected Bank bank;
	protected Repository repository;
	protected ProjectComments projectComments;
	protected ModelOptions modelOptions;
	protected iModel imodel;
	protected PageView page;


	PageModel(iModel imodel) {
		this.imodel = imodel;
	}

	public abstract void updateStateOfPageModel(String message);
}
