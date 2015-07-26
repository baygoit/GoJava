package goit5.nikfisher.kickstarter.dao;

import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProjects implements Projects {

	private int index = 0;

	private Map<Integer,Project> projects = new HashMap<>();

	@Override
	public void add(Project project) {
		projects.put(index++, project);
	}

	@Override
	public Project[] getProjects(Category category){

		Project[] result = new Project[projects.size()];
		int found = 0;

		for (int i = 0; i < index; i++) {
			Project project = projects.get(i);

			if (project.getCategory().equals(category)){
				result[found] = project;
				found++;
			}
		}

		Project[] result2 = new Project[found];
		System.arraycopy(result, 0, result2, 0, found);
		return result2;
	}

	@Override
	public Project get(int index) {
		return projects.get(index);
	}


}
