package ua.com.goit.gojava.kickstarter.model;

import java.util.ArrayList;

public class ProjectsRepository implements Repository {

	private ArrayList<Project> projects;

	public ProjectsRepository() {
		projects = new ArrayList<>();
		add(new Project(
				"SNAP",
				"Design Your Own Furniture",
				15000,
				27000,
				30,
				"With SNAP you can create endless solutions for your living space. You can "
						+ "transform any surface into a unique piece of furniture.",
				"http://www.youtube.com/01",
				"How do I choose the color combination?", Category.DESIGN, 1));
		add(new Project("HYDAWAY",
				"A Pocket-Sized Water Bottle Fit for any Adventure", 20000,
				181437, 3,
				"HYDAWAY is a handy alternative to disposable plastic water bottles - it folds"
						+ "down easily to fit in almost any pocket!",
				"http://www.youtube.com/0143534",
				"How much is the bottle weight", Category.DESIGN, 2));
		add(new Project(
				"DASH 4.0 WALLET",
				"A Minimal Wallet Redefined",
				5000,
				46848,
				52,
				"The ORIGINAL quickdraw wallet for minimalists. Carry the things you need, and "
						+ "access them easily.",
				"http://www.youtube.com/0143534",
				"What are the dimensions of the wallet?",
				Category.DESIGN, 3));
		add(new Project(
				"USB CHARGEDOUBLER",
				"Double your charging speed!",
				2750,
				2140,
				32,
				"THE ORIGINAL Up to 200% charging speed for iPhone & Android. No data theft. "
						+ "The magnetic usb cable for your keyring.",
				"http://www.youtube.com/0143534", "Have a question?",
				Category.DESIGN, 4));

		add(new Project(
				"FIREFLY HAND",
				"Light up your life",
				3500,
				470,
				25,
				"FireFly Hand is the next generation electric "
						+ "flashlight, which is capable of making your life significantly easier.​",
				"http://www.youtube.com/0143534", "Have a question?",
				Category.TECHNOLOGY, 1));
		add(new Project(
				"CUBIT",
				"The Make Anything Platform",
				50000,
				169,
				34,
				"A platform that brings together plug & play hardware and drag & drop software "
						+ "to allow everyone to create and invent!",
				"http://www.youtube.com/0143534", "Have a question?",
				Category.TECHNOLOGY, 2));
		add(new Project(
				"NOKI",
				"The smart doorlock for Europe",
				125000,
				119082,
				44,
				"Noki is the first smart doorlock for Europe. It opens your door when you come "
						+ "home and locks it when you leave.",
				"http://www.youtube.com/031234", "Have a question?",
				Category.TECHNOLOGY, 3));
	}

	public void add(Project project) {
		projects.add(project);
	}
	
	public ArrayList<Project> getProjectsOfCategoryArray(Category category) {
		ArrayList<Project> result = new ArrayList<>();
		for (Project project : projects){
			if (project.getCategory().equals(category)){
				result.add(project);
			}
		}
		return result;
	}
	
	public int getProjectsRepositorySize() {
	    return projects.size();
	}

	public boolean isCurrentProjectExist(int projectId, Category category) {
		for (Project project : projects){
			if ((project.getId() == projectId) && (project.getCategory().equals(category))){
				return true;
			};
		}
		return false;
	}

	public Project getProjectByIdAndCategory(int projectId, Category category) {
		for (Project project : projects){
			if ((project.getId() == projectId) && (project.getCategory().equals(category))){
				return project;
			};
		}
		return null;
	}

}
