package belskii.artem.kickstarter.dao.project;

import java.util.HashMap;

public interface ProjectDao {
	public void addProject(Project projectDetails);
	public HashMap<Long, Project> getProjectList();
	public Project getProjectDetails(int id);
	public HashMap<Long, Project> getProjectFromCategory(int id);
}
