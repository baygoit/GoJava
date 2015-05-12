package kickstarter.Repository;

import kickstarter.UserInterface;
import kickstarter.Entities.Category;
import kickstarter.Entities.Project;

public class ProjectList {
	Project[] projects = new Project[10];
	int[] deleted = new int[10];
	int pointer = 0;
	public Category targetCategory;
	Project targetProject;

	public void addProject(Project projectToList) {
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

	public Project[] printList(UserInterface ui) {
		if (pointer == 0) {
			ui.display("ProjectList null");
			return null;
		}

		Project[] projectsByCategory = new Project[pointer];
		int newPointer=0;
		for (int index = 0; index < pointer; index++) {
			if (projects[index].category.id == targetCategory.id) {
				ui.display(projects[index].id + "- " + projects[index].name);
				projectsByCategory[newPointer] = projects[index];
				newPointer++;
			}
		}
		Project[] sortedProjects=new Project[newPointer];
		System.arraycopy(projectsByCategory, 0, sortedProjects, 0, newPointer);
		
		return sortedProjects;
	}

	void setTargetCategory(Category target) {
		this.targetCategory = target;
	}

	public Project get(int pointer) {
		return projects[pointer];
	}

	public void setTargetProject(Project projectToDetailedView) {
		this.targetProject=projectToDetailedView;
		
	}
}
