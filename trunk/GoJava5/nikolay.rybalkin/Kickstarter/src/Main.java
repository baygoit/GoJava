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

	public void run() {

        /** Print the motivator **/
        QuoteGenerate generate = new QuoteGenerate();
        System.out.println(generate.quoteGenerate());

        while (true) {

            /** We offer select category **/
			System.out.println(SPACE);
			System.out.println("Select category: ");
			System.out.println(Arrays.toString(categories.getCategories()));

            /** Asks the user to choose what he wants **/
			ScanConsole scanConsole = new ScanConsole();

            /** Think selected category **/
			Category category = categories.getName(scanConsole.consoleScan(b));
			System.out.println("You selected category: " + category.getName());

            /** We get the list of projects **/
			Project[] foundProjects = projects.getProgects(category);

            /** Displays information on each project **/
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

