package KickStarter.dao;

import KickStarter.model.Category;
import KickStarter.model.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 12.07.15
 * Time: 16:12
 * @version: 1.0
 */
public interface LoadingData {
    public void load();
    public Map<Category, ArrayList<Project>> getMapping();
    public ArrayList<Category> getCategoryList();
    public void saveData();
}
