package kikcstarter;

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
				int projectId1 = in.scanInt();
				out.printSelectProject(projectsByCategory1);
				System.out.println(projectsByCategory1.get(projectId1 - 1));
				break;
			case 2:
				out.youChoose(Category.FINANCE.name());
				ArrayList<Project> projectsByCategory2 = stor
						.getProjectsByCategory(Category.FINANCE);
				out.printProject(projectsByCategory2);
				int projectId2 = in.scanInt();
				System.out.println(projectsByCategory2.get(projectId2 - 1));
				break;
			case 3:
				out.youChoose(Category.GAMES.name());
				ArrayList<Project> projectsByCategory3 = stor
						.getProjectsByCategory(Category.GAMES);
				out.printProject(projectsByCategory3);
				break;
			}
			System.out.println("==========================");
		}

	}

}
