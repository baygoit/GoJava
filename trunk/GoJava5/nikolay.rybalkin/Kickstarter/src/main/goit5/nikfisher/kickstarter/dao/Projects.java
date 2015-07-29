package goit5.nikfisher.kickstarter.dao;


import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;

import java.util.List;

public interface Projects {

    void add(Project project);

    List<Project> getProjects(Category category);

    Project get(int index);
}
