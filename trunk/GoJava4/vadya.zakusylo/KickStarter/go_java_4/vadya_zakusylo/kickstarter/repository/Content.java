package go_java_4.vadya_zakusylo.kickstarter.repository;

public class Content {
	public ArrayCategory arrayCategory = new ArrayCategory();

	public void initContent() {
		//First category
		Category categoryFirst = new Category("Snowboarding");
		arrayCategory.addCategory(categoryFirst);
		Project projectFirst = new Project("GNU Dirty Pillow BTX Snowboard", "Snowboard is a befuddling"
				+ "mutant hybrid child of a pow board and it's forbidden love affair with a park"
				+ "board", 400.00, 0, 30, "history", "https://www.youtube.com/watch?v=b2v2Z4AC58E");
		categoryFirst.addProject(projectFirst);
		Project projectSecond = new Project("I/OS Replacement Lenses", "Photochromic Red Sensor Lens", 140, 0,
				90, "history", "https://www.youtube.com/watch?v=rvWwBoIyS-M");
		categoryFirst.addProject(projectSecond);

		//Second category
		Category categorySecond = new Category("Traveling");
		arrayCategory.addCategory(categorySecond);
		Project projectThird = new Project("Primus Litech Superset", "The set consists of two pots, a lid, and"
				+ "a separate pot gripper", 50, 0, 30, "history",
				"https://www.youtube.com/watch?v=rV055FvDF8s");
		categorySecond.addProject(projectThird);
		Project projectFourth = new Project("Tent VEIG PRO III", "Double entrance expedition tent adapted for"
				+ "using in difficult weather conditions", 270, 0, 90, "history",
				"https://www.youtube.com/watch?v=3zt7RftZPz4");
		categorySecond.addProject(projectFourth);
		
		//Third category
		Category categoryThird = new Category("Learning");
		arrayCategory.addCategory(categoryThird);
		Project projectFifth = new Project("Java: The Complete Reference (Complete Reference Series)",
				"Book by Herbert Schildt", 50, 0, 30, "history", "");
		categoryThird.addProject(projectFifth);
	}
}
