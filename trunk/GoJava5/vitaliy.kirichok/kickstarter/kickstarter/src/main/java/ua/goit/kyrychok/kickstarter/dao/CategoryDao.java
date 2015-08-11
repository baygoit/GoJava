package ua.goit.kyrychok.kickstarter.dao;

import ua.goit.kyrychok.kickstarter.model.Category;

import java.util.List;

public interface CategoryDao {

    String getWelcomeMessage();

    List<Category> fetch();

    Category get(int id);

    void add(Category category);

}
