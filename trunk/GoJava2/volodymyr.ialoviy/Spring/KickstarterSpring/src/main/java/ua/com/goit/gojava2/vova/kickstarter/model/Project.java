package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.ArrayList;

public class Project{
	
	private int idProject;
	private int idCategory;
	private String nameProject;
	private String shortDescriptionProject;
	private String fullDescriptionProject;
	private String fotoProject;
	private String linkProject;
	private int howMuchNeededProjectProject;
	private int howMuchCollectedProject;
	private int howMuchRemainingProject;
	private ArrayList<String> faqProject;
	private int daysLeftProject;

	public Project(int IdProject, int IdCategory, String nameProject, String shortDescriptionProject,
			String fullDescriptionProject, String fotoProject, String linkProject,
			int howMuchNeededProjectProject, int howMuchCollectedProject, int howMuchRemainingProject,
			ArrayList<String> faqProject, int daysLeftProject) {
		this.idProject = IdProject;
		this.idCategory = IdCategory;
		this.nameProject = nameProject;
		this.shortDescriptionProject = shortDescriptionProject;
		this.fullDescriptionProject = fullDescriptionProject;
		this.fotoProject = fotoProject;
		this.linkProject = linkProject;
		this.howMuchNeededProjectProject = howMuchNeededProjectProject;
		this.howMuchCollectedProject = howMuchCollectedProject;
		this.howMuchRemainingProject = howMuchRemainingProject;
		this.faqProject = faqProject;
		this.daysLeftProject = daysLeftProject;
	}
	
	@Override
	public String toString() {
		return String.format("%s \n%s \n%s \n%s \n%s \n%s \n%s \n%s \n%s \n%s",
				nameProject,
				shortDescriptionProject,
				fullDescriptionProject,
				fotoProject,
				linkProject,
				howMuchNeededProjectProject,
				howMuchCollectedProject,
				howMuchRemainingProject,
				faqProject,
				daysLeftProject);
	}

	public int getIdProject() {
		return idProject;
	}
	
	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}
	
	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}
	
	public String getShortDescriptionProject() {
		return shortDescriptionProject;
	}

	public void setShortDescriptionProject(String shortDescriptionProject) {
		this.shortDescriptionProject = shortDescriptionProject;
	}

	public String getFullDescriptionProject() {
		return fullDescriptionProject;
	}

	public void setFullDescriptioProjectn(String fullDescriptioProjectn) {
		this.fullDescriptionProject = fullDescriptioProjectn;
	}

	public String getFotoProject() {
		return fotoProject;
	}

	public void setFotoProject(String fotoProject) {
		this.fotoProject = fotoProject;
	}

	public String getLinkProject() {
		return linkProject;
	}

	public void setLinkProject(String linkProject) {
		this.linkProject = linkProject;
	}	
	
	public int getHowMuchNeededProject() {
		return howMuchNeededProjectProject;
	}

	public void setHowMuchNeededProject(int howMuchNeededProject) {
		this.howMuchNeededProjectProject = howMuchNeededProject;
	}
	
	public int getHowMuchCollectedProject() {
		return howMuchCollectedProject;
	}

	public void setHowMuchCollectedProject(int howMuchCollectedProject) {
		this.howMuchCollectedProject = howMuchCollectedProject;
	}

	public int getHowMuchRemainingProject() {
		return howMuchRemainingProject;
	}

	public void setHowMuchRemainingProject(int howMuchRemainingProject) {
		this.howMuchRemainingProject = howMuchRemainingProject;
	}

	public ArrayList<String> getFaqProject() {
		return faqProject;
	}
	
	public void setFaqProject(ArrayList<String> questionProject) {
		this.faqProject = questionProject;
	}

	public void addFaqProject(String questionProject) {
		this.faqProject.add(questionProject);
	}

	public int getDaysLeftProject() {
		return daysLeftProject;
	}

	public void setDaysLeftProject(int daysLeftProject) {
		this.daysLeftProject = daysLeftProject;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
}
