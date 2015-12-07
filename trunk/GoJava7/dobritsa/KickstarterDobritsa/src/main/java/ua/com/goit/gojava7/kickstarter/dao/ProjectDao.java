package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Project;

public interface ProjectDao extends Dao<Project> {

	public Project getByNumber(int number);

	public void updatePledged(Project project, int amount);

	public int getPledged(String projectName);

	public List<Project> getByCategory(String categoryName);
	public List<Project> getByCategory(int categoryId);

}
