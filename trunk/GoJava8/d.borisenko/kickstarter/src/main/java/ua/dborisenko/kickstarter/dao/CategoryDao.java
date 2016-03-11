package ua.dborisenko.kickstarter.dao;

import java.util.ArrayList;
import java.util.List;

import ua.dborisenko.kickstarter.domain.Category;

public abstract class CategoryDao {

    protected List<Category> categories = new ArrayList<Category>();

    public abstract void fillCategories();

    public void add(Category category) {
        categories.add(category);
    }

    public Category getByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Category not found.");
    }

    public Category getById(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        throw new IllegalArgumentException("Category not found.");
    }

    public Category getByListNumber(int number) {
        return categories.get(number);
    }

    public List<Category> getAll() {
        return categories;
    }
}
