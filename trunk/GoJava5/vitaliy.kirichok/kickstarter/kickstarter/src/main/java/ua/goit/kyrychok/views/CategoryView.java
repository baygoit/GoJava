package ua.goit.kyrychok.views;

import ua.goit.kyrychok.common.Output;
import ua.goit.kyrychok.domain.Project;
import ua.goit.kyrychok.models.CategoryModel;

import java.util.List;

public class CategoryView {
    private Output output;

    public CategoryView(Output output) {
        this.output = output;
    }

    public void show(CategoryModel model) {
        List<Project> projects = model.getProjects();
        Project project;
        output.show(model.getName());
        for (int counter = 0; counter < projects.size(); counter++) {
            project = projects.get(counter);
            output.show(String.format("[%s]. %s", counter + 1, project.getName()));
            output.show(String.format("      %s", project.getShortDescription()));
            output.show(String.format("      Pledge: %s. Goal: %s", project.getPledge() / 100, project.getPledgeGoal() / 100));
            output.show(String.format("      %s days to go", "DaysBetween"));//TODO Days between
        }
    }
}
