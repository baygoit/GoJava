package belskii.artem.kickstarter.dao.project;

import java.util.ArrayList;

public interface ProjectDao {
	public void addProject(Project projectDetails);
	public ArrayList<Project> getProjectList();
	public Project getProjectDetails(int id);
}
