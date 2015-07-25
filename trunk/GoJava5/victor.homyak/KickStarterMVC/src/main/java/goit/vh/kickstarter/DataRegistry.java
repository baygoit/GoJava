package goit.vh.kickstarter;

import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class DataRegistry {
    private Output output = new Output();

    private Map<Integer, ArrayList<ProjectModel>> categories;

    public Map<Integer, ArrayList<ProjectModel>> getCategories() {
        return categories;
    }


    public void registerCategories(Map<Integer, ArrayList<ProjectModel>> categories) {
        this.categories = categories;
    }

    public ArrayList<ProjectModel> getProjectList(int index) {
        if (categories.get(index) != null) {
            return categories.get(index);
        } else {
            output.println("You choose not sutable variant, try more.");
            return null;
        }
    }

    public ProjectModel getProject(int[] path) {
        if (categories.get(path[0]).size() < path[1]  ||(path[1] - 1)<0) {
        //TODO renaime, make more understendeble. Use Enume
            //  output.println("You choose not sutable variant, try more.");
            return null;
        }
        return categories.get(path[0]).get(path[1] - 1);
    }
}
