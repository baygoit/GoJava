package kickstarter.pages.view;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.options.ModelOptions;
import kickstarter.payment.Bank;
import kickstarter.repository.CategoriesRepository;
import kickstarter.repository.CommentsRepository;
import kickstarter.repository.ProjectRepository;
import kickstarter.repository.QuotesRepository;

public class PageView {
	iModel imodel;
	ProjectRepository projects;
	CommentsRepository allComments;
	QuotesRepository quotesRepository;
	CategoriesRepository categories;
	Bank bank;
	ProjectComments projectComments;
	Project project;
	iModel model;
	final int CATEGORIES = 0;
	final int PROJECTS = 1;
	final int DETAILED_PROJECT = 2;
	final int ERROR_PAGE = 3;
	final int END_PAGE = 4;
	final int COMMENT_PAGE = 5;
	final int INVEST_PAGE = 6;
	final int DONATE_PAGE = 7;
	final int BANK_OPERATION_RESULT_PAGE = 8;
	final int APPLY_TRANSACTION_PAGE = 9;

	public String[] strOptions;
	public int[] intOptions;
	public int intOption;
	public String sOption;
	public int selectedCategory;
	public int selectedProject;
	public int pageId;
	public String name;
	int nextPage;
	ModelOptions options;

	public void execute(String parameter) {
	}

	public int getNextPage() {
		return nextPage;
	}

	public String getHeader() {
		return null;
	}
}
