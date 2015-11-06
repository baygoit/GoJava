package ua.com.goit.gojava7.kickstarter;

public class Project {

	private String projectName;
	private String projectCategory;
	private String projectDescription;
	private double projectAimBalance;
	private double projectCurrentBalance;
	private int daysLeft;

	public Project(String projectName, String projectCategory,
			String projectDescription, double projectAimBalance,
			double projectCurrentBalance, int daysLeft) {
		super();
		this.projectName = projectName;
		this.projectCategory = projectCategory;
		this.projectDescription = projectDescription;
		this.projectAimBalance = projectAimBalance;
		this.projectCurrentBalance = projectCurrentBalance;
		this.daysLeft = daysLeft;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public double getProjectAimBalance() {
		return projectAimBalance;
	}

	public void setProjectAimBalance(double projectAimBalance) {
		this.projectAimBalance = projectAimBalance;
	}

	public double getProjectCurrentBalance() {
		return projectCurrentBalance;
	}

	public void setProjectCurrentBalance(double projectCurrentBalance) {
		this.projectCurrentBalance = projectCurrentBalance;
	}

	public int getdaysLeft() {
		return daysLeft;
	}

	public void setdaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

}
