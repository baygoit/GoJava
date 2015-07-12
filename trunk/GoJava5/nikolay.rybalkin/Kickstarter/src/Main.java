import java.util.Arrays;

public class Main {

	private String SPACE = " ";
	private Categories categories;
	private Projects projects;
	private ScanConsole scanConsole = new ScanConsole();

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
			askCategory(output);
			Category category = shooseCategory(output);

			// TODO: нет нумерации проектов

			printProjects(output, category);


			while (true) {

				// TODO: попросить пользователя выбрать проект по номеру
				ascProject(output);

				// TODO: найти проект по индексу
				Project project = shooseProject(output);

				// TODO: распечатать подробности проекта все то же что в списке + история проекта + линк на видео с демо + вопросы/ответы
				printProjectDetail(output, project);
			}
		}
		// TODO: находясь в одной категории могу выбрать проект из другой
	}

	private void ascProject(Output output) {
		output.println(SPACE);
		output.println("Select project: ");
	}

	private void printProjectDetail(Output output, Project project) {
		output.println("Project detail:");
		printProject(output, project);
		output.println(project.getHistory());
		output.println(project.getVideo());
		output.println(project.getFAQ());
	}

	private void printProjects(Output output, Category category) {
		Project[] foundProjects = projects.getProgects(category);
		for (int i = 0; i < foundProjects.length; i++) {
			Project project = foundProjects[i];
			System.out.print(i + ") ");
			printProject(output, project);
        }
	}

	private void printProject(Output output, Project project) {
		output.println("Project name: " + project.getName());
		output.println("Description: " + project.getDescription());
		output.println("Need collected: " + project.getAmount() + "$");
		output.println("Already collected: " + project.getExist() + "$");
		output.println("Days remaining: " + project.getDays());
		output.println("---------------------------------------");
		output.println(SPACE);
	}


	private void askCategory(Output output) {
		output.println(SPACE);
		output.println("Select category: ");
		output.println(Arrays.toString(categories.getCategories()));
	}

	private Category shooseCategory(Output output) {
		Category category = categories.get(scanConsole.consoleScan());
		output.println("You selected category: " + category.getName());
		return category;
	}

	private Project shooseProject(Output output) {
		Project project = projects.get(scanConsole.consoleScan());
		output.println("You selected project: " + project.getName());
		return project;
	}

}

