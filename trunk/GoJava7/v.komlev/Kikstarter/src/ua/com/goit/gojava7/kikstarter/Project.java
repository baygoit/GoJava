package ua.com.goit.gojava7.kikstarter;

/**
 * class contain list projects, short description and amount first payment
 */
public class Project {

	private String projectName;
	private String projectDescription;
	private String projectDetailedDescription;
	private String projectUrl;
	private int projectNecessaryAmount;
	private int projectAmountCollected;
	private int projectDaysToEnd;

	public Project(String projectName, int projectNecessaryAmount, int projectAmountCollected,
			int projectDaysToEnd) {
		this.projectName = projectName;
		this.projectNecessaryAmount = projectNecessaryAmount;
		this.projectAmountCollected = projectAmountCollected;
		this.projectDaysToEnd = projectDaysToEnd;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public String getProjectDetailedDescription() {
		return projectDetailedDescription;
	}

	public String getProjectUrl() {
		return projectUrl;
	}

	public int getProjectNecessaryAmount() {
		return projectNecessaryAmount;
	}

	public int getProjectAmountCollected() {
		return projectAmountCollected;
	}

	public int getProjectDaysToEnd() {
		return projectDaysToEnd;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public void setProjectDetailedDescription(String projectDetailedDescription) {
		this.projectDetailedDescription = projectDetailedDescription;
	}

	public void setProjectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}

	public void setProjectNecessaryAmount(int projectNecessaryAmount) {
		this.projectNecessaryAmount = projectNecessaryAmount;
	}

	public void setProjectAmountCollected(int projectAmountCollected) {
		this.projectAmountCollected += projectAmountCollected;
	}

	public void setProjectDaysToEnd(int projectDaysToEnd) {
		this.projectDaysToEnd = projectDaysToEnd;
	}

	public void setProjectSumFromUser(int enteredAmount) {
		projectAmountCollected += enteredAmount;
	}

}
