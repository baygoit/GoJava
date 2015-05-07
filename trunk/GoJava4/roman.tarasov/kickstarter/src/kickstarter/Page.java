package kickstarter;

public class Page implements UserInterface{
	Page next;
	Page[] pages;
	UserInterface ui;
	Category categoryToUserProjectsView;
	Project projectToProjectView;
	
	final int PAGE_LOGIN=0;
	final int ADMIN_CATEGORIES_CONTROL=1;
	final int USER_CATEGORIES_VIEW=2;
	final int PAGE_USER_PROJECTS_VIEW=3;

	void setUI(UserInterface ui) {
		this.ui = ui;
	}

	void setPages(Page[] pages) {
		this.pages = pages;
	}

	void setNextPage(Page next) {
		this.next = next;
	}

	Page getNextPage() {
		
		return null;

	}

	@Override
	public String inputString() {
		
		return null;
	}

	@Override
	public void display(String stringToDisplay) {
	
		
	}
}
