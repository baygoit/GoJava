package kickstarter;

import java.util.ArrayList;

public class Kickstarter {

	public void start(ArrayList<Category> listCategories,
			ArrayList<Project> listProjects) {
		for (Category i : listCategories) {
			System.out.println(i.id + "-" + i.name);
		}
		for (Project i : listProjects) {
			System.out.println(i.id + "-" + i.name);
		}
	}

}
