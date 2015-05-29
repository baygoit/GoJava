package kickstarter.repository.facade.entityRepositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import kickstarter.repository.facade.entity.Project;

public class ProjectsRepository implements Serializable {

	private static final long serialVersionUID = 8921390807973854822L;

	ArrayList<Project> projects;

	public List<Project> getProjects() {

		return projects;
	}

	public void setProjects(List<Project> projectsToCopy) {

		projects = new ArrayList<Project>();
		for (Project project : projectsToCopy) {
			projects.add(project);
		}
	}

}