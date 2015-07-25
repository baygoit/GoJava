package goit5.nikfisher.kickstarter.model;


import java.util.List;

public interface Projects {

    void add(Project project);

    Project[] getProjects(Category category);

    Project get(int index);
}
