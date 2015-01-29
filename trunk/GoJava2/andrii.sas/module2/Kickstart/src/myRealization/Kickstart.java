package myRealization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kickstart {
	private List<Category> categories = new ArrayList<>();
	private List<Project> projects = new ArrayList<>();
	private List<Project> categoryProjects = new ArrayList<>();
	private int i = 1;
	private int j = 0;
	private int choice;
	private int projectChoice;
	private Output output;
	private Input input;

	public Kickstart(Output output, Input input) {
		this.output = output;
		this.input = input;
	}

	public void buildList(Category category) {
		categories.add(category);
	}

	public void showList() {
		for (Category category : categories) {
			if (i == categories.size()) {
				output.println(i + " - " + category.getName());
			} else {
				output.print(i + " - " + category.getName() + ", ");
				i++;
			}
		}
		output.println("What are you interested in? Pleace, make your choice:");
	}

	public void showChoice() {
		choice = input.readChoice() - 1;
		output.println("You chose - " + categories.get(choice).getName());
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
			if (project.getCategory() == categories.get(choice)) {
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
						i = 1;
						j = 0;
						showProjects();
					}
				} else {
					i = 1; 
					j = 0;
					showList();
					showChoice();
					showProjects();
				}
			}
		}
	}

	public static void main(String[] args) {
		Kickstart kick = new Kickstart(new ConsoleOutput(), new ConsoleInput());
		Quote quote = new Quote(new ConsoleOutput(), new Random());
		Category sport = new Sport();
		Category science = new Science();
		Category music = new Music();
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
		kick.buildList(sport);
		kick.buildList(science);
		kick.buildList(music);
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
