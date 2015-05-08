package kickstarter;

public class ProjectList {
	Project[] projects = new Project[10];
	int[] deleted = new int[10];
	int pointer = 0;
	Category targetCategory;

	void addProject(Project projectToList) {
		if (pointer >= projects.length) {
			Project[] newProjects = new Project[projects.length + 10];
			System.arraycopy(projects, 0, newProjects, 0, projects.length);
			projects = newProjects;

			int[] newDeleted = new int[projects.length + 10];
			System.arraycopy(deleted, 0, newDeleted, 0, projects.length);
			deleted = newDeleted;

			projects[pointer] = projectToList;
		}

		projects[pointer] = projectToList;
		pointer++;
	}

	void deleteProject(Project projectToBeDeleted) {
		// TODO
	}

	int[] printList(UserInterface ui) {
		if (pointer == 0) {
			ui.display("ProjectList null");
			return null;
		}


		int[] options = new int [pointer];
		for (int index = 0; index < pointer; index++) {
			ui.display(projects[index].id + "- " + projects[index].name);
			options[index]=projects[index].id;
		}
		return options;
	}

	void setTargetCategory(Category target) {
		this.targetCategory = target;
	}

	public Project get(int pointer) {
		return projects[pointer];
	}
}
