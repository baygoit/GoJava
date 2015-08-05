package KickStarter.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 12.07.15
 * Time: 15:45
 * @version: 1.0
 */
public class MainPageModel {
    private List<Category> catalogCategory = new ArrayList<Category>();
    private Map<Category, ArrayList<Project>> mappingProjectOfCategory = new HashMap<>();
    private List<Integer> userChoice;

    public void setModelSource(Map<Category, ArrayList<Project>> mappingProjectOfCategory, ArrayList<Category> catalogCategory){
        this.mappingProjectOfCategory = mappingProjectOfCategory;
        this.catalogCategory = catalogCategory;
//        for (Object elem : mappingProjectOfCategory.keySet()){
//            catalogCategory.add((Category)elem);
//        }
    }

    public List<Category> getCatalogCategory() {
        return catalogCategory;
    }

    public List<Project> getProject(Category elemCategory) {
        List<Project> referProject = mappingProjectOfCategory.get(elemCategory);
        return referProject;
    }

    public List<Integer> getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(List<Integer> userChoice) {
        this.userChoice = userChoice;
    }
}
