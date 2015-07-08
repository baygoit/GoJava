package ua.goit.kyrychok.views;

import ua.goit.kyrychok.common.Console;
import ua.goit.kyrychok.domain.Category;
import ua.goit.kyrychok.domain.Project;

import java.util.List;

public class CategoryView {
    private Console console = new Console();

    public void show(String path, Category model) {
        console.writeLine(path);
        List<Project> projects = model.getProjects();
        Project project;
        for (int counter = 0; counter < projects.size(); counter++) {
            project = projects.get(counter);
            console.writeLine(String.format("[%s]. %s", counter + 1, project.getName()));
            console.writeLine(String.format("      %s", project.getShortDescription()));
            console.writeLine(String.format("      Pledge: %s. Goal: %s", project.getPledge() / 100, project.getPledgeGoal() / 100));
            console.writeLine(String.format("      %s days to go", "DaysBetween"));
        }
    }
}
