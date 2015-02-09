package myRealization;

public class Storage {
	private Categories categories;
	private Projects projects;
	private Kickstart kick;
	
	public Storage(Output output, Input input, Quote quote){
		categories = new Categories();
		projects = new Projects();
		kick = new Kickstart(output, input, categories, projects, quote);
	}
	public void initiate(){
		Category sport = new Category("Sport");
		Category science = new Category("Science");
		Category music = new Category("Music");
		categories.addCategory(sport);
		categories.addCategory(science);
		categories.addCategory(music);
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
