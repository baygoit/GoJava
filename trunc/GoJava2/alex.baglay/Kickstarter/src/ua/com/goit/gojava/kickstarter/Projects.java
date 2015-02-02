
package ua.com.goit.gojava.kickstarter;

public class Projects {

	private Project[] projects = new Project[100];
	private int count = 0;
	
	// потестили
	public void add(Project project) {
		projects[count] = project;
		count++;
	}

	// потестили
	public Project[] getProjects(Category category) {
		Project[] result = new Project[100]; // TODO чето тут такое оно какое-то все страшное :) подумать над этим
		int found = 0;
		for (int index = 0; index < count; index ++) {
			Project project = projects[index];
			if (project.getCategory().equals(category)) {
				result[found] = project;
				found++;
			}
		}
		Project[] result2 = new Project[found];
		System.arraycopy(result, 0, result2, 0, found);
		return result2;
	}

	// остался этот
	public Project get(int index) {
		return projects[index];   
	}

}
