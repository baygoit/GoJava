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
				ArrayList<Project> projectsByCategory = stor
						.getProjectsByCategory(Category.EDUCATION);
				out.printProjectEducation(projectsByCategory);
				int projectId = in.scanInt();
				System.out.println(projectsByCategory.get(projectId - 1));
				break;
			case 2:
				out.youChoose("finance");
				break;
			case 3:
				out.youChoose("games");
				break;
			case 4:
				break;
			}
			System.out.println("==========================");
		}

	}

}
