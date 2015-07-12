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

        Output output = new Output();

        /** Print the motivator **/
        QuoteGenerate generate = new QuoteGenerate();
        output.println(generate.quoteGenerate());

        while (true) {

            /** We offer select category **/
            output.println(SPACE);
            output.println("Select category: ");
            output.println(Arrays.toString(categories.getCategories()));

            /** Asks the user to choose what he wants **/
            ScanConsole scanConsole = new ScanConsole();

            /** Think selected category **/
            Category category = categories.getName(scanConsole.consoleScan(b));
            output.println("You selected category: " + category.getName());

            /** We get the list of projects **/
            Project[] foundProjects = projects.getProgects(category);

            /** Displays information on each project **/
            for (Project project : foundProjects) {
                output.println("Project name: " + project.getName());
                output.println("Description: " + project.getDescription());
                output.println("Need collected: " + project.getAmount() + "$");
                output.println("Already collected: " + project.getExist() + "$");
                output.println("Days remaining: " + project.getDays());
                output.println("/-------------------------------------------------------------------------------/");
                output.println(SPACE);
            }

            // TODO: попросить пользователя выбрать проект по номеру

            // TODO: найти проект по индексу

            // TODO: распечатать подробности проекта все то же что в списке + история проекта + линк на видео с демо + вопросы/ответы

        }
    }

}

