package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "projects")
public class Project{
	
	@Id
	@Column(name = "idProject")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProject;
	
	@Column(name = "idCategory")
	private int idCategory;

	@Column(name = "nameProject")
	private String nameProject;
	
	@Column(name = "shortDescriptionProject")
	private String shortDescriptionProject;
	
	@Column(name = "fullDescriptionProject")
	private String fullDescriptionProject;
	
	@Column(name = "fotoProject")
	private String fotoProject;
	
	@Column(name = "linkProject")
	private String linkProject;
	
	@Column(name = "howMuchNeededProjectProject")
	private int howMuchNeededProjectProject;
	
	@Column(name = "howMuchCollectedProject")
	private int howMuchCollectedProject;
	
	@Column(name = "howMuchRemainingProject")
	private int howMuchRemainingProject;
	
	private ArrayList<String> faqProject;
	
	@Column(name = "daysLeftProject")
	@Temporal(value=TemporalType.DATE)
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
