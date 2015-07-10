package ua.goit.kyrychok.views;

import ua.goit.kyrychok.common.Output;
import ua.goit.kyrychok.domain.Project;
import ua.goit.kyrychok.models.ProjectModel;

public class ProjectView {
    private Output output;

    public ProjectView(Output output) {
        this.output = output;
    }

    public void show(ProjectModel model) {
        Project project = model.getProject();
        output.show(String.format("Name: %s", project.getName()));
        output.show(project.getShortDescription());
        output.show(String.format("Pledge: %s. Goal: %s", project.getPledge() / 100, project.getPledgeGoal() / 100));
        output.show(String.format("%s days to go", "DaysBetween"));
        output.show("-----------");
        output.show(String.format("Description: %s", project.getDescription()));
    }
}
