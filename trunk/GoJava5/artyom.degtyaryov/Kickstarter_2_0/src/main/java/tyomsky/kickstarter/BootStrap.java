package tyomsky.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class BootStrap {

    public static void main(String[] args) {
        List<Category> categoryList = new ArrayList<>();
        Category category1 = new Category("Games");
        categoryList.add(category1);
        Category category2 = new Category("Music");
        categoryList.add(category2);
        Category category3 = new Category("Sport");
        categoryList.add(category3);

        List<Project> projectList = new ArrayList<>();
        Project project1 = new Project("GTA 5", "5-th part of epic game", 1_000_000, 365, category1);
        projectList.add(project1);
        Project project2 = new Project("StarCraft 2", "continue of epic game", 2_000_000, 120, category1);
        projectList.add(project2);
        Project project3 = new Project("Kosinka 2", "2-nd part of epic game", 10_000_000, 1000, category1);
        projectList.add(project3);

        Kickstarter kickstarter = new Kickstarter(categoryList, projectList);
        kickstarter.run();
    }

//    UserStory2 Как гость я хочу видеть список категорий, с тем чтобы сфокусироваться на интересующей меня теме
//    сценарий 1: захожу в приложение -> вижу пронумерованный список категорий и запрос на выбор категории ->
//    выбираю категорию по номеру -> вижу сообщение о том, что я выбрал

}
