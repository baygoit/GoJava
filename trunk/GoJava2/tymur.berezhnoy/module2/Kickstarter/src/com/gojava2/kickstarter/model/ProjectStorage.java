package com.gojava2.kickstarter.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gojava2.kickstarter.content.Category;
import com.gojava2.kickstarter.content.Project;
import com.gojava2.kickstarter.controller.CategoryController;

public class ProjectStorage implements Storage<Category> {
	
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
		
		projectsArt.add(new Project("NY artists", "Some description.", 10000, 200, 25, 1,
					"There'll be history", "http://www.nyart.com"));
		projectsArt.add(new Project("The observatory", "Little observatory.", 2000, 100, 17, 1,
					"There'll be history", "http://www.observatory.com"));
		projectsArt.add(new Project("The sing for hope pianos", "The pianos who play in the streat.",
					15000, 5000, 4, 30, "There'll be history", "http://www.pianos.com"));
		projectsComics.add(new Project("Super Man", "Comic about a man having super powers.",
					50000, 1000, 15, 5, "There'll be history", "http://www.superman.com"));
		projectsComics.add(new Project("Hulk", "Comics on the green hero named Hulk.", 
					20000, 100, 50, 2,"There'll be history", "http://www.hulk.com"));
		projectsComics.add(new Project("Spider man", "Little - little spider man.", 4000, 200,
					40, 1,"There'll be history", "http://www.spiderman.com"));
		projectsDance.add(new Project("Dance & Fly", "You can dance, you can fly, we belive in you!",
					5000, 1000, 15, 7, "There'll be history", "http://www.df.com"));
		projectsGames.add(new Project("Tiny Epic Galaxies", "Develop your empire and "
					+ "colonize planets to create the most powerful galaxy!",
					100000, 30000, 50, 17, "There'll be history", "http://www.galaxies.com"));
		projectsGames.add(new Project("Shadowrun: Hong Kong", "A Shadowrun cyberpunk cRPG "
					+ "set in 2056's Magically Awakened Hong Kong by the developers of "
					+ "Shadowrun Returns & Dragonfall.",
					30000, 2000, 33, 10, "There'll be history", "http://www.shadowrun.com"));
		projectsGames.add(new Project("Starr Mazer", "A retro-sexy Point-and-Click Adventure "
					+ "Shoot 'em Up in SPACE!", 50000, 3000, 20, 6, "There'll be history", 
					"http://www.starr mazer.com"));
		putProjectsToMap();
	}
	
	private void putProjectsToMap() {
		map = new HashMap<Category, List<Project>>();
		CategoryController c = new CategoryController();
		map.put(c.getSpecificContent(0), projectsArt);
		map.put(c.getSpecificContent(1), projectsComics);
		map.put(c.getSpecificContent(2), projectsDance);
		map.put(c.getSpecificContent(3), projectsGames);	
	}
	
	@Override
	public Map<Category, List<Project>> getContent() {
		return map;
	}
}