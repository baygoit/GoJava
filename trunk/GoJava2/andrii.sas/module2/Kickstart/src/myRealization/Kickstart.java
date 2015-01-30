package myRealization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kickstart {
	private List<Project> projects = new ArrayList<>();
	private List<Project> categoryProjects = new ArrayList<>();
	private int j = 0;
	private int choice;
	private int projectChoice;
	private Output output;
	private Input input;
	private Categories categories;
	

	public Kickstart(Output output, Input input, Categories categories) {
		this.output = output;
		this.input = input;
		this.categories = categories;
	}

	public void showList() {
		output.println(categories.getCategories() + "\nWhat are you interested in? Pleace, make your choice:");
	}

	public void showChoice() {
		choice = input.readChoice() - 1;
		output.println("You chose - " + categories.readCategory(choice).getName());
	}

	public String writeProject(Project project) {
		return " Name - " + project.getProjectName() + ", Description - "
				+ project.getDescription() + ", Money we need - "
				+ project.getMoneyNeed() + ", Money we have - "
				+ project.getMoneyHas() + ", Days left - "
				+ project.getDaysLeft();
	}

	public void addProject(Project project) {
		projects.add(project);
	}

	public void showProjects() {
		for (Project project : projects) {
			if (project.getCategory() == categories.readCategory(choice)) {
				categoryProjects.add(project);
				categoryProjects.set(0, project);
				j++;
				output.println(j + writeProject(project));
			}
		}
		output.println("If you want to return press \"0\"");
	}

	public void showChosenProject(int choice) {
		projectChoice = choice - 1;
		output.println("You chose:"
				+ writeProject(categoryProjects.get(projectChoice)));
	}

	public void buildMenu(){
		boolean firstTime = true;
		while (true){
			if (firstTime){
			showList();
			showChoice();
			showProjects();
			firstTime = false;
			} else {
				int k = input.readChoice();
				if (k != 0){
				showChosenProject(k);
					output.println("If you want to return press \"0\"");
					if (input.readChoice() == 0){
						j = 0;
						showProjects();
					}
				} else {
					j = 0;
					showList();
					showChoice();
					showProjects();
				}
			}
		}
	}

	public static void main(String[] args) {
		Categories cat = new Categories();
		Kickstart kick = new Kickstart(new ConsoleOutput(), new ConsoleInput(), cat);
		Quote quote = new QuoteGenerator(new ConsoleOutput(), new Random());
		Category sport = new Category("Sport");
		Category science = new Category("Science");
		Category music = new Category("Music");
		Project pro = new Project(music);
		Project pro1 = new Project(sport);
		Project pro2 = new Project(science);
		Project proj1 = new Project(sport);
		Project proj12 = new Project(sport);
		kick.addProject(pro);
		kick.addProject(pro1);
		kick.addProject(pro2);
		kick.addProject(proj1);
		kick.addProject(proj12);
		quote.printQuote();
		cat.addCategory(sport);
		cat.addCategory(science);
		cat.addCategory(music);
		pro.setProject("Band", "We want to create new music band", 15000,
				12540, 35, "bla-bla-bla", "youtube.com",
				"Q: Have you invested your money? A: yes");
		pro1.setProject("Swiming team", "We need sponsor", 5000, 540, 65,
				"bla-bla-bla", "youtube.com",
				"Q: Have you invested your money? A: yes");
		proj1.setProject("Baseball team", "We need sponsor", 1420, 450, 72,
				"bla-bla-bla", "youtube.com",
				"Q: Have you invested your money? A: yes");
		proj12.setProject("Swiming team", "We need sponsor", 5000, 540, 65,
				"bla-bla-bla", "youtube.com",
				"Q: Have you invested your money? A: yes");
		pro2.setProject("Space Warning", "Discover the univerce", 156540,
				125140, 42, "bla-bla-bla", "youtube.com",
				"Q: Have you invested your money? A: yes");
		kick.buildMenu();

	}
}
