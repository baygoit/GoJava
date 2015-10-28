package ua.com.goit.java5.dm.kickstarter.dao;

import java.util.ArrayList;
import java.util.List;
import ua.com.goit.java5.dm.kickstarter.model.Category;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/12/15
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryDao {

    private List<Category> categoryList = new ArrayList<>();

    public List<Category> getAllCategories() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
