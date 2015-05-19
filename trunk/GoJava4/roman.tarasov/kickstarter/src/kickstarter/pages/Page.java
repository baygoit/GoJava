package kickstarter.pages;

import kickstarter.mvc.iNavigator;
import kickstarter.payment.Bank;
import kickstarter.repository.CategoriesRepository;
import kickstarter.repository.CommentsRepository;
import kickstarter.repository.ProjectRepository;
import kickstarter.repository.QuotesRepository;

public class Page {
	iNavigator navigator;
	ProjectRepository projects;
	CommentsRepository allComments;
	QuotesRepository quotesRepository;
	CategoriesRepository categories;
	
	
	final int CATEGORIES = 0;
	final int PROJECTS = 1;
	final int DETAILED_PROJECT = 2;
	final int ERROR_PAGE = 3;
	final int END_PAGE = 4;
	final int COMMENT_PAGE = 5;
	final int INVEST_PAGE = 6;
	final int DONATE_PAGE = 7;
	final int BANK_OPERATION_RESULT_PAGE = 8;
	
	public String[] options;
	public int[] optionsInt;
	public int parameterForPage;
	public String  stringParameterForPage;
	public int selectedCategory;
	public int selectedProject;
	public int pageId;
	public String name;
	int nextPage;



	public void execute(String parameter) {
	}

	public String[] getOptions() {
		return null;
	}

	public void viewWorkedStatus(int status) {
	}

	public int getNextPage() {
		return nextPage;
	}

	public String getHeader() {
		return null;
	}
}
