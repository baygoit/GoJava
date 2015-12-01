package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.User;

@XmlRootElement(name = "projects")
public class ProjectManager {
	private ArrayList<Project> projects = new ArrayList<Project>();

	public ProjectManager() {
	}

	public Project getProjectById(int id) {
		return getProjects().get(id);
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	@XmlElement(name = "project")
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public Project getProjectByName(String name) {
		for (int i = 0; i < projects.size(); i++) {
			if (projects.get(i).getProjectName().equals(name)) {
				return projects.get(i);
			}
		}
		throw new NoSuchElementException();
	}

	public synchronized void addProject(Project project) {
		projects.add(project);
	}

	public ArrayList<Project> getProjectsByCategory(Category cat) {
		ArrayList<Project> projectsByCategory = new ArrayList<>();
		for (Project project : projects) {
			if (project.getProjectCategory().getCategoryId() == cat.getCategoryId())
				projectsByCategory.add(project);
		}
		return projectsByCategory;
	}

	public boolean userContributeToProject(User payer, Double amount) {
		boolean operationSuccess = false;
		payer.getSettings().getSelectedProject().addBacker(payer, amount);
		operationSuccess = true;
		return operationSuccess;
	}

	public Project newProject() {
		Project p = new Project();
		projects.add(p);
		return p;
	}

}
