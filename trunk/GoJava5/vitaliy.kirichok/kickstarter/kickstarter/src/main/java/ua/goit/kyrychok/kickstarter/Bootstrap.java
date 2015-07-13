package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.model.ProjectEvent;

import static ua.goit.kyrychok.kickstarter.Utils.convertDate;

public class Bootstrap {
    public static void main(String[] args) {
        DataProvider dataProvider = new DataProvider();
        Category category;
        Project project;

        category = new Category("Category 1");
        project = new Project("1st project in 1st category", "desc", 10000, 350000, convertDate("01.07.2015"), convertDate("01.08.2015"), "http://stackoverflow.com/");
        project.addFaq(new Faq("Question 1", "Answer on question 1"));
        project.addFaq(new Faq("Question 2", "Answer on question 2"));
        project.addFaq(new Faq("Question 3", "Answer on question 3"));
        project.addProjectEvent(new ProjectEvent(convertDate("12.07.2015"), "Project was started"));
        project.addProjectEvent(new ProjectEvent(convertDate("10.07.2015"), "Thank you"));
        category.addProject(project);
        project = new Project("2st project in 1st category", "desc2", 1000, 350, convertDate("01.07.2015"), convertDate("20.08.2015"), "");
        category.addProject(project);
        dataProvider.addCategory(category);

        category = new Category("Category 2");
        project = new Project("1st project in 2st category", "desc21", 1000000, 600000, convertDate("01.07.2015"), convertDate("01.11.2015"), "");
        category.addProject(project);
        dataProvider.addCategory(category);

        dataProvider.addCategory(new Category("Empty Category"));

        Output output = new Output();

        KickStarter kickStarter = new KickStarter();
        kickStarter.init(dataProvider, output);
        kickStarter.run();
    }
}
