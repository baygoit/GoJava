
public class Runner {

	public static void main(String[] args){

		Category category1 = new Category("Game");
		Category category2 = new Category("Design");
		Category category3 = new Category("Technology");

		Categories categories = new Categories();
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);

		Project project1 = new Project("Game \"Popcorn\"", 10000, 15, "Interesting game");
		Project project2 = new Project("Design \"New Design\"", 10000, 15, "New innovation design");
		Project project3 = new Project("Technology \"Wi-Fi\"", 10000, 15, "New technology");

		project1.setCategory(category1);
		project2.setCategory(category2);
		project3.setCategory(category3);

		Projects projects = new Projects();
		projects.add(project1);
		projects.add(project2);
		projects.add(project3);

		Main app = new Main(categories, projects);
		app.run();
	}
}
