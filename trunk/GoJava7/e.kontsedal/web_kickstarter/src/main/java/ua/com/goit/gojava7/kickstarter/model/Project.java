package ua.com.goit.gojava7.kickstarter.model;

import java.sql.Date;

public class Project {
	private String projectName;
	private String projectShortDescription;
	private String projectDescription;
	private String videoUrl;
	private int projectCostNeed;
	private Date deadline;
	private int idProject;
	private int idParentCategory;

	public Project() {} 
	
	public String getProjectName() {
		return this.projectName;
	}

	public String getProjectShortDescription() {
		return this.projectShortDescription;
	}

	public int getProjectDaysLeft() {
//		Calendar today = new GregorianCalendar();
//		return (int) ((deadline.getTimeInMillis() - today.getTimeInMillis()) / 1000 / 60 / 60 / 24);// OLEG
		long ms = 0;
        if (getDeadline() != null) {
            ms = getDeadline().getTime() - System.currentTimeMillis(); 
        }
        if (ms < 0) {
            return 0;
        }
        return (int) ms / (1000 * 60 * 60 * 24);
	}

	public int getProjectCostNeed() {
		return this.projectCostNeed;
	}

	public Date getDeadline() {
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

//	public void setDeadline(Date deadline) {
//		this.deadline.add(Calendar.DAY_OF_YEAR, projectDaysNeed);
//	}

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
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return "Project name: " + projectName + "; " 
				+ "Project description: " + projectDescription + "; "
				+ "Project short description: " + projectShortDescription + "; "
				+ "Pideo url: " + videoUrl + "; "
				+ "Project cost need: " + projectCostNeed + "; "
				+ "Project deadline: " + deadline + "; "
				+ "ID parent category: " + idParentCategory + "; ";
	}
}
