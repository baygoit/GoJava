package myRealization;

import java.util.*;

public class Kickstart {
	private int choice;
	private int projectChoice;
	private Output output;
	private Input input;
	private Categories categories;
	private Projects projects;
	
	public Kickstart(Output output, Input input, Categories categories, Projects projects) {
		this.output = output;
		this.input = input;
		this.categories = categories;
		this.projects = projects;
	}

	public void showList() {
		output.println(categories.getCategories() + "\nWhat are you interested in? Pleace, make your choice:");
	}

	public void showChoice(int choice) {
		this.choice = choice;
		output.println("You chose - " + categories.readCategory(choice).getName());
	}

	public void showProjects() {
		int j = 1;
		projects.chooseProjects(categories.readCategory(choice));
		for (String project : projects.writeProjects()){
			output.println(j + ")" + project);
			j++;
		}
		output.println("If you want to return press \"0\"");
	}

	public void showChosenProject(int choice) {
		projectChoice = choice;
		output.println("--------------------------------------------------");
		output.println("You chose:"
				+ (projects.readProject(projectChoice)));
		for (String s : projects.giveAllInfo(projects.readObject(projectChoice))){
			output.println(s);
		}
		output.println("--------------------------------------------------");
	}
	
	public int catchProjectError(){
		int l = 0;
		while(true){
			try {
				l = catchException() - 1;
				if (l == -1){
					break;
				}
				projects.readObject(l);
				break;
			} catch (IndexOutOfBoundsException e){
				output.println("Error!! There are no such project - Try again:");
			}
		}
		return l;
	}
	
	public int catchArrayError(){
		int l = 0;
		while(true){
			try {
				l = catchException() - 1;
				if (l == -1){
					break;
				}
				categories.readCategory(l);
				break;
			} catch (IndexOutOfBoundsException e){
				output.println("Error!! There are no such category - Try again:");
			}
		}
		return l;
	}
	
	public int catchException(){
		int l = 0;
		while(true){
			try {
				l = input.readChoice();
				
				break;
			} catch (Exception e){
				output.println("Error!! You must enter numbers! - Try again:");
			}
		}
		return l;
	}

	public void returnToProjects(int g) {
			if (g == 0){
				showProjects();
				
			} else {
				while (g != 0){
					output.println("Error!! You must enter 0 \nPlease, try again");
					g = catchException();
				}
				showProjects();
			}
	}
	
	public void navigate(int k) {
		while (k >= 0){
			showChosenProject(k);
			output.println("Return - \"0\"");
			returnToProjects(catchException());
			k = catchProjectError();
		}
	}
	
	public void buildMenu(){
		while (true){
				showList();
				int intForExit = catchArrayError();
				if (intForExit < 0){
					break;
				} else {
					showChoice(intForExit);
				}
				
				showProjects();
				navigate(catchProjectError());
		}
		output.println("Thanks for using our program, Goodbye!");
	}

	public static void main(String[] args) {
		Categories cat = new Categories();
		Projects projects = new Projects();
		Kickstart kick = new Kickstart(new ConsoleOutput(), new ConsoleInput(), cat, projects);
		Quote quote = new QuoteGenerator(new ConsoleOutput(), new Random());
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
		quote.printQuote();
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
