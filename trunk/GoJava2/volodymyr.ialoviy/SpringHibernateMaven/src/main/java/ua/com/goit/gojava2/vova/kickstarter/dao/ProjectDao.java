package ua.com.goit.gojava2.vova.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava2.vova.kickstarter.model.Project;

public interface ProjectDao {

	List<Project> findAllProjects(int id);

	void saveProject(Project project);

	void deleteProjectById(int id);

	Project getProgect(int id);

	void addDonate(int amount, int id);

}
