package ua.com.scread.kickstarter.storage;

import java.util.List;

import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.data.Project;

public interface Projects {

//    List<Project> getProjects();

    List<Project> getProjects(Category category);
    
    Project get(int id);

    void add(Project project);

//    int size();

}