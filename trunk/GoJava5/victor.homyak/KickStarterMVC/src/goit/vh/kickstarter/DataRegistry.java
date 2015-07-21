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
    private Output output = new Output();//
    private Category[] categories = new Category[0];

    private Map<Integer, Project[]> hm = new HashMap<>();

    public Category[] getCategories() {
        return categories;
    }

    public void registerCategories(Category[] categories) {
        this.categories = categories;
    }

    public void registerProjects(Map<Integer, Project[]> hm) {
        this.hm = hm;
    }

    public Project[] getProjectList(int index) {
        if (hm.get(index) != null) {
            return hm.get(index);
        } else {
            output.println("You choose not sutable variant, try more.");
            return null;
        }
    }

    public Project getProject(int[] path) {
        if (hm.get(path[0]).length < path[1]  ||(path[1] - 1)<0) {//TODO renaime, make more understendeble. Use Enume
            //  output.println("You choose not sutable variant, try more.");
            return null;
        }
        return hm.get(path[0])[path[1] - 1];
    }
}
