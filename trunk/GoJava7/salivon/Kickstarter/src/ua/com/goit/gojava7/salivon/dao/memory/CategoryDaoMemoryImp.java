package ua.com.goit.gojava7.salivon.dao.memory;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.dao.CategoryDao;
import ua.com.goit.gojava7.salivon.stores.StoreCategories;

public class CategoryDaoMemoryImp implements CategoryDao {

    private StoreCategories storeCategories = new StoreCategories();

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = storeCategories.getCategories();
        return categories;
    }

    @Override
    public Category getCategory(int idCategory) {
        Category requestedCategory = null;
        List<Category> categories = storeCategories.getCategories();
        for (Category category : categories) {
            if (category.getId() == idCategory) {
                requestedCategory = category;
                break;
            }
        }
        return requestedCategory;
    }

}
