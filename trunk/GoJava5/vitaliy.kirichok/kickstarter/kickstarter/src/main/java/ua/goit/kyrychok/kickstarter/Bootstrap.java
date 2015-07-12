package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.convertDate;

public class Bootstrap {
    public static void main(String[] args) {
        DataProvider dataProvider = new DataProvider();
        List<Category> categories = new ArrayList<>();
        Category category;
        Project project;

        category = new Category("Category 1");
        project = new Project("1st project in 1st category", "description", "desc", 1000000, 350000, convertDate("01.07.2015"), convertDate("01.08.2015"));
        category.addProject(project);
        project = new Project("2st project in 1st category", "description2", "desc2", 10000, 3500, convertDate("01.07.2015"), convertDate("01.08.2015"));
        category.addProject(project);
        categories.add(category);

        category = new Category("Category 2");
        project = new Project("1st project in 2st category", "description21", "desc21", 1000000, 350000, convertDate("01.07.2015"), convertDate("01.08.2015"));
        category.addProject(project);
        categories.add(category);
        categories.add(new Category("Empty Category"));
        dataProvider.setCategories(categories);

        Output output = new Output();

        KickStarter kickStarter = new KickStarter();
        kickStarter.init(dataProvider, output);
        kickStarter.run();
    }
}
