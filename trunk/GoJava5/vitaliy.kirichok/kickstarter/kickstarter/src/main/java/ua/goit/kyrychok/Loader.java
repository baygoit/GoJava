package ua.goit.kyrychok;

import ua.goit.kyrychok.domain.Category;
import ua.goit.kyrychok.domain.Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Loader {

    public static Date convertDate(String date) {
        Date result = new Date();
        try {
            result = new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Category> load() {
        List<Category> result = new ArrayList<>();
        Category category;
        Project project;
        category = new Category("Category 1");
        project = new Project("1st project in 1st category", "description", "desc", 1000000, 350000, convertDate("01.07.2015"), convertDate("01.08.2015"));
        category.addProject(project);
        project = new Project("2st project in 1st category", "description2", "desc2", 10000, 3500, convertDate("01.07.2015"), convertDate("01.08.2015"));
        category.addProject(project);
        result.add(category);
        category = new Category("Category 2");
        project = new Project("1st project in 2st category", "description21", "desc21", 1000000, 350000, convertDate("01.07.2015"), convertDate("01.08.2015"));
        category.addProject(project);
        result.add(category);
        category = new Category("Empty category");
        result.add(category);
        return result;
    }
}
