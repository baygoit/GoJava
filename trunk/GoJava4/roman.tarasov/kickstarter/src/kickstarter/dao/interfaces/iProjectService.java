package kickstarter.dao.interfaces;

import java.util.List;

import kickstarter.entity.Project;

public interface iProjectService {

	Project getProjectByIndex(int index);

	int getProjectsLength();

	Project getProjectById(int intSelectedProject);

	List<Project> getAll();
}
