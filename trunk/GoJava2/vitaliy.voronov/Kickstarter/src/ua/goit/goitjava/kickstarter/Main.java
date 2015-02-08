package ua.goit.goitjava.kickstarter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Storage stor = new Storage();

		while (true) {
			Output out = new Output();
			out.printQuote();
			out.menu();
			Input in = new Input();

			switch (in.scanInt()) {
			case 0:
				break;
			case 1:
				out.youChoose(Category.EDUCATION.name());
				ArrayList<Project> projectsByCategory1 = stor
						.getProjectsByCategory(Category.EDUCATION);
				out.printProject(projectsByCategory1);
				//out.print(projectsByCategory1);
				out.printZero();
				int projectId1 = in.scanInt();
				if(projectId1 == 0){
					break;
				}
				out.printSelectProject(projectsByCategory1.get(projectId1 - 1));
				break;
			case 2:
				out.youChoose(Category.FINANCE.name());
				ArrayList<Project> projectsByCategory2 = stor
						.getProjectsByCategory(Category.FINANCE);
				out.printProject(projectsByCategory2);
				out.printZero();
				int projectId2 = in.scanInt();
				if(projectId2 == 0){
					break;
				}
				out.printSelectProject(projectsByCategory2.get(projectId2 - 1));
				break;
			case 3:
				out.youChoose(Category.GAMES.name());
				ArrayList<Project> projectsByCategory3 = stor
						.getProjectsByCategory(Category.GAMES);
				out.printProject(projectsByCategory3);
				out.printZero();
				int projectId3 = in.scanInt();
				if(projectId3 == 0){
					break;
				}
				out.printSelectProject(projectsByCategory3.get(projectId3 - 1));
				break;
			}
			System.out.println("==========================");
		}

	}

}
