package tyomsky.kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kickstarter {

    List<Category> categories;

    List<Project> projects;

    public Kickstarter(List<Category> categories, List<Project> projects) {
        this.categories = categories;
        this.projects = projects;
    }

    public void run() {
//        UserStory3 Как гость я хочу изучить список проектов определенной категории, чтобы понять во что я хочу инвестировать
//        сценарий 1: захожу в приложение -> выбираю любую категорию (например, 1 - спорт) -> вижу список проектов,
//        каждый из которых содержит: название, краткое описание, сумму необходиму для сбора, сколько собрали уже, сколько дней осталось
        System.out.println(new QuoteGenerator().getQuote());

        for (int i = 0; i < categories.size(); i++) {
            int menuIndex = i + 1;
            System.out.println(menuIndex + ": " + categories.get(i).getName());
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Make a choice: ");
        Scanner scanner = new Scanner(System.in);
        int chosenMenuIndex = scanner.nextInt();

        Category chosenCategory = categories.get(chosenMenuIndex - 1);

        System.out.println("You have chosen: " + chosenCategory.getName());

        List<Project> foundProjects = getProjetsByCategory(chosenCategory);

        for (int i = 0; i < foundProjects.size(); i++) {
            int menuIndex = i + 1;
            Project project = foundProjects.get(i);
            System.out.println(menuIndex + ": " + project.getShortPresentation());
            System.out.println("------------------------------------------------------");
        }

    }

    private List<Project> getProjetsByCategory(Category category) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if (project.getCategory().equals(category)) {
                result.add(project);
            }
        }
        return result;
    }

}
