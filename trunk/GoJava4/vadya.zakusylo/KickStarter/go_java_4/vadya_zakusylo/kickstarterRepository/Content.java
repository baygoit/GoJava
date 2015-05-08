package go_java_4.vadya_zakusylo.kickstarterRepository;

public class Content {
	public static ArrayCategory arrayCategory = new ArrayCategory();
	public static Category category;
	public static Project project;

	public void initContent() {
		category = new Category("Snowboarding");
		arrayCategory.addCategory(category);
		project = new Project("GNU Dirty Pillow BTX Snowboard", "Snowboard is a befuddling"
				+ "mutant hybrid child of a pow board and it's forbidden love affair with a park"
				+ "board", 400.00, 0, 30, "history", "https://www.youtube.com/watch?v=b2v2Z4AC58E");
		category.addProject(project);
		project = new Project("I/OS Replacement Lenses", "Photochromic Red Sensor Lens", 140, 0,
				90, "history", "https://www.youtube.com/watch?v=rvWwBoIyS-M");
		category.addProject(project);
		category = new Category("Traveling");
		arrayCategory.addCategory(category);
		project = new Project("Primus Litech Superset", " The set consists of two pots, a lid, and"
				+ "a separate pot gripper", 50, 0, 30, "history",
				"https://www.youtube.com/watch?v=rV055FvDF8s");
		category.addProject(project);
		project = new Project("Tent VEIG PRO III", "Double entrance expedition tent adapted for"
				+ "using in difficult weather conditions", 270, 0, 90, "history",
				"https://www.youtube.com/watch?v=3zt7RftZPz4");
		category.addProject(project);
		category = new Category("Learning");
		arrayCategory.addCategory(category);
		project = new Project("Java: The Complete Reference (Complete Reference Series)",
				"Book by Herbert Schildt", 50, 0, 30, "history", "");
		category.addProject(project);
	}
}
