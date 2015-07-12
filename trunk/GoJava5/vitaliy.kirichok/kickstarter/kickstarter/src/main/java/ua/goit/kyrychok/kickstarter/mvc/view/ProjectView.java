package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.Utils;
import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;

import java.util.Date;

public class ProjectView {
    private Output output;

    public ProjectView(Output output) {
        this.output = output;
    }

    public void render(ProjectModel model) {
        output.writeLine(String.format("Project name: %s", model.getName()));
        output.writeLine(String.format("Short Description: %s", model.getShortDescription()));
        output.writeLine(String.format("Goal: %s", model.getGoal()));
        output.writeLine(String.format("Balance: %s", model.getBalance()));
        output.writeLine(String.format("%s", Utils.getDiffDate(model.getDeadlineDate(), new Date())));

    }
}
