package org.goJava2.kickstarter.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.goJava2.kickstarter.behavior.StorageBehavior;
import org.goJava2.kickstarter.content.Category;
import org.goJava2.kickstarter.content.Project;

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
	public ProjectStorage(StorageBehavior<Integer> storage) {
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
		putProjectsToMap(storage);
	}
	
	private void putProjectsToMap(StorageBehavior<Integer> storage) {
		map = new HashMap<Category, List<Project>>();
		map.put((Category) storage.getSpecificContent(0), projectsArt);
		map.put((Category) storage.getSpecificContent(1), projectsComics);
		map.put((Category) storage.getSpecificContent(2), projectsDance);
		map.put((Category) storage.getSpecificContent(3), projectsGames);	
	}
	
	@Override
	public Map<Category, List<Project>> getContent() {
		return map;
	}
	
	@Override
	public List<Project> getSpecificContent(Category category) {
		return map.get(category);
	}
	
	@Override
	public void addContent(Object o) {
		// TODO	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result
				+ ((projectsArt == null) ? 0 : projectsArt.hashCode());
		result = prime * result
				+ ((projectsComics == null) ? 0 : projectsComics.hashCode());
		result = prime * result
				+ ((projectsDance == null) ? 0 : projectsDance.hashCode());
		result = prime * result
				+ ((projectsGames == null) ? 0 : projectsGames.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectStorage other = (ProjectStorage) obj;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (projectsArt == null) {
			if (other.projectsArt != null)
				return false;
		} else if (!projectsArt.equals(other.projectsArt))
			return false;
		if (projectsComics == null) {
			if (other.projectsComics != null)
				return false;
		} else if (!projectsComics.equals(other.projectsComics))
			return false;
		if (projectsDance == null) {
			if (other.projectsDance != null)
				return false;
		} else if (!projectsDance.equals(other.projectsDance))
			return false;
		if (projectsGames == null) {
			if (other.projectsGames != null)
				return false;
		} else if (!projectsGames.equals(other.projectsGames))
			return false;
		return true;
	}
}