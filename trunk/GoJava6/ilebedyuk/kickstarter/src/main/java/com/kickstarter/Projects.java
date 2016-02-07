package com.kickstarter;

/**
 * Created by Игорь on 06.02.2016.
 */
public class Projects {

    private Project[] projects = new Project[100];
    private int count = 0;

    public void add(Project project) {
        projects[count] = project;
        count++;
    }

    public Project[] getProjects(Category category) {
        Project[] result = new Project[100];
        int found = 0;
        for (int i = 0; i < count; i++) {
            Project project = projects[i];
            if(project.getCategory().equals(category)){
                result[found] = project;
                found++;
            }
        }
        Project[] result2 = new Project[found];
        System.arraycopy(result, 0, result2, 0, found);
        return result2;
    }

    public Project get(int index) {
        return projects[index];
    }
}
