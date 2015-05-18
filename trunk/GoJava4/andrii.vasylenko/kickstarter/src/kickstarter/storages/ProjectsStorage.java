package kickstarter.storages;

import kickstarter.engine.Project;

public class ProjectsStorage implements Storage<Project> {
	private UniversalStorage<Project> projects = new UniversalStorage<Project>();

	@Override
	public Project get(int index) throws IndexOutOfBoundsException {
		return projects.get(index);
	}

	@Override
	public Project getById(int id) {
		return projects.getById(id);
	}

	@Override
	public void add(Project project) {
		projects.add(project);
	}

	@Override
	public int size() {
		return projects.size();
	}

	@Override
	public boolean empty() {
		return projects.empty();
	}

}
