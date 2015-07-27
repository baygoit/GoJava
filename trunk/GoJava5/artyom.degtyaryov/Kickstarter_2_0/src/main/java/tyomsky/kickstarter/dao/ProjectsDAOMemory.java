package tyomsky.kickstarter.dao;

import tyomsky.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectsDAOMemory implements ProjectsDAO {

    List<Project> data = new ArrayList<>();

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public Project get(int index) {
        return data.get(index);
    }

    @Override
    public void add(Project project) {
        data.add(project);
    }

}
