package ua.home.kickstarter;

public class Projects {
	private int numberOfProjects = 100;
	private Project[] projects = new Project[numberOfProjects];
	private int count = 0;

	public void add(Project project) {
		projects[count] = project;
		count++;
	}

	public Project[] getProjects(Category category) {
		Project[] result = new Project[count];
		int found = 0;
		for (int index = 0; index < count; index++) {
			Project project = projects[index];
			if (projects[index].getCategory().equals(category)) {
				result[found] = project;
				found++;
			}
		}
		return result;
	}
	public Project[] getFullProject(int projectIndex) {
		Project[] result = new Project[count];
			result[0] = projects[projectIndex-1];
		
		return result;
	}

	public Project getName(int index) {
		return projects[index - 1];
	}


}
