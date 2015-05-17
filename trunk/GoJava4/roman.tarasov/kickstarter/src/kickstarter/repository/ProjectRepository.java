package kickstarter.repository;

import kickstarter.entities.Project;

public class ProjectRepository {
	Storage<Project> projects;
	private String[] optionsStrings;
	private int[] optionsInts;

	public ProjectRepository() {
		int categoryID = 5;
		projects = new EntityStorage<Project>();
		Project project = new Project("Create electrobike", categoryID);
		project.description = "high efficiency";
		project.shortDescription = "short description";
		project.history = "history of bike creation";
		project.linkToVideo = "www.link.to.demo.video";
		project.pledged = 25;
		project.goal = 2000;
		project.ID = 23;
		projects.add(project);

		categoryID = 4;

		project = new Project("Paint the fence of the school", categoryID);
		project.description = "raising money for paint";
		project.ID = 8;
		projects.add(project);

	}

	public Project getProjectById(int ID) {
		int length = projects.length();

		for (int index = 0; index < length; index++) {
			Project currentProject = projects.getEntity(index);
			if (currentProject.ID == ID) {
				return currentProject;
			}
		}

		return null;
	}

	public Storage<Project> sortProjectsByCategoryID(int categoryID) {

		Storage<Project> sortedProjects = new EntityStorage<Project>();
		int length = projects.length();
		for (int index = 0; index < length; index++) {
			Project project = projects.getEntity(index);
			if (project.categoryID == categoryID) {
				sortedProjects.add(project);
			}
		}
		return sortedProjects;
	}

	public String printProjectsInfo(int categoryID) {
		String result = "";
		Storage<Project> sortedToSelect = sortProjectsByCategoryID(categoryID);
		int length = sortedToSelect.length();
		optionsStrings = new String[length];

		optionsInts = new int[length];
		for (int index = 0; index < length; index++) {
			Project project = sortedToSelect.getEntity(index);
			optionsStrings[index] = Integer.toString(project.ID);
			optionsInts[index] = project.ID;
			result += ("ID:<" + project.ID + "> name:<" + project.name
					+ "> short desc.:<" + project.shortDescription + "> goal:<"
					+ project.goal + "> pledged:<" + project.pledged
					+ "> days to go:<" + project.daysToGo + ">");

		}
		return result;
	}

	public int[] getAllProjectsByCategoryID(int categoryID) {
		int length = projects.length();
		optionsStrings = new String[length];
		for (int index = 0; index < length; index++) {

			optionsInts[index] = projects.getEntity(index).ID;

		}
		return optionsInts;

	}

	public String[] getStringOptions() {
		return optionsStrings;

	}

	public int[] getIntOptions() {
		return optionsInts;

	}

}
