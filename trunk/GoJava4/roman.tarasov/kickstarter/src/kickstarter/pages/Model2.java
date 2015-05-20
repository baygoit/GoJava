package kickstarter.pages;

import kickstarter.entities.Project;
import kickstarter.entities.ProjectComments;
import kickstarter.mvc.iNavigator;
import kickstarter.payment.Bank;
import kickstarter.repository.CommentsRepository;
import kickstarter.repository.ProjectRepository;
import kickstarter.repository.iStorage;

public class Model2 implements iNavigator{
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
	public String[] sOptions;
	public int[] iOptions;
	public int iOption;
	public String sOption;
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
	private int pageIndex;

	private iStorage<Page> pages;
	

	Page page;

	private int savePage;
	public void saveCategory(int selectedCategory) {
		this.selectedCategory = selectedCategory;
	}
	public void update(String command) {
		page = pages.getEntity(pageIndex);
		page.execute(command);
		page = pages.getEntity(pageIndex);
		page.iOption = iOption;
		page.sOption = sOption;
	}

	public void setPage(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public Page getPage() {
		return pages.getEntity(pageIndex);
	}

	public void add(Page page) {
		pages.add(page);
	}

	public void next(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setOption(int intOption, String stringOption) {
		this.iOption = intOption;
		this.sOption = stringOption;
	}

	

	public int getSavedCategory() {
		return selectedCategory;
	}

	public void savePageBeforeError(int savePage) {
		this.savePage = savePage;
	}

	public int getSavedPage() {
		return savePage;
	}

	public void goToAndBack(int toPage, int back) {
		this.savePage = back;
		this.pageIndex = toPage;

	}

	public void nextWithOptions(int page, int iOption, String sOption) {
		this.pageIndex = page;
		this.iOption = iOption;
		this.sOption = sOption;

	}
}
