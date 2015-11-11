package ua.com.goit.gojava7.kickstarter;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Project {
	private String projectName;
	private String projectShortDescription;
	private int projectCostNeed;
	private int projectCostsCollected = 0;
	private Calendar deadline = new GregorianCalendar();

	public Project(String projectName, String projectShortDescription,
			int projectCostNeed, int projectDaysNeed) {
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
				/ 1000 / 60 / 60 / 24);// OLEG Magic number. Think about timezone
	}

	public int getProjectCostNeed() {
		return this.projectCostNeed;
	}

	public int getProjectCostCollected() {
		return this.projectCostsCollected;
	}

	public void setProjectCostCollected(int price) {
		projectCostsCollected += price;
	}

}
