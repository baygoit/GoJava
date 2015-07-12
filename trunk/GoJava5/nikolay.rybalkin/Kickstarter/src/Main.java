import java.util.Arrays;

public class Main {

	private String SPACE = " ";
	private Categories categories;
	private Projects projects;
	private ScanConsole scanConsole = new ScanConsole();
	private Output output = new Output();

	public Main(Categories categories, Projects projects) {
		this.categories = categories;
		this.projects = projects;
	}

	public void run() {

		Output output = new Output();

		/** Print the motivator **/
		QuoteGenerate generate = new QuoteGenerate();
		output.println(generate.quoteGenerate());

		while (true) {
			askCategory();
			Category category = shooseCategory();

			Project[] foundProjects = projects.getProgects(category);
			printProjects(foundProjects);

			while (true) {
				ascProject();
				Project project = foundProjects[scanConsole.consoleScan()];
				//TODO если выбран не существующий проект вылетает ошибка
				shooseProject(project);
				printProjectDetail(project);
			}
			//TODO бесконечный цикл
		}
	}

	private void ascProject() {
		output.println("Select project: ");
	}

	private void printProjectDetail(Project project) {
		output.println("Project detail:");
		printProject(project);
		output.println(project.getHistory());
		output.println(project.getVideo());
		output.println(project.getFAQ());
		output.println("---------------------------------------");
	}

	private void printProjects(Project[] foundProjects) {

		for (int i = 0; i < foundProjects.length; i++) {
			Project project = foundProjects[i];
			System.out.print(i + ") ");
			printProject(project);
        }
	}

	private void printProject(Project project) {
		output.println("Project name: " + project.getName());
		output.println("Description: " + project.getDescription());
		output.println("Need collected: " + project.getAmount() + "$");
		output.println("Already collected: " + project.getExist() + "$");
		output.println("Days remaining: " + project.getDays());
		output.println("---------------------------------------");
		output.println(SPACE);
	}


	private void askCategory() {
		output.println(SPACE);
		output.println("Select category: ");
		output.println(Arrays.toString(categories.getCategories()));
	}

	private Category shooseCategory() {
		Category category = categories.get(scanConsole.consoleScan());
		output.println("You selected category: " + category.getName());
		return category;
	}

	private void shooseProject(Project project) {
		output.println("You selected project: " + project.getName());
	}

}

