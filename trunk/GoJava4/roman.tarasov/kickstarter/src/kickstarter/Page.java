package kickstarter;

public class Page implements UserInterface{
	Page next;
	Page[] pages;
	UserInterface ui;
	Category categoryToProjectsView;

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
