
public class Runner {

	public static void main(String[] args){

		Category category1 = new Category("Game");
		Category category2 = new Category("Design");
		Category category3 = new Category("Technology");

		Categories categories = new Categories();
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);

		Project project1 = new Project("Game \"Popcorn\"", 10000, 10, "Interesting game");
		Project project2 = new Project("Design \"New Design\"", 10000, 10, "New innovation design");
		Project project3 = new Project("Technology \"Wi-Fi\"", 10000, 10, "New technology");
		Project project4 = new Project("Game1 \"Popcorn\"", 10000, 10, "Interesting game");
		Project project5 = new Project("Design1 \"New Design\"", 10000, 10, "New innovation design");
		Project project6 = new Project("Technology1 \"Wi-Fi\"", 10000, 10, "New technology");

		project1.setCategory(category1);
		project2.setCategory(category2);
		project3.setCategory(category3);
		project4.setCategory(category1);
		project5.setCategory(category2);
		project6.setCategory(category3);

		Projects projects = new Projects();
		projects.add(project1);
		projects.add(project2);
		projects.add(project3);
		projects.add(project4);
		projects.add(project5);
		projects.add(project6);

		Main app = new Main(categories, projects);
		app.run();
	}
}
