package kickstarter.mvc.viewState;

public class ViewValues {
	private int[] intCategories;
	private String[] strCategories;
	private int[] intProjects;
	private String[] strProjects;
	private boolean repositoryError;

	public int[] getIntCategories() {
		return intCategories;
	}

	public void setIntCategories(int[] intCategories) {
		this.intCategories = intCategories;
	}

	public String[] getStrCategories() {
		return strCategories;
	}

	public void setStrCategories(String[] strCategories) {
		this.strCategories = strCategories;
	}

	public int[] getIntProjects() {
		return intProjects;
	}

	public void setIntProjects(int[] intProjects) {
		this.intProjects = intProjects;
	}

	public String[] getStrProjects() {
		return strProjects;
	}

	public void setStrProjects(String[] strProjects) {
		this.strProjects = strProjects;
	}

	public void setRepositoryError(boolean repositoryError) {
		this.repositoryError = repositoryError;
	}

	public boolean getRepositoryError() {
		return repositoryError;
	}

}
