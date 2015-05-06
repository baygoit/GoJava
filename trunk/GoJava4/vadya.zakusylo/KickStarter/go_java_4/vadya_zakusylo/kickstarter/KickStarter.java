package go_java_4.vadya_zakusylo.kickstarter;

import java.util.Scanner;

public class KickStarter {
	static Repository repository = new Repository();
	static Category category;
	static Project project;

	public static void main(String[] args) {
		initContent();
		KickStarter kickStarter = new KickStarter();
		kickStarter.go();
	}

	private static void initContent() {
		category = new Category("Snowboarding");
		repository.addCategory(category);
		Project project = new Project("GNU Dirty Pillow BTX Snowboard", "Snowboard is a befuddling"
				+ "mutant hybrid child of a pow board and it's forbidden love affair with a park"
				+ "board", 400.00, 0, 30, "history", "https://www.youtube.com/watch?v=b2v2Z4AC58E");
		category.addProject(project);
		project = new Project("I/OS Replacement Lenses", "Photochromic Red Sensor Lens", 140, 0,
				90, "history", "https://www.youtube.com/watch?v=rvWwBoIyS-M");
		category.addProject(project);
		category = new Category("Traveling");
		repository.addCategory(category);
		project = new Project("Primus Litech Superset", " The set consists of two pots, a lid, and"
				+ "a separate pot gripper", 50, 0, 30, "history",
				"https://www.youtube.com/watch?v=rV055FvDF8s");
		category.addProject(project);
		project = new Project("Tent VEIG PRO III", "Double entrance expedition tent adapted for"
				+ "using in difficult weather conditions", 270, 0, 90, "history",
				"https://www.youtube.com/watch?v=3zt7RftZPz4");
		category.addProject(project);
		category = new Category("Learning");
		repository.addCategory(category);
		project = new Project("Java: The Complete Reference (Complete Reference Series)",
				"Book by Herbert Schildt", 50, 0, 30, "history", "");
		category.addProject(project);
	}

	private void go() {
		printQuote();
		showCategory();
		setCategory();
		showProject();
		setProject();
	}

	private void printQuote() {
		Quote quote = new CreativeQuote();
		System.out.println(quote.chooseQuote());
	}

	private void showCategory() {
		Category[] categories = repository.getCategories();
		System.out.println("\nChoose the category:");
		for (int index = 0; index < categories.length; index++) {
			System.out.print(index + 1 + ". ");
			category = categories[index];
			System.out.println(category.getNameCategory());
		}
	}

	private void showProject() {
		Project[] projects = category.getProjects();
		System.out.println("\nChoose the project:");
		for (int index = 0; index < projects.length; index++) {
			System.out.print(index + 1 + ". ");
			project = projects[index];
			System.out.println(project.getName() + "\n\t" + project.getShortDescription()
					+ "\n\tNeed money: " + project.getNeedMoney() + "\tCurrent money: "
					+ project.getCurrentMoney() + "\n\tDays left: " + project.getDaysLeft());
		}
	}

	private void setCategory() {
		Category[] categories = repository.getCategories();
		int index = inputIndex(categories);
		category = categories[index - 1];
		System.out.println("You chose " + category.getNameCategory());
	}

	private void setProject() {
		Project[] projects = category.getProjects();
		int index = inputIndex(projects);
		project = projects[index - 1];
		System.out.println("You chose " + project.getName());
	}

	private int inputIndex(Object[] contents) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int index = scanner.nextInt();
		while (index < 1 || index > contents.length) {
			System.out.println("Choose one of the variants!");
			index = scanner.nextInt();
		}
		return index;
	}
}
