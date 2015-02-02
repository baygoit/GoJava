package org.goJava2.kickstarter.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.goJava2.kickstarter.behavior.StorageBehavior;
import org.goJava2.kickstarter.content.Category;
import org.goJava2.kickstarter.content.Project;
import org.goJava2.kickstarter.factory.StorageFactory;

public class ProjectStorage implements StorageBehavior<Category> {

	private List<Project> projectsArt;
    private List<Project> projectsComics;
    private List<Project> projectsDance;
    private List<Project> projectsGames;
	
	private Map<Category, List<Project>> map;
	
	/**
	 * The constructor for custom projects.
	 * @param projects
	 * @param map
	 */
	public ProjectStorage(List<Project> projects, Map<Category, List<Project>> map) {
		projectsArt = projects;
		this.map = map;
	}
	
	/**
	 * The constructor for Hard-coded projects.
	 */
	public ProjectStorage() {
		projectsArt = new ArrayList<Project>();
		projectsComics = new ArrayList<Project>();
		projectsDance = new ArrayList<Project>();
		projectsGames = new ArrayList<Project>();
		
		projectsArt.add(new Project("NY artists", "Some description.", 10000, 200, 25));
		projectsArt.add(new Project("The observatory", "Little observatory.", 2000, 100, 17));
		projectsArt.add(new Project("The sing for hope pianos", "The pianos who play in the streat.", 15000, 5000, 30));
		
		projectsComics.add(new Project("Super Man", "Comic about a man having super powers.", 50000, 1000, 15));
		projectsComics.add(new Project("Hulk", "Comics on the green hero named Hulk.", 20000, 100, 50));
		projectsComics.add(new Project("Spider man", "Little - little spider man.", 4000, 200, 40));
		
		projectsDance.add(new Project("Dance & Fly", "You can dance, you can fly, we belive in you!", 5000, 1000, 15));
		
		projectsGames.add(new Project("Tiny Epic Galaxies", "Develop your empire and colonize planets to create the most powerful galaxy!", 100000, 30000, 50));
		projectsGames.add(new Project("Shadowrun: Hong Kong", "A Shadowrun cyberpunk cRPG set in 2056's Magically Awakened Hong Kong by the developers of Shadowrun Returns & Dragonfall.", 30000, 2000, 33));
		projectsGames.add(new Project("Starr Mazer", "A retro-sexy Point-and-Click Adventure Shoot 'em Up in SPACE!", 50000, 3000, 20));
		
		putProjectsToMap();
	}
	
	private void putProjectsToMap() {
		map = new HashMap<Category, List<Project>>();
		map.put(StorageFactory.getCategoryStorage().getSpecificContent(0), projectsArt);
		map.put(StorageFactory.getCategoryStorage().getSpecificContent(1), projectsComics);
		map.put(StorageFactory.getCategoryStorage().getSpecificContent(2), projectsDance);
		map.put(StorageFactory.getCategoryStorage().getSpecificContent(3), projectsGames);	
	}
	
	@Override
	public Map<Category, List<Project>> getContent() {
		return map;
	}
	
	@Override
	public List<Project> getSpecificContent(Category category) {
		return map.get(category);
	}
}