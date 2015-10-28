package ua.goit.kyrychok.kickstarter.view;

import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.model.Project;

import java.util.Date;
import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.getDiffDate;
import static ua.goit.kyrychok.kickstarter.Utils.getMoney;

public class CategoryView extends BaseView {

    public CategoryView(Output output) {
        super(output);
    }

    public void render(Category model) {
        writeLine(model.getName());
        List<Project> projects = model.getProjects();
        Project project;
        for (int counter = 0; counter < projects.size(); counter++) {
            project = projects.get(counter);
            writeLine(String.format("[%s]. %s", counter + 1, project.getName()));
            writeLineWithParam("     Short Description: %s", project.getShortDescription());
            writeLine(String.format("     Goal: %s", getMoney(project.getGoal())));
            writeLine(String.format("     Balance: %s", getMoney(project.getBalance())));
            writeLine(String.format("     Time left: %s", getDiffDate(project.getDeadlineDate(), new Date())));
        }
        writeLine(CHOICE_MESSAGE);
    }
}
