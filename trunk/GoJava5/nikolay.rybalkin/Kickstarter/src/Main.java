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
			printProjects(output, category);

			while (true) {
				// TODO: попросить пользователя выбрать проект по номеру
				// TODO: найти проект по индексу
				// TODO: распечатать подробности проекта все то же что в списке + история проекта + линк на видео с демо + вопросы/ответы
			}
		}
	}

	private void printProjects(Output output, Category category) {
		Project[] foundProjects = projects.getProgects(category);
		for (Project project : foundProjects) {
            output.println("Project name: " + project.getName());
            output.println("Description: " + project.getDescription());
            output.println("Need collected: " + project.getAmount() + "$");
            output.println("Already collected: " + project.getExist() + "$");
            output.println("Days remaining: " + project.getDays());
            output.println("/-------------------------------------------------------------------------------/");
            output.println(SPACE);
        }
	}

	private void askCategory(Output output) {
		output.println(SPACE);
		output.println("Select category: ");
		output.println(Arrays.toString(categories.getCategories()));
	}

	private Category shooseCategory(Output output) {

		Category category = categories.getName(scanConsole.consoleScan());
		output.println("You selected category: " + category.getName());
		return category;
	}

}

