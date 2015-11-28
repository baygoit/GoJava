package ua.com.goit.gojava7.kickstarter.dao.file;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.util.FileDAO;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryFileDAO extends FileDAO<Category> implements CategoryDAO {

    public CategoryFileDAO() {
        super(Category.class);
    }

    public CategoryFileDAO(String pathToFile) {
        super(Category.class, pathToFile);
    }

    @Override
    public Category get(int index) {
        for (Category element : getAll()) {
            if (element.getId() == index) {
                return element;
            }
        }
        return null;
    }

    
    
}
