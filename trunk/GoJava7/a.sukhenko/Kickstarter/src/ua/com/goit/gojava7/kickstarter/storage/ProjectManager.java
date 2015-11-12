package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import ua.com.goit.gojava7.kickstarter.Kickstarter;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.User;

public class ProjectManager {
	public ProjectManager() {
	}

	private Kickstarter kickstarter;

	public ProjectManager(Kickstarter kickStarter) {
		this.setKickstarter(kickStarter);
	}

	private ArrayList<Project> projects = new ArrayList<Project>();

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
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

	public void showCategoryInfo(User guest) {
		getProjectsByCategory(guest.getSettings().getCategory()).forEach(project -> {
			kickstarter.getBody().generateProjectInfo(project);
		});

	}
	
	public Project getProjectById(int id) {
		return getProjects().get(id);
	}
	
	
	
	public Kickstarter getKickstarter() {
		return kickstarter;
	}

	public void setKickstarter(Kickstarter kickstarter) {
		this.kickstarter = kickstarter;
	}

	public Project getProjectByName(String name) {
		for (int i = 0; i < projects.size(); i++) {
			if (projects.get(i).getProjectName().equals(name)) {
				return projects.get(i);
			}
		}
		throw new NoSuchElementException();
	}

}
