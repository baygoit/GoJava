package kickstarter;

import java.util.ArrayList;

public class KickstarterStart {
	 static ArrayList<Category> listCategories = new ArrayList<Category>();

	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		KickstarterStart starter = new KickstarterStart();

		starter.initProjects();
		starter.initCategories();

		kickstarter.start(listCategories);
	}

	public void initProjects() {

	}

	public void initCategories() {
		String[] categories = { "Technology", "Social", "Education" };

		for (int index = 0; index < categories.length; index++) {
			Category current = new Category();
			current.setName(categories[index]);
			current.id = index+1;
			listCategories.add(current);
		}

	}
}
