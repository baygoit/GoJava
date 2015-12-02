package ua.com.goit.gojava7.kickstarter.dao.storage;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.User;

public interface ProjectStorage extends Storage<Project>{

	public Project getByNumber(int number);

	public void updatePledged(Project project, int amount);

	public int getPledged(String projectName);

	public List<Project> getByCategory(String categoryName);

	public void userContributeToProject(User user, Double valueOf,String projectName);

	public void addProject(Project project);

}
