package ua.goit.kyrychok.views;

import ua.goit.kyrychok.common.Console;
import ua.goit.kyrychok.domain.Project;

public class ProjectView {
    private Console console = new Console();

    public void show(String path, Project model) {
        console.writeLine(path);
        console.writeLine(String.format("Name: %s", model.getName()));
        console.writeLine(model.getShortDescription());
        console.writeLine(String.format("Pledge: %s. Goal: %s", model.getPledge() / 100, model.getPledgeGoal() / 100));
        console.writeLine(String.format("%s days to go", "DaysBetween"));
        console.writeLine("-----------");
        console.writeLine(String.format("Description: %s", model.getDescription()));
    }
}
