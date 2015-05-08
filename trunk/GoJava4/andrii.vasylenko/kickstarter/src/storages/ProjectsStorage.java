package storages;

import kickstarter.data_types.Category;
import kickstarter.data_types.Project;

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

	public ProjectsStorage getProjectsInCategory(Category category) {
		ProjectsStorage result = new ProjectsStorage();

		for (int i = 0; i < size(); i++) {
			if (get(i).getCategory() == category) {
				result.add(get(i));
			}
		}

		return result;
	}

}
