package ua.com.goit.gojava7.kickstarter.DAO;


import java.util.List;

import ua.com.goit.gojava7.kickstarter.model.Project;

public abstract class AbstractProjectStorage implements Storage<Project> {

	public abstract Project getProjectById(int projectId);

	public abstract List<Project> getProjectsFromSelectedCategory(int idCategory);
}
