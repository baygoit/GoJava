package nikfisher.kickstarter.dao;

import nikfisher.kickstarter.model.Category;
import nikfisher.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryProjects implements Projects {

    private int index = 0;

    final private Map<Integer, Project> PROJECTS = new HashMap<>();

    @Override
    public void add(Project project) {
        PROJECTS.put(index++, project);
    }

    @Override
    public List<Project> getProjects(Category category) {

        List<Project> result = new ArrayList<>();
        int found = 0;

        for (int i = 0; i < index; i++) {
            Project project = PROJECTS.get(i);

            if (project.getCategory().equals(category)) {
                result.add(found, project);
                found++;
            }
        }

        return result;
    }

    @Override
    public Project get(int index) {
        return PROJECTS.get(index);
    }


}
