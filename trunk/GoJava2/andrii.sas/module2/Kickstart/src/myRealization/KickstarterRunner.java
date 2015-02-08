package myRealization;

import java.util.Random;

public class KickstarterRunner {
	
	public static void main(String[] args) {
		Categories cat = new Categories();
		Projects projects = new Projects();
		Quote quote = new QuoteGenerator(new Random());
		Kickstart kick = new Kickstart(new ConsoleOutput(), new ConsoleInput(), cat, projects, quote);
		Category sport = new Category("Sport");
		Category science = new Category("Science");
		Category music = new Category("Music");
		Project musicBand = new Project(music);
		Project swimingTeam = new Project(sport);
		Project spaceDiscovery = new Project(science);
		Project baseballTEam = new Project(sport);
		Project strongman = new Project(sport);
		projects.addProject(musicBand);
		projects.addProject(swimingTeam);
		projects.addProject(spaceDiscovery);
		projects.addProject(baseballTEam);
		projects.addProject(strongman);
		cat.addCategory(sport);
		cat.addCategory(science);
		cat.addCategory(music);
		musicBand.setProject("Band", "We want to create new music band", 15000,
				12540, 35, "bla-bla-bla", "youtube.com",
				"Q: Have you invested your money? A: yes");
		swimingTeam.setProject("Swiming team", "We need sponsor", 5000, 540, 65,
				"bla-bla-bla", "youtube.com",
				"Q: Have you invested your money? A: yes");
		baseballTEam.setProject("Baseball team", "We need sponsor", 1420, 450, 72,
				"bla-bla-bla", "youtube.com",
				"Q: Have you invested your money? A: yes");
		strongman.setProject("Strong man competitions", "We need money to hold our region competitions", 1000, 540, 15,
				"bla-bla-bla", "youtube.com",
				"Q: Have you invested your money? A: yes");
		spaceDiscovery.setProject("Space Warning", "Discover the univerce", 156540,
				125140, 42, "bla-bla-bla", "youtube.com",
				"Q: Have you invested your money? A: yes");
		kick.buildMenu();
	}
}