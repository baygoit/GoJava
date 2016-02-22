package com.kickstarter;

/**
 * Created by Игорь on 07.02.2016.
 */
public class KickstarterRunner {
    public static void main(String[] args) {
        Category category1 = new Category("Photo");
        Category category2 = new Category("Video");
        Category category3 = new Category("Music");

        Categories categories = new Categories();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        Project project1 = new Project("Фильм \"Как кодить на java\"", 100000, 15, "Фильм о том, как можно самому научится кодить на Java",
                "youtube.com/1");
        Project project2 = new Project("Фильм \"GoJava\"", 2345, 10, "Фильм о том, как ребята учят Java с GoIT",
                "youtube.com/2");

        project1.setCategory(category1);
        project2.setCategory(category1);

        Projects projects = new Projects();
        projects.add(project1);
        projects.add(project2);

        Kickstarter application = new Kickstarter(categories, projects, null);

        project1.setHistory("История этого проекта корнями уходит..");
        project2.setHistory("Мы только начали, по этому нечего рассказывать. \n" +
                "Продолжение следует!");

        project1.setQuetionAnswer("Q: Какая продолжительность фильма? \n" +
                "A: два часа" );
        application.run();
    }
}
