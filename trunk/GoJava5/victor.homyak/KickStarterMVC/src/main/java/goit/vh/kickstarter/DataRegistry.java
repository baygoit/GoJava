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
    private Map<Integer, String> categoriesForMainPage;

    public Map<Integer, String> getCategories() {
        categoriesForMainPage = new HashMap<>();
        for (int i = 0; i < categories.size(); i++) {
            categoriesForMainPage.put(i + 1, categories.get(i + 1).get(0).getParentName());
        }
        return categoriesForMainPage;
    }

    public void registerCategories(Map<Integer, ArrayList<ProjectModel>> categories) {
        this.categories = categories;
    }

    public ArrayList<ProjectModel> getProjectList(int index) throws NullPointerException {
        return categories.get(index);
    }

    public ProjectModel getProject(int[] path) throws IndexOutOfBoundsException {
        return categories.get(path[0]).get(path[1] - 1);
    }
}
