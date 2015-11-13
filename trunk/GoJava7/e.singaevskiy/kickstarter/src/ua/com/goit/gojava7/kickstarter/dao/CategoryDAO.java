package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.beans.Category;

public class CategoryDAO extends CommonDAO<Category> {

    public CategoryDAO() {
        dataSource.add(new Category("Art"));
        dataSource.add(new Category("Music"));
        dataSource.add(new Category("Sports"));
    }

    public Category getByName(String name) {
        Category category = null;
        for (Category element : dataSource) {
            if (element.getName().equals(name)) {
                category = element;
                break;
            }
        }
        return category;
    }

}
