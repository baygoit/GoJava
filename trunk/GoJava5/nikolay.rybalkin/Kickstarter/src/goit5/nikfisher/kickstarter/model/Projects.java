package goit5.nikfisher.kickstarter.model;

import java.util.HashMap;
import java.util.Map;

public class Projects {

	private int index = 0;

	private Map<Integer,Project> projects = new HashMap<>();

	public void add(Project project) {
		projects.put(index++, project);
	}

	public Project[] getProgects(Category category){

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

	public Project get(int index) {
		return projects.get(index);
	}


}
