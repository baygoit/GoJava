package ua.goit.kyrychok.models;

import ua.goit.kyrychok.DataProvider;
import ua.goit.kyrychok.domain.Project;

public class ProjectModel {
    private Project project;
    private DataProvider dataProvider;

    public ProjectModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public Project getProject() {
        return project;
    }

    public void load(int categoryIndex, int projectIndex) {
        project = dataProvider.getProject(categoryIndex, projectIndex);
    }

}
