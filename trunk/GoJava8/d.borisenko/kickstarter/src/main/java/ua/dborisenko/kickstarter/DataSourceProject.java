package ua.dborisenko.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class DataSourceProject {

    public static void add(Project project) {
        DataSource.allProjects.add(project);
    }

    public static void update(Project project) {
        for (int i = 0; i < DataSource.allProjects.size(); i++) {
            if (DataSource.allProjects.get(i).getId() == project.getId()) {
                DataSource.allProjects.set(i, project);
            }
        }
    }

    public static void delete(Project project) {
        for (int i = 0; i < DataSource.allProjects.size(); i++) {
            if (DataSource.allProjects.get(i).getId() == project.getId()) {
                DataSource.allProjects.remove(i);
            }
        }
    }

    public static List<Project> getProjectsByCategoryId(int categoryId) {
        List<Project> resultProjects = new ArrayList<Project>();
        for (Project project : DataSource.allProjects) {
            if (project.getCategoryId() == categoryId) {
                resultProjects.add(project);
            }
        }
        return resultProjects;
    }
}
