package tyomsky.kickstarter.dao;

import tyomsky.kickstarter.model.Project;

public interface ProjectsDAO {
    int size();

    Project get(int index);

    void add(Project project);
}
