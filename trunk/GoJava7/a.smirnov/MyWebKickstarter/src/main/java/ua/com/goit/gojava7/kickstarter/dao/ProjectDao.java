package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Project;

public interface ProjectDao {

	public void add(Project project);

	public void remove(Project project);

	public List<Project> getProjectsFromCategory(int categoryId);

	public Project getProjectById(int projectId);
}
