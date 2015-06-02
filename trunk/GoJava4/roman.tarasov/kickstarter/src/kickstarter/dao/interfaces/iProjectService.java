package kickstarter.dao.interfaces;

import kickstarter.entity.Project;

public interface iProjectService {

	Project getProjectByIndex(int index);

	int getProjectsLength();

	Project getProjectById(int intSelectedProject);

}
