package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.ArrayList;

public class Project{
	
	private int IdProject;
	private int IdCategory;
	private String nameProject;
	private String shortDescriptionProject;
	private String fullDescriptioProjectn;
	private String fotoProject;
	private String linkProject;
	private int howMuchNeededProjectProject;
	private int howMuchCollectedProject;
	private int howMuchRemainingProject;
	private ArrayList<String> faqProject;
	private int daysLeftProject;

	public Project(int IdProject, int IdCategory, String nameProject, String shortDescriptionProject,
			String fullDescriptioProjectn, String fotoProject, String linkProject,
			int howMuchNeededProjectProject, int howMuchCollectedProject, int howMuchRemainingProject,
			ArrayList<String> faqProject, int daysLeftProject) {
		this.IdProject = IdProject;
		this.IdCategory = IdCategory;
		this.nameProject = nameProject;
		this.shortDescriptionProject = shortDescriptionProject;
		this.fullDescriptioProjectn = fullDescriptioProjectn;
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
				fullDescriptioProjectn,
				fotoProject,
				linkProject,
				howMuchNeededProjectProject,
				howMuchCollectedProject,
				howMuchRemainingProject,
				faqProject,
				daysLeftProject);
	}

	public int getProjectID() {
		return IdProject;
	}
	
	public void setProjectID(int projectID) {
		this.IdProject = projectID;
	}
	
	public String getProjectName() {
		return nameProject;
	}

	public void setProjectName(String projectName) {
		this.nameProject = projectName;
	}
	
	public String getShortDescription() {
		return shortDescriptionProject;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescriptionProject = shortDescription;
	}

	public String getFullDescription() {
		return fullDescriptioProjectn;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescriptioProjectn = fullDescription;
	}

	public String getFoto() {
		return fotoProject;
	}

	public void setFoto(String foto) {
		this.fotoProject = foto;
	}

	public String getLink() {
		return linkProject;
	}

	public void setLink(String link) {
		this.linkProject = link;
	}	
	
	public int getHowMuchNeeded() {
		return howMuchNeededProjectProject;
	}

	public void setHowMuchNeeded(int howMuchNeeded) {
		this.howMuchNeededProjectProject = howMuchNeeded;
	}
	
	public int getHowMuchCollected() {
		return howMuchCollectedProject;
	}

	public void setHowMuchCollected(int howMuchCollected) {
		this.howMuchCollectedProject = howMuchCollected;
	}

	public int getHowMuchRemaining() {
		return howMuchRemainingProject;
	}

	public void setHowMuchRemaining(int howMuchRemaining) {
		this.howMuchRemainingProject = howMuchRemaining;
	}

	public ArrayList<String> getFaq() {
		return faqProject;
	}
	
	public void setFaq(ArrayList<String> question) {
		this.faqProject = question;
	}

	public void addFaq(String question) {
		this.faqProject.add(question);
	}

	public int getDaysLeft() {
		return daysLeftProject;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeftProject = daysLeft;
	}

	public int getCategoryID() {
		return IdCategory;
	}

	public void setCategoryID(int categoryID) {
		this.IdCategory = categoryID;
	}
}
