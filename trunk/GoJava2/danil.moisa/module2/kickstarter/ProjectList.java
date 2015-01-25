package kickstarter;

import java.util.ArrayList;

public class ProjectList {
	public static ArrayList<Project> sportProjects = new ArrayList<Project>();
	public static ArrayList<Project> musicProjects = new ArrayList<Project>();
	public static ArrayList<Project> techProjects = new ArrayList<Project>();

	/*
	 * switch(){
	 * 
	 * }
	 */
	public ProjectList() {
		sportProjects.add(new Project("Идивидуальные сноуборды", 5000,
				"Любой принт на Вашем сноуборде!", 3450, 5));
		sportProjects.add(new Project("Супер лыжи", 5000, "Лыжи не стандартной длины!",
				1000, 13));
		sportProjects.add(new Project("Боулинг", 4000, "Выездной боулинг!",
				3250, 23));
	}

	public static void showSportProjects() {
		for (int i = 0; i < sportProjects.size(); i++) { 
			int index = 1 + i;// ??
			System.out.println(index + ". " + sportProjects.get(i).toString());
		}
	}

	public void MusicProjectList() {
		musicProjects.add(new Project("Snowboard", 5000,
				"Black with cool print!", 3450, 5));
		musicProjects.add(new Project("Ski", 5000, "White with cool print!",
				1000, 13));
		musicProjects.add(new Project("Car", 4000, "Red with cool print!",
				3250, 23));
	}

	public static void showMusicProjects() {
		for (int i = 0; i < musicProjects.size(); i++) {
			int index = 1 + i;// ??
			System.out.println(index + ". " + musicProjects.get(i).toString());
		}
	}
	public void TechProjectList() {
		techProjects.add(new Project("Snowboard", 5000,
				"Black with cool print!", 3450, 5));
		techProjects.add(new Project("Ski", 5000, "White with cool print!",
				1000, 13));
		techProjects.add(new Project("Car", 4000, "Red with cool print!",
				3250, 23));
	}

	public static void showTechProjects() {
		for (int i = 0; i < techProjects.size(); i++) {
			int index = 1 + i;// ??
			System.out.println(index + ". " + techProjects.get(i).toString());
		}
	}

}
