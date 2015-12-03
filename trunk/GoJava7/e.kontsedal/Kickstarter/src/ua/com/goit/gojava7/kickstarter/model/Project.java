package ua.com.goit.gojava7.kickstarter.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Project {
	private String projectName;
	private String projectShortDescription;
	private String projectDescription;
	private String videoUrl;
	private int projectCostNeed;
	private Calendar deadline;
	private int idProject;
	private int idParentCategory;

	public Project() {
		this.projectName = "";
		this.projectShortDescription = "";
		this.projectDescription = "";
		this.videoUrl = "";
		this.projectCostNeed = 0;
		this.deadline = new GregorianCalendar();
	} 
	
	public String getProjectName() {
		return this.projectName;
	}

	public String getProjectShortDescription() {
		return this.projectShortDescription;
	}

	public int getProjectDaysLeft() {
		Calendar today = new GregorianCalendar();
		return (int) ((deadline.getTimeInMillis() - today.getTimeInMillis()) / 1000 / 60 / 60 / 24);// OLEG
	}

	public int getProjectCostNeed() {
		return this.projectCostNeed;
	}

	public Calendar getDeadline() {
		return this.deadline;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public String getProjectDescription() {
		return this.projectDescription;
	}

	public int getIdProject() {
		return idProject;
	}

	public int getIdParentCategory() {
		return idParentCategory;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public void setVideoUrl(String url) {
		this.videoUrl = url;
	}

	public void setProjectDescription(String description) {
		this.projectDescription = description;
	}

	public void setDeadline(int projectDaysNeed) {
		this.deadline.add(Calendar.DAY_OF_YEAR, projectDaysNeed);
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectShortDescription(String projectShortDescription) {
		this.projectShortDescription = projectShortDescription;
	}

	public void setProjectCostNeed(int projectCostNeed) {
		this.projectCostNeed = projectCostNeed;
	}

	public void setIdParentCategory(int idParentCategory) {
		this.idParentCategory = idParentCategory;
	}
}
