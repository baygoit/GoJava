package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

import java.util.List;

public interface CategoryDao {
    List<Category> getCategories();

    void add(Category category);

    void update(Project project);
}
