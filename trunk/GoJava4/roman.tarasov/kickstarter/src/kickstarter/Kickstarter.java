package kickstarter;

import java.util.ArrayList;

public class Kickstarter {

	public void start(ArrayList<Category> listCategories,
			ArrayList<Project> listProjects, ArrayList<Citation> listCitations,
			ArrayList<User> listUsers) {
		for (Category i : listCategories) {
			System.out.println(i.id + "-" + i.name);
		}
		for (Project i : listProjects) {
			System.out.println(i.id + "-" + i.name);
		}
		for (Citation i : listCitations) {
			System.out.println(i.id + "-" + i.text);
		}
		for (User i : listUsers) {
			System.out.println(i.id + "-" + i.name);
		}
	}

}
