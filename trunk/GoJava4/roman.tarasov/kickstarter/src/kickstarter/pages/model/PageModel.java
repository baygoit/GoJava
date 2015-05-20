package kickstarter.pages.model;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.iModel;
import kickstarter.pages.PageView;
import kickstarter.payment.Bank;
import kickstarter.repository.CommentsRepository;
import kickstarter.repository.ProjectRepository;

public class PageModel {
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
	public String strOption;
	public int selectedCategory;
	public int selectedProject;
	public int pageId;
	public String name;
	int nextPage;
	Project project;
	Bank bank;
	ProjectRepository projects;
	CommentsRepository allComments;
	ProjectComments projectComments;
	iModel imodel;
	PageView page;

	public void saveCategory(int selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public PageView getPage() {
		return null;
	}

	PageModel(iModel imodel) {
		this.imodel = imodel;
	}

	public void execute(String command) {
	}
}
