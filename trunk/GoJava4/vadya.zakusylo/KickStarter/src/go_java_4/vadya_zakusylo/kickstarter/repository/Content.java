package go_java_4.vadya_zakusylo.kickstarter.repository;

import java.util.ArrayList;
import java.util.List;

public class Content implements ContentInterface {

	private List<CategoryInterface> categories;

	public Content() {
		categories = new ArrayList<CategoryInterface>();
		initCategoriesAndProjects();
	}

	public void initCategoriesAndProjects() {
		CategoryInterface categoryFirst = new Category("Snowboarding");
		CategoryInterface categorySecond = new Category("Traveling");
		CategoryInterface categoryThird = new Category("Learning");

		categories.add(categoryFirst);
		categories.add(categorySecond);
		categories.add(categoryThird);

		ProjectInterface projectFirst = new Project(
				"GNU Dirty Pillow BTX Snowboard",
				"Snowboard is a befuddling"
						+ "mutant hybrid child of a pow board and it's forbidden love affair with a park"
						+ "board", 400.00, 30, "history",
				"https://www.youtube.com/watch?v=b2v2Z4AC58E");
		ProjectInterface projectSecond = new Project("I/OS Replacement Lenses",
				"Photochromic Red Sensor Lens", 140, 90, "history",
				"https://www.youtube.com/watch?v=rvWwBoIyS-M");
		ProjectInterface projectThird = new Project("Primus Litech Superset",
				"The set consists of two pots, a lid, and" + "a separate pot gripper", 50, 30,
				"history", "https://www.youtube.com/watch?v=rV055FvDF8s");
		ProjectInterface projectFourth = new Project("Tent VEIG PRO III",
				"Double entrance expedition tent adapted for"
						+ "using in difficult weather conditions", 270, 90, "history",
				"https://www.youtube.com/watch?v=3zt7RftZPz4");
		ProjectInterface projectFifth = new Project(
				"Java: The Complete Reference (Complete Reference Series)",
				"Book by Herbert Schildt", 50, 30, "history", "");

		projectFirst.setCategory(categoryFirst);
		projectSecond.setCategory(categoryFirst);
		projectThird.setCategory(categorySecond);
		projectFourth.setCategory(categorySecond);
		projectFifth.setCategory(categoryThird);
	}

	public List<CategoryInterface> getCategories() {
		return categories;
	}

}
