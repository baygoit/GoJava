package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.model.*;

import static ua.goit.kyrychok.kickstarter.Utils.convertDate;

public class Bootstrap {
    public static void main(String[] args) {
        DataProvider dataProvider = new DataProvider();
        Category category;
        Project project;

        category = new Category("Category 1");
        project = new Project("1st project in 1st category", 10000, convertDate("01.08.2015"), "desc", 350000, "http://stackoverflow.com/");
        project.addFaq(new Faq("Question 1", "Answer on question 1"));
        project.addFaq(new Faq("Question 2", "Answer on question 2"));
        project.addFaq(new Faq("Question 3", "Answer on question 3"));
        project.addProjectEvent(new ProjectEvent(convertDate("12.07.2015"), "Project was started"));
        project.addProjectEvent(new ProjectEvent(convertDate("10.07.2015"), "Thank you"));
        project.addReward(new Reward(1000, "Some reward for donate 10$"));
        project.addReward(new Reward(3000, "Some reward for donate 30$"));
        project.addReward(new Reward(4000, "Some reward for donate 40$"));
        category.addProject(project);
        project = new Project("2nd project in 1st category", 1000, convertDate("20.08.2015"), "desc2", 350, "");
        category.addProject(project);
        dataProvider.addCategory(category);

        category = new Category("Category 2");
        project = new Project("1st project in 2st category", 1000000, convertDate("01.11.2015"), "desc21", 600000, "");
        category.addProject(project);
        dataProvider.addCategory(category);

        dataProvider.addCategory(new Category("Empty Category"));

        Output output = new Output();

        KickStarter kickStarter = new KickStarter(dataProvider, output);
        kickStarter.run();
    }
}
