package nikfisher.kickstarter.dao;


import nikfisher.kickstarter.model.Category;
import nikfisher.kickstarter.model.Project;

import java.util.List;

public interface Projects {

    void add(Project project);

    List<Project> getProjects(Category category);

    Project get(int index);
}
