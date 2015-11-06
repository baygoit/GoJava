package ua.com.goit.gojava7.kickstarter;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Project {
	private String projectName;
	private String projectShortDescription;
	private Double projectCostNeed;
	private Double projectCostsCollected = 0D;
	private Calendar deadline = new GregorianCalendar();

	public Project(String projectName, String projectShortDescription,
			Double projectCostNeed, int projectDaysNeed) {
		this.projectName = projectName;
		this.projectShortDescription = projectShortDescription;
		this.projectCostNeed = projectCostNeed;
		deadline.add(Calendar.DAY_OF_YEAR, projectDaysNeed);
	}

	public String getProjectName() {
		return this.projectName;
	}

	public String getProjectShortDescription() {
		return this.projectShortDescription;
	}

	public int getProjectDaysLeft() {
		Calendar today = new GregorianCalendar();
		return (int) ((deadline.getTimeInMillis() - today.getTimeInMillis())
				/ 1000 / 60 / 60 / 24);
	}

	public Double getProjectCostNeed() {
		return this.projectCostNeed;
	}

	public Double getProjectCostCollected() {
		return this.projectCostsCollected;
	}

	public void setProjectCostCollected(Double price) {
		projectCostsCollected += price;
	}

}
