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

        /** Выводим мотиватор **/
        QuoteGenerate generate = new QuoteGenerate();
        System.out.println(generate.quoteGenerate());

        while (true) {

            /** Предлогаем выбрать категорию **/
			System.out.println(SPACE);
			System.out.println("Select category: ");
			System.out.println(Arrays.toString(categories.getCategories()));

            /** Спрашиваем пользователя, что он хочит выбрать**/
			ScanConsole scanConsole = new ScanConsole();

            /** Подучаем выбранную ватегорию **/
			Category category = categories.getName(scanConsole.consoleScan(b));
			System.out.println("You selected category: " + category.getName());

            /** Подучаем список проектов **/
			Project[] foundProjects = projects.getProgects(category);

            /** Вывод информации по каждому проекту **/
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

