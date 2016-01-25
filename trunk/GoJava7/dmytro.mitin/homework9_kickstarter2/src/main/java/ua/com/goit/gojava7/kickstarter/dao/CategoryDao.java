package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getCategories();

    void add(Category category);
}
