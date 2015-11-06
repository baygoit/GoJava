package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class ProjectStorage {
	private List<Project> projects = new ArrayList<>();

	{
		projects.add(new Project("Art Cinema", "Movie",
				"We would like to built "
						+ "studio for making art house movies.",
				100000, 10000, 15));
		projects.add(new Project("Horror", "Movie",
				"We would like to create new national horror film.", 10000, 100,
				115));
		projects.add(new Project("Dance School", "Dances",
				"We would like open dance studio for children from poor families.",
				5000, 300, 25));
		projects.add(new Project("Droid", "Tech",
				"We would like to built cheap fly droid that could shot films.",
				100000, 10000, 45));
	}

	public List<String> getAllCategories() {
		List<String> categories = new ArrayList<>();

		for (Project aProject : projects) {
			int index = 0;
			for (int j = 0; j < categories.size(); j++) {
				if ((aProject.getProjectCategory()
						.equalsIgnoreCase(categories.get(j)))) {
					index++;
				}

			}
			if (index == 0) {
				categories.add(aProject.getProjectCategory());
			}
		}
		return categories;
	}

	public List<Project> getCategorizedProjects(String categoryName) {
		List<Project> categorizedProjects = new ArrayList<>();
		for (Project aProject : projects) {
			if ((aProject.getProjectCategory()
					.equalsIgnoreCase(categoryName))) {
				categorizedProjects.add(aProject);
			}

		}
		return categorizedProjects;
	}

	public List<Project> getAllProjects() {
		return projects;
	}
}
