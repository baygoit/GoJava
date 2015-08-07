package belskii.artem.kickstarter.dao.project;

import java.util.Map;

public interface ProjectDao {
	public void addProject(Project projectDetails);
	public Map<Long, Project> getProjectList();
	public Project getProjectDetails(int id);
	public Map<Long, Project> getProjectFromCategory(int id);
}
