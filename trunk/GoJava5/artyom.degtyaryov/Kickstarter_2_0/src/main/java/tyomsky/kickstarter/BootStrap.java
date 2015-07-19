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
        Project project1 = new Project("GTA 5", "5-th episode of epic game",
                1_000_000, 365, "http://youtube.com/89a0cdb8", category1);
        project1.setHistory("we just starter and its nothing to say now! To be continue.");
        project1.setQuestionsAndAnswers("Q: when will you release PC version? \n" +
                "A: Next year.");
        projectList.add(project1);
        Project project2 = new Project("StarCraft 2", "continue of epic game",
                2_000_000, 120, "http://youtube.com/21a5c668", category1);
        projectList.add(project2);
        Project project3 = new Project("Kosinka 2", "2-nd part of epic game",
                10_000_000, 1000, "http://youtube.com/160cac48", category1);
        project3.setHistory("We have collected 100000$ now. We need to collect more to start development.");
        project3.setQuestionsAndAnswers("Q: Will you develop version for Mac and Linux? \n" +
                "A: No. Only Windows");
        project3.setMoneyCollected(100_000);
        projectList.add(project3);

        Kickstarter kickstarter = new Kickstarter(categoryList, projectList);
        kickstarter.run();
    }

//    UserStory2 Как гость я хочу видеть список категорий, с тем чтобы сфокусироваться на интересующей меня теме
//    сценарий 1: захожу в приложение -> вижу пронумерованный список категорий и запрос на выбор категории ->
//    выбираю категорию по номеру -> вижу сообщение о том, что я выбрал

}
