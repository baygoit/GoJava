package org.goJava2.kickstarter.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GeneralStorage {
	
	private HashMap<Category, List<Project>> map;
	private List<Project> projectsArt;
	private List<Project> projectsComics;
	private List<Project> projectsDance;
	private List<Project> projectsGames;
	
	public GeneralStorage() {
		initProjects();
		map = new HashMap<Category, List<Project>>();
		map.put(new Category("Art"), projectsArt);
		map.put(new Category("Comics"), projectsComics);
		map.put(new Category("Dance"), projectsDance);
		map.put(new Category("Games"), projectsGames);
	}
	
	private void initProjects() {
		projectsArt = new ArrayList<Project>();
		projectsComics = new ArrayList<Project>();
		projectsDance = new ArrayList<Project>();
		projectsGames = new ArrayList<Project>();
		
		projectsArt.add(new Project("NY artists", "Some description.", 10000, 200, 25));
		projectsArt.add(new Project("The observatory", "Little observatory/", 2000, 100, 17));
		projectsArt.add(new Project("The sing for hope pianos", "The pianos who play in the streat.", 15000, 5000, 30));
		
		projectsComics.add(new Project("Super Man", "Comic about a man having super powers.", 50000, 1000, 15));
		projectsComics.add(new Project("Hulk", "Comics on the green hero named Hulk.", 20000, 100, 50));
		projectsComics.add(new Project("Spider man", "Little - little spider man.", 4000, 200, 40));
		
		projectsDance.add(new Project("Dance & Fly", "You can dance, you can fly, we belive in you!", 5000, 1000, 15));
		
		projectsGames.add(new Project("Tiny Epic Galaxies", "Develop your empire and colonize planets to create the most powerful galaxy!", 100000, 30000, 50));
		projectsGames.add(new Project("Shadowrun: Hong Kong", "A Shadowrun cyberpunk cRPG set in 2056's Magically Awakened Hong Kong by the developers of Shadowrun Returns & Dragonfall.", 30000, 2000, 33));
		projectsGames.add(new Project("Starr Mazer", "A retro-sexy Point-and-Click Adventure Shoot 'em Up in SPACE!", 50000, 3000, 20));
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