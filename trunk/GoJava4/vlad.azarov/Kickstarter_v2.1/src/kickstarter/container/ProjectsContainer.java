package kickstarter.container;

import java.util.ArrayList;

import kickstarter.model.Project;

public class ProjectsContainer extends EntityContainer<Project> {

	public ProjectsContainer() {
		data = new ArrayList<Project>();
	}
}
