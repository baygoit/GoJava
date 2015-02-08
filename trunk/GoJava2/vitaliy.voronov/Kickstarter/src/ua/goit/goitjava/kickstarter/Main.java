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

			Category category = null;
			switch (in.scanInt()) {
			case 0:
				break;
			case 1:
				category = Category.EDUCATION;
				break;
			case 2:
				category = Category.FINANCE;
				break;
			case 3:
				category = Category.GAMES;
				break;
			}
			
			out.youChoose(category.name());
			ArrayList<Project> projectsByCategory = stor
					.getProjectsByCategory(category);
			out.printProject(projectsByCategory);
			//out.print(projectsByCategory1);
			out.printZero();
			int projectId1 = in.scanInt();
			if(projectId1 == 0){
				break;
			}
			out.printSelectProject(projectsByCategory.get(projectId1 - 1));
			System.out.println("==========================");
		}

	}

}
