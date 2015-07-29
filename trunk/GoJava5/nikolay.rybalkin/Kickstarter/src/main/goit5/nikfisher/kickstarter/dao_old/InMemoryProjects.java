package goit5.nikfisher.kickstarter.dao_old;

import goit5.nikfisher.kickstarter.dao.Projects;
import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryProjects implements Projects {

//    private int index = 0;
//
//    private Map<Integer, Project> projects = new HashMap<>();
//
//    @Override
//    public void add(Project project) {
//        projects.put(index++, project);
//    }
//
//    @Override
//    public List<Project> getProjects(Category category) {
//
//        List<Project> result = new ArrayList<>();
//        int found = 0;
//
//        for (int i = 0; i < index; i++) {
//            Project project = projects.get(i);
//
//            if (project.getCategory().equals(category)) {
//                result.add(found, project);
//                found++;
//            }
//        }
//
//        return result;
//    }
//
//    @Override
//    public Project get(int index) {
//        return projects.get(index);
//    }


}
