package goit.vh.kickstarter;

import goit.vh.kickstarter.model.Category;
import goit.vh.kickstarter.model.Project;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataRegistry {

    private static final String DEFAULT_HELLO_MSG = "Hello on KickStarter";

    private Category[] categories = new Category[0];

    private    Map<Integer, Project[]> hm = new HashMap<Integer, Project[]>();


    public String getHelloMsg() {
         return DEFAULT_HELLO_MSG;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void registerCategories(Category[] categories) {
        this.categories = categories;
    }

    public void registerMapOfProjects(Map<Integer, Project[]> hm){
        this.hm = hm;
    }

    public Project[] getProjectList(int index) {
        return hm.get(index);
    }

    public Project getProject(int[]path) {
        return hm.get(path[0])[1];
    }
}
