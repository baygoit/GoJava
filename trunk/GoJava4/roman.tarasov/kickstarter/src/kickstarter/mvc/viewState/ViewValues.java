package kickstarter.mvc.viewState;

public class ViewValues {
	private int[] intCategories;
	private String[] strCategories;
	private int intOption;
	private String strOption;
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

	public int getIntOption() {
		return intOption;
	}

	public void setIntOption(int intOption) {
		this.intOption = intOption;
	}

	public String getStrOption() {
		return strOption;
	}

	public void setStrOption(String strOption) {
		this.strOption = strOption;
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
