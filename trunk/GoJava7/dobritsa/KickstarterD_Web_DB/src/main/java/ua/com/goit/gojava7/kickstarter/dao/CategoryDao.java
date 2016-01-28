package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.model.Category;

import java.util.List;

public interface CategoryDao {

    Category get(Long categoryId);
    List<Category> getAll();

}
