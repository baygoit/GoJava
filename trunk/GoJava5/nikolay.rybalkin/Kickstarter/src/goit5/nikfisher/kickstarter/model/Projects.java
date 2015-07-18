package goit5.nikfisher.kickstarter.model;

public class Projects {

	private Project[] projects = new Project[100]; //TODO надо подумать над этим моментом
	private int index = 0;



//	ArrayList<Project> projects = new ArrayList<>();

	public void add(Project project) {
		projects[index++] = project;
	}

	public Project[] getProgects(Category category){

		Project[] result = new Project[100];
		int found = 0;

		for (int i = 0; i < index; i++) {
			Project project = projects[i];

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
		return projects[index];
	}


}
