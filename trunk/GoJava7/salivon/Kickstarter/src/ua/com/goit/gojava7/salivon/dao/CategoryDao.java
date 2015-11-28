package ua.com.goit.gojava7.salivon.dao;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Category;

public interface CategoryDao {

    public List<Category> getAllCategories();

    public Category getCategory(int idCategory);
}
