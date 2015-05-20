package kickstarter.storages.relations;

import java.util.HashMap;
import java.util.Map;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.storages.ProjectsStorage;
import kickstarter.storages.Storage;

public class ProjectsInCategory implements Relations<Project, Category> {
	private Map<Category, Storage<Project>> relations = new HashMap<Category, Storage<Project>>();

	@Override
	public void add(Project project, Category category) {
		checkContainsKey(category);

		Storage<Project> storage = relations.get(category);
		storage.add(project);
	}

	@Override
	public Storage<Project> getProjects(Category category) {
		checkContainsKey(category);

		return relations.get(category);
	}

	private void checkContainsKey(Category category) {
		if (!relations.containsKey(category)) {
			relations.put(category, new ProjectsStorage());
		}
	}
}
