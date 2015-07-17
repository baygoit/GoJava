package goit.vh.kickstarter;

import goit.vh.kickstarter.model.Category;
import goit.vh.kickstarter.model.Project;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class DataRegistry {

    private static final String DEFAULT_HELLO_MSG = "Hello on KickStarter";

    private Category[] categories = new Category[0];

    private Map<Integer, Project[]> hm = new HashMap<>();


    public String getHelloMsg() {
        return DEFAULT_HELLO_MSG;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void registerCategories(Category[] categories) {
        this.categories = categories;
    }

    public void registerMapOfProjects(Map<Integer, Project[]> hm) {
        this.hm = hm;
    }

    public Project[] getProjectList(int index) {
        return hm.get(index);
    }

    public Project getProject(int[] path) {
        return hm.get(path[0])[path[1] - 1];
    }
}
