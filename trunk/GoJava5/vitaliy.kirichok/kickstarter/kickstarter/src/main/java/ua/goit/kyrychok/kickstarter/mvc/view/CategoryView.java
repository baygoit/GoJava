package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.mvc.model.CategoryModel;

import java.util.Date;
import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.getDiffDate;
import static ua.goit.kyrychok.kickstarter.Utils.getMoney;

public class CategoryView extends BaseView {

    public void render(CategoryModel model) {
        getOutput().writeLine(model.getName());
        List<Project> projects = model.getProjects();
        Project project;
        for (int counter = 0; counter < projects.size(); counter++) {
            project = projects.get(counter);
            getOutput().writeLine(String.format("[%s]. %s", counter + 1, project.getName()));
            getOutput().writeLine(String.format("     Short Description: %s", project.getShortDescription()));
            getOutput().writeLine(String.format("     Goal: %s", getMoney(project.getGoal())));
            getOutput().writeLine(String.format("     Balance: %s", getMoney(project.getBalance())));
            getOutput().writeLine(String.format("     %s", getDiffDate(project.getDeadlineDate(), new Date())));
        }
        getOutput().writeLine(CHOICE_MESSAGE);
    }
}
