package ua.com.goit.gojava7.kickstarter.DAO.memoryStorages;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractProjectStorage;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class ProjectStorage extends AbstractProjectStorage{
	private static int idGenerator;
	private List<Project> projects;

	public ProjectStorage() {
		idGenerator = 0;
		this.projects = new ArrayList<>();
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	@Override
	public int getIdOfProject(int projectNumber) {
		return projects.get(projectNumber).getIdProject();
	}

	@Override
	public Project getProjectById(int projectId) {
		for (Project project : projects) {
			if (project.getIdProject() == projectId) {
				return project;
			}
		}
		return null;
	}

	@Override
	public List<Project> getProjectsFromSelectedCategory(int idCategory) {
		List<Project> projectsInCategory = new ArrayList<>();
		for (Project project : projects) {
			if (project.getIdParentCategory() == idCategory) {
				projectsInCategory.add(project);
			}
		}
		return projectsInCategory;
	}

	@Override
	public List<Project> getAll() {
		return projects;
	}

	@Override
	public void add(Project project) {
		project.setIdProject(++idGenerator);
		this.projects.add(project);
		
	}

}
