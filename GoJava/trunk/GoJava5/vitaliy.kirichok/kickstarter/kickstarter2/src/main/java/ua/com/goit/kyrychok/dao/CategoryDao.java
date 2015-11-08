package ua.com.goit.kyrychok.dao;

import ua.com.goit.kyrychok.domain.Category;

import java.util.List;

public interface CategoryDao {

    String getWelcomeMessage();

    List<Category> fetch();

    Category get(int id);

    void add(Category category);

}
