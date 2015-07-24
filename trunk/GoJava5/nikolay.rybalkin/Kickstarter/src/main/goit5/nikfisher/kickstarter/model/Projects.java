package goit5.nikfisher.kickstarter.model;


public interface Projects {

    void add(Project project);

    Project[] getProjects(Category category);

    Project get(int index);
}
