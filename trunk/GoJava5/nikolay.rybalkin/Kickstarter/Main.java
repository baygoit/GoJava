import java.util.Arrays;

public class Main {
	
	private String SPACE = " ";
	private Categories categories;
	private Projects projects;
	private int b;
	
	public Main(Categories categories, Projects projects) {
		this.categories = categories;
		this.projects = projects;
	}

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

    private void run() {

		while (true) {
			QuoteGenerate generate = new QuoteGenerate();
			System.out.println(generate.quoteGenerate());
			System.out.println(SPACE);
			System.out.println("Select category: ");
			System.out.println(Arrays.toString(categories.getCategories()));

			ScanConsole scanConsole = new ScanConsole();

			Category category = categories.getName(scanConsole.consoleScan(b));
			System.out.println("You selected category: " + category.getName());
			Project[] foundProjects = projects.getProgects(category);

			for (Project project : foundProjects) {
				System.out.println("Project name: " + project.getName());
				System.out.println("Description: " + project.getDescription());
				System.out.println("Need collected: " + project.getAmount() + "$");
				System.out.println("Already collected: " + project.getExist() + "$");
				System.out.println("Days remaining: " + project.getDays());
				System.out.println("/-------------------------------------------------------------------------------/");
				System.out.println(SPACE);
			}
		}
	}
}

