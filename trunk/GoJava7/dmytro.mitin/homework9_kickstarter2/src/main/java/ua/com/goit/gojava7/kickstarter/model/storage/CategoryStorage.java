package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.Category;

import java.util.List;

public interface CategoryStorage {
    List<Category> getCategories();

    void add(Category category);
}
