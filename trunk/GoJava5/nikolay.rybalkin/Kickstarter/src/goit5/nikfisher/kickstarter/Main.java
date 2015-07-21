package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.menu.CategoryMenu;
import goit5.nikfisher.kickstarter.menu.ProjectMenu;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;

//import java.util.Arrays;

public class Main {

//	private String SPACE = " ";
//	private Categories categories;
//	private Projects projects;
//	private InputOutputConsoleInterface io;
//	private QuoteGenerate generator;
//	private ProjectMenu projectMenu;
	private CategoryMenu categoreMenu;


//	public Main(Categories categories, Projects projects, InputOutputConsoleInterface io, QuoteGenerate generator, ProjectMenu projectMenu) {
//
//		this.categories = categories;
//		this.projects = projects;
//		this.io = io;
//		this.generator = generator;
//		this.projectMenu = projectMenu;
//	}

	public void run() {

//		io.println(generator.quoteGenerate());

//		CategoryMenu categoreMenu = new CategoryMenu();
		categoreMenu.categoryMenu();
//		io.println("Sank!");
	}

	//TODO вынести менюхи в отдельные классы


//	private void projectsMenu(Project[] foundProjects) {
//
//		while (true) {
//
//            ascProjects(foundProjects);
//
//            int menuIndex = io.consoleScanInt();
//
//            if (menuIndex == 0){
//                break;
//            }
//
//            if (menuIndex <= 0 || foundProjects.length <  menuIndex){
//				io.println("Not true index: " + menuIndex);
//                continue;
//            }
//            Project project = foundProjects[menuIndex - 1];
//
//            shooseProject(project);
//            printProjectDetail(project);
//
//			if (project != null){
//				continue;
//			}
//
//			projectMenu.projectMenuRun(project);
//		}
//	}






//	private void ascProjects(Project[] foundProjects) {
//
//		if (foundProjects.length == 0 ){
//			io.println("Projects in this category do not have to exit, enter 0");
//		}else {
//			int from = 0;
//			int to = foundProjects.length - 1;
//			io.println("Select project: [" + from + "..." +  to  + " or 0 for exit to the projects list");
//		}
//	}

//	private void printProjectDetail(Project project) {
//
//		io.println("Project detail:");
//		printProject(project);
//
//		String history = project.getHistory();
//		if (history != null){
//			io.println(history);
//		}
//
//		String video = project.getVideo();
//		if (video != null){
//			io.println(video);
//		}
//
//		String question = project.getQuestion();
//		if (question != null){
//			io.println(question);
//		}
//
//		String ansver = project.getAnsver();
//		if (ansver != null){
//			io.println(ansver);
//		}
//
//		io.println("---------------------------------------");
//	}
//

//	public void printProject(Project project) {
//
//		io.println("Project name: " + project.getName());
//		io.println("Description: " + project.getDescription());
//		io.println("Need collected: " + project.getAmount() + "$");
//		io.println("Already collected: " + project.getExist() + "$");
//		io.println("Days remaining: " + project.getDays());
//		io.println("---------------------------------------");
//		io.println(SPACE);
//	}






//	private void shooseProject(Project project) {
//
//		io.println("You selected project: " + project.getName());
//	}

}



