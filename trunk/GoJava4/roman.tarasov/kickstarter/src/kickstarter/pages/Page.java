package kickstarter.pages;

public class Page {

	public String[] options;
	public int[] optionsInt;
	public int parameterForPage;
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
