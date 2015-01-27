package org.goJava2.kickstarter.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GeneralStorage {
	
	private HashMap<Category, List<Project>> map;
	private List<Project> projectsArt;
	private List<Project> projectsComics;
	private List<Project> projectsDance;
	
	public GeneralStorage() {
		map = new HashMap<Category, List<Project>>();
		initProjects();
		map.put(new Category("Art"), projectsArt);
		map.put(new Category("Comics"), projectsComics);
		map.put(new Category("Dance"), projectsDance);
	}
	
	private void initProjects() {
		projectsArt = new ArrayList<Project>();
		projectsComics = new ArrayList<Project>();
		projectsDance = new ArrayList<Project>();
		
		projectsArt.add(new Project("Paint my live", "Description project", 10000, 200, 25));
		projectsArt.add(new Project("The Observatory", "Description project", 2000, 100, 17));
		projectsArt.add(new Project("The Sing for Hope Pianos", "Description project", 15000, 5000, 30));
		
		projectsComics.add(new Project("Super Man", "Super man comics fantastic", 50000, 1000, 15));
		projectsComics.add(new Project("Hulk", "Comics about super Hulk", 20000, 100, 50));
		projectsComics.add(new Project("Spider man", "Description project", 4000, 200, 40));
		
		projectsDance.add(new Project("Dance with me", "Empty description", 5000, 1000, 15));
	}
	
	public ArrayList<Category> getCategories() {
		ArrayList<Category> categories = new ArrayList<Category>();
		for(Category category: map.keySet()) {
			categories.add(category);
		}
		return categories;
	}
	
	public ArrayList<Project> getSpecificProjects(Category category) {
		ArrayList<Project> projects = (ArrayList<Project>) map.get(category);
		return projects;
	}
}